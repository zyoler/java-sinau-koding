package com.example.TugasAkhir_Perpustakaan.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BukuDto {
    private Integer id;
    private String judul;
    private String tahun_terbit;
    private Integer jumlah;
    private String isbn;
    private PengarangDto pengarang;
    private PenerbitDto penerbit;
}
