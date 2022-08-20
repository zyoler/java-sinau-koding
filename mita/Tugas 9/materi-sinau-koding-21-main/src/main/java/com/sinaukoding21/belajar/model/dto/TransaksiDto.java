package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransaksiDto {
    private Integer id_transaksi;
    private BarangDto barang;
    private PembeliDto pembeli;
    private String tgl_transaksi;
    private String keterangan;
}
