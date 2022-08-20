package com.example.Bootcamp.SinauKoding.service;

import com.example.Bootcamp.SinauKoding.model.User;
import com.example.Bootcamp.SinauKoding.model.UserMapper;
import com.example.Bootcamp.SinauKoding.model.dto.UserDto;
import com.example.Bootcamp.SinauKoding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> findAllUser() {
        return repository.findAll();
    }

    @Transactional
    public User createUser(UserDto param) {
        User user = UserMapper.INSTANCE.toEntity(param);
        user = repository.save(user);
        return user;
    }

    public void deleteUser(int id) {
        User data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public User updateUser(int id, User user) {
        User data = repository.findById(id).orElseThrow(null);
        data.setUsername(user.getUsername() != null ? user.getUsername() : data.getUsername());
        data.setAddress(user.getAddress() != null ? user.getAddress() : data.getAddress());
        data.setProfileName(user.getProfileName() != null ? user.getProfileName() : data.getProfileName());
        data.setPhone(user.getPhone() != null ? user.getPhone() : data.getPhone());

        return repository.save(data);
    }
}
