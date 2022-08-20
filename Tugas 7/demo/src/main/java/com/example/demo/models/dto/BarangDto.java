package com.example.demo.models.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDto {
    private Integer id;
    private String nama_barang;
    private Double harga;
    private Integer stok;
    private SupplierDto supplierDto;
}
