package com.sinaukoding21.belajar.controller;

import com.sinaukoding21.belajar.common.Response;
import com.sinaukoding21.belajar.model.dto.AdminDto;
import com.sinaukoding21.belajar.model.dto.AuthRequestDto;
import com.sinaukoding21.belajar.model.dto.RegistrationDto;
import com.sinaukoding21.belajar.service.AdminService;
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
    public Response doLogin(@RequestBody AuthRequestDto param) {
        AdminDto data = adminService.doLogin(param);
        return new Response(data, data != null ? "Login Sukses" : "Login gagal", HttpStatus.OK);
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDto param){
        RegistrationDto data = adminService.doRegister(param);
        return new Response(data, data != null ? "Registrasi berhasil" : "Registrasi gagal", HttpStatus.OK);
    }
}
