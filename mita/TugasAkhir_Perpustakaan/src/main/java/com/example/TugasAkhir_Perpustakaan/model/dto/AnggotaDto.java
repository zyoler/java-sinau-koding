package com.example.TugasAkhir_Perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnggotaDto {
    private Integer id;
    private String nama;
    private String jenis_kelamin;
    private String telp;
    private UserDto user;
}
