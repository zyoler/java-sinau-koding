package com.example.TugasAkhir_Perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pengembalian")
@Setter
@Getter
public class Pengembalian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tgl_pengembalian")
    private String tgl_pengembalian;

    @Column(name = "denda")
    private Double denda;


    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "peminjaman_id")
    private Peminjaman peminjaman;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anggota_id")
    private Anggota anggota;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petugas_id")
    private Petugas petugas;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pengembalian_detail",joinColumns = @JoinColumn(name = "pengembalian_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "buku_id",referencedColumnName = "id"))
    private List<Buku> buku;
}

