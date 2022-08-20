package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pembeli")
public class Pembeli {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_pembeli")
    private String nama_pembeli;

    @Column(name = "no_telp")
    private String no_telp;

    @Column(name = "alamat")
    private String alamat;

    @Transient
    @OneToOne(mappedBy = "pembeli")
    private Transaksi transaksi;
}
