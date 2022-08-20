package com.sinaukoding21.belajar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Supplier")
@Getter
@Setter
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_supplier;

    @Column(name = "nama_supplier")
    private String nama_supplier;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "alamat")
    private String alamat;

    @Transient
    @OneToMany(mappedBy = "supplier")
    private List<Barang> barang;
}
