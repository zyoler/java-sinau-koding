package com.example.TugasAkhir_Perpustakaan.controller;

import com.example.TugasAkhir_Perpustakaan.common.Response;
import com.example.TugasAkhir_Perpustakaan.model.dto.AuthRequestDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.RegistrationDto;
import com.example.TugasAkhir_Perpustakaan.model.dto.UserDto;
import com.example.TugasAkhir_Perpustakaan.service.UserService;
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
    private UserService userService;

    @PostMapping("/do-login")
    public Response doLogin(@RequestBody AuthRequestDto param){
        UserDto admin = userService.doLogin(param);

        return new Response(admin, admin != null ? "login sukses" : "login gagal", HttpStatus.OK);
    }

    @PostMapping("/do-register")
    public Response doRegister(@RequestBody RegistrationDto param){
        RegistrationDto data = userService.doRegister(param);
        return new Response(data, data != null? "Registrasi berhasil":"Registrasi gagal", HttpStatus.OK);
    }
}
