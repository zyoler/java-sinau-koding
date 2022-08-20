package com.example.demo.models.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class SupplierDto {
    private Integer id;
    private String nama_supplier;
    private String no_telp;
    private String alamat;
    private List<BarangDto> barangListDto;
}
