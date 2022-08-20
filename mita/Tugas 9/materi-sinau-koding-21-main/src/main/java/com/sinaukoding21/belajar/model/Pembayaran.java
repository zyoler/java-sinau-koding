package com.sinaukoding21.belajar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pembayaran")
@Getter
@Setter
public class Pembayaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pembayaran;

    @Column(name = "tgl_bayar")
    private String tgl_bayar;

    @Column(name = "total")
    private Double total;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @OneToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi",referencedColumnName = "id_transaksi")
    private Transaksi transaksi;

}
