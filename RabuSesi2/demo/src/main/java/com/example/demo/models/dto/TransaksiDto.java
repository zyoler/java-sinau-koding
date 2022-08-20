package com.example.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransaksiDto {
    private Integer id;
    private BarangDto barang;
    private PembeliDto pembeli;
    private String tgl_transaksi;
    private String keterangan;
    private PembayaranDto pembayaran;
}
