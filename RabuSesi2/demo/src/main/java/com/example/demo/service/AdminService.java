package com.example.demo.service;

import com.example.demo.config.JwtTokenUtil;
import com.example.demo.models.Admin;
import com.example.demo.models.dto.AdminDto;
import com.example.demo.models.dto.AuthRequestDto;
import com.example.demo.models.dto.RegistrationDto;
import com.example.demo.models.mapper.AdminMapper;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        // Mengcek apakah kosong, jika true maka return null
        if(currentAdmin == null){
            return AdminMapper.INSTANCE.toDto(null);
        }else if(currentAdmin.getPassword() != null && BCrypt.checkpw(admin.getPassword(), currentAdmin.getPassword())){
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(currentAdmin.getUsername(), currentAdmin.getPassword(), new ArrayList<>());
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
