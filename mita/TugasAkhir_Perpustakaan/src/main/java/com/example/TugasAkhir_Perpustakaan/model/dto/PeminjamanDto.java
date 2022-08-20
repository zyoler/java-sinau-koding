package com.example.TugasAkhir_Perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PeminjamanDto {
    private Integer id;
    private String tgl_pinjam;
    private String tgl_kembali;
    private AnggotaDto anggota;
    private PetugasDto petugas;
}
