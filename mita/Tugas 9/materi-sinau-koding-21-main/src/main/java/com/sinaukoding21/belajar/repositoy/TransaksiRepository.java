package com.sinaukoding21.belajar.repositoy;

import com.sinaukoding21.belajar.model.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi,Integer> {
}
