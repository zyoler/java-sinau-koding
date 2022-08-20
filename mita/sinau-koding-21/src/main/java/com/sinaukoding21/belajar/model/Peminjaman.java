package com.sinaukoding21.belajar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Peminjaman")
@Setter
@Getter
public class Peminjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tgl_pinjam")
    private String tgl_pinjam;

    @Column(name = "tgl_kembali")
    private String tgl_kembali;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anggota_id")
    private Anggota anggota;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petugas_id")
    private Petugas petugas;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "peminjaman_detail",joinColumns = @JoinColumn(name = "peminjaman_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "buku_id",referencedColumnName = "id"))
    private List<Buku> buku;

    @Transient
    @OneToOne(mappedBy = "peminjaman",fetch = FetchType.EAGER)
    private Pengembalian pengembalian;
}

