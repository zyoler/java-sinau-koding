package com.example.TugasAkhir_Perpustakaan.service;

import com.example.TugasAkhir_Perpustakaan.config.JwtTokenUtil;
import com.example.TugasAkhir_Perpustakaan.model.User;
import com.example.TugasAkhir_Perpustakaan.model.dto.AuthRequestDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.RegistrationDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.UserDto;
import com.example.TugasAkhir_Perpustakaan.model.mapper.UserMapper;
import com.example.TugasAkhir_Perpustakaan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public UserDto doLogin(AuthRequestDto user){
        User currentUser = userRepository.findByUsername(user.getUsername());
        if(currentUser == null){
            return UserMapper.INSTANCE.toDto(null);
        }else if(currentUser.getPassword() != null && BCrypt.checkpw(user.getPassword(), currentUser.getPassword())){
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentUser.getUsername(), currentUser.getPassword(), new ArrayList<>());
            currentUser.setToken(jwtTokenUtil.doGenerateToken(userDetails));
            return UserMapper.INSTANCE.toDto(currentUser);
        }
        return null;
    }

    public RegistrationDto doRegister(RegistrationDto param){
        User user = userRepository.findByUsername(param.getUsername());

        if (user != null){
            return null;
        }
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        user = userRepository.save(UserMapper.INSTANCE.toUserFromRegistrationDto(param));
        return UserMapper.INSTANCE.toRegistrationDto(user);
    }

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
