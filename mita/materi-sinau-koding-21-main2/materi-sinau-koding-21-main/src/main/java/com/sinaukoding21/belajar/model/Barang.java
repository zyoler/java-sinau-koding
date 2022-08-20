package com.sinaukoding21.belajar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Barang")
@Getter
@Setter
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_barang;

    @Column(name = "nama_barang")
     private String nama_barang;

    @Column(name = "harga")
    private Double harga;

    @Column(name = "stok")
    private Integer stok;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_supplier",referencedColumnName = "id_supplier")
    private Supplier supplier;

    @Transient
    @OneToOne(mappedBy = "barang",fetch = FetchType.EAGER)
    private Transaksi transaksi;
}
