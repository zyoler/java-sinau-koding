package com.sinaukoding21.belajar.service;

import com.sinaukoding21.belajar.config.JwtTokenUtil;
import com.sinaukoding21.belajar.model.Admin;
import com.sinaukoding21.belajar.model.dto.AdminDto;
import com.sinaukoding21.belajar.model.dto.AuthRequestDto;
import com.sinaukoding21.belajar.model.dto.RegistrationDto;
import com.sinaukoding21.belajar.model.mapper.AdminMapper;
import com.sinaukoding21.belajar.repositoy.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private Admin findById(Integer id){
        return adminRepository.findById(id).orElseThrow(null);
    }

    public AdminDto doLogin(AuthRequestDto admin){
        Admin currentAdmin = adminRepository.findByUsername(admin.getUsername());
        if(currentAdmin == null){
            return AdminMapper.INSTANCE.toDto(null);
        }else if(currentAdmin.getPassword() != null && BCrypt.checkpw(admin.getPassword(), currentAdmin.getPassword())){
            UserDetails userDetails = new User(currentAdmin.getUsername(), currentAdmin.getPassword(), new ArrayList<>());
            currentAdmin.setToken(jwtTokenUtil.doGenerateToken(userDetails));
            return AdminMapper.INSTANCE.toDto(currentAdmin);
        }
        return null;
    }

    public RegistrationDto doRegister(RegistrationDto param){
        Admin admin = adminRepository.findByUsername(param.getUsername());

        if (admin != null){
            return null;
        }
        param.setPassword(BCrypt.hashpw(param.getPassword(), BCrypt.gensalt()));

        admin = adminRepository.save(AdminMapper.INSTANCE.toUserFromRegistrationDto(param));
        return AdminMapper.INSTANCE.toRegistrationDto(admin);
    }
}
