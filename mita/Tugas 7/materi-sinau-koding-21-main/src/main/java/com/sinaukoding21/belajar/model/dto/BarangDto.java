package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BarangDto {
    private Integer id_barang;
    private String nama_barang;
    private Double harga;
    private Integer stok;
    private SupplierDto supplier;
}