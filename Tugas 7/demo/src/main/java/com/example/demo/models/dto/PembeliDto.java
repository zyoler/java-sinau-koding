package com.example.demo.models.dto;

import com.example.demo.models.Transaksi;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PembeliDto {
    private Integer id;
    private String nama_pembeli;
    private String no_telp;
    private String alamat;
    private TransaksiDto transaksiDto;
}
