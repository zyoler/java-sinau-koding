package com.example.TugasAkhir_Perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PetugasDto {
    private Integer id;
    private String nama;
    private String telp;
    private String alamat;
    private UserDto user;
}
