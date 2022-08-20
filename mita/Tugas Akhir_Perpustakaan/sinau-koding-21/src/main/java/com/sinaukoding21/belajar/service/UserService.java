package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.model.User;
import com.sinaukoding21.belajar.model.dto.UserDto;
import com.sinaukoding21.belajar.model.mapper.UserMapper;
import com.sinaukoding21.belajar.repositoy.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class UserService {
        @Autowired
        UserRepository userRepository;

        public List<UserDto> findAllUser(){
            return UserMapper.INSTANCE.toDtoList(userRepository.findAll());
        }
        public UserDto createUser(UserDto param){
            User user = UserMapper.INSTANCE.toEntity(param);
            return UserMapper.INSTANCE.toDto(userRepository.save(user));
        }
        public UserDto findByIdUser(Integer id){
            return UserMapper.INSTANCE.toDto(userRepository.findById(id).orElseThrow(null));
        }


        public boolean deleteUser(int id){
            User data = userRepository.findById(id).orElseThrow(null);
            try{
                userRepository.delete(data);
                return true;
            }catch(Exception e){
                return false;
            }
        }
        public User updateUser(int id,User user){
            User data = userRepository.findById(id).orElseThrow(null);
            data.setUsername(user.getUsername()!=null?user.getUsername():data.getUsername());
            data.setPassword(user.getPassword()!=null?user.getPassword():data.getPassword());
            data.setEmail(user.getEmail()!=null?user.getEmail():data.getEmail());
            data.setRole(user.getRole()!=null?user.getRole():data.getRole());
            return  userRepository.save(data);


        }
    }

