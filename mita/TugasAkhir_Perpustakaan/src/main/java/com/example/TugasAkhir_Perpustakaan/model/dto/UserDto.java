package com.example.TugasAkhir_Perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;

}
