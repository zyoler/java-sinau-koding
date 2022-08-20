package com.example.TugasAkhir_Perpustakaan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Penerbit")
@Setter
@Getter
public class Penerbit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "telp")
    private String telp;

    @Transient
    @OneToMany(mappedBy = "penerbit")
    private List<Buku> buku;
}
