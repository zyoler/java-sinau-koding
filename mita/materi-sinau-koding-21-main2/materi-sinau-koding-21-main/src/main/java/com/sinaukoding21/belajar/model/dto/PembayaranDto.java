package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PembayaranDto {
    private Integer id_pembayaran;
    private String tgl_bayar;
    private Double total;
    private TransaksiDto transaksi;
}
