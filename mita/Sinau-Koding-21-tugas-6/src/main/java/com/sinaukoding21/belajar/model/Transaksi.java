package com.sinaukoding21.belajar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaksi;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column(name = "tgl_transaksi")
    private String tgl_transaksi;

    @Column(name = "keterangan")
    private String keterangan;

    @Transient
    @OneToOne(mappedBy = "transaksi")
    private Pembayaran pembayaran;
}
