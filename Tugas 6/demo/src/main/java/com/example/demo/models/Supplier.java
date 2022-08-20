package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nama_supplier;

    private String no_telp;

    private String alamat;

    @Transient
    @OneToMany(mappedBy = "supplier")
    private List<Barang> barangList;
}
