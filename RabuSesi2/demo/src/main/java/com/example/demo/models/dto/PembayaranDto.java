package com.example.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PembayaranDto {
    private Integer id;
    private String tgl_bayar;
    private Double total;
    private TransaksiDto transaksi;
}
