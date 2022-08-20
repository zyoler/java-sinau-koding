package com.example.TugasAkhir_Perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Buku")
@Setter
@Getter
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "tahun_terbit")
    private String tahun_terbit;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "isbn")
    private String isbn;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pengarang_id")
    private Pengarang pengarang;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penerbit_id")
    private Penerbit penerbit;

    @JsonIgnore
    @ManyToMany(mappedBy = "buku")
    private List<Peminjaman> peminjaman;

    @JsonIgnore
    @ManyToMany(mappedBy = "buku")
    private List<Pengembalian> pengembalian;
}
