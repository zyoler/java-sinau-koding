package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PengembalianDto {
    private Integer id;
    private String tgl_pengembalian;
    private Double denda;
    private PeminjamanDto peminjaman;
    private AnggotaDto anggota;
    private PetugasDto petugas;
}
