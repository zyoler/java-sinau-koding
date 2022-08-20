package com.sinaukoding21.belajar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pembeli")
@Getter
@Setter
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pembeli;

    @Column(name = "nama_pembeli")
    private String nama_pembeli;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "alamat")
    private String alamat;

    @Transient
    @OneToMany(mappedBy = "transaksi")
    private List<Transaksi> transaksi;
}
