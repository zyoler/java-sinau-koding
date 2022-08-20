package com.example.demo.controller;

import com.example.demo.common.Response;
import com.example.demo.models.dto.AdminDto;
import com.example.demo.models.dto.AuthRequestDto;
import com.example.demo.models.dto.RegistrationDto;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/do-login")
    public Response doLogin(@RequestBody AuthRequestDto param){
        AdminDto admin = adminService.doLogin(param);

        return new Response(admin, admin != null ? "login sukses" : "login gagal", HttpStatus.OK);
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDto param){
        RegistrationDto data = adminService.doRegister(param);
        return new Response(data, data != null? "Registrasi berhasil":"Registrasi gagal", HttpStatus.OK);
    }
}
