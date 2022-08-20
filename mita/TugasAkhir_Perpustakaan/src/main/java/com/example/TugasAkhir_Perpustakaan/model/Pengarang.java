package com.example.TugasAkhir_Perpustakaan.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pengarang")
@Setter
@Getter
public class Pengarang {
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
    @OneToMany(mappedBy = "pengarang")
    private List<Buku> buku;
}
