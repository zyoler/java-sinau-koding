package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeminjamanDto {
    private Integer id;
    private String tgl_pinjam;
    private String tgl_kembali;
    private AnggotaDto anggota;
    private PetugasDto petugas;
}
