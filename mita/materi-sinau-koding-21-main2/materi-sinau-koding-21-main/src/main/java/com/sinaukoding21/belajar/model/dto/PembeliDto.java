package com.sinaukoding21.belajar.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PembeliDto {
    private Integer id_pembeli;
    private String nama_pembeli;
    private String no_telp;
    private String alamat;
}
