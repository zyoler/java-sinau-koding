package com.example.TugasAkhir_Perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Petugas")
@Setter
@Getter
public class Petugas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "telp")
    private String telp;

    @Column(name = "alamat")
    private String alamat;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @Transient
    @OneToMany(mappedBy = "petugas")
    private List<Peminjaman> peminjaman;

    @Transient
    @OneToMany(mappedBy = "petugas")
    private List<Pengembalian> pengembalian;
}
