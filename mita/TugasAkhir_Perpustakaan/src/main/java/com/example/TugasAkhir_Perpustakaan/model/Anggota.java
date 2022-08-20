package com.example.TugasAkhir_Perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Anggota")
@Getter
@Setter
public class Anggota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis_kelamin")
    private String jenis_kelamin;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "telp")
    private String telp;

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
