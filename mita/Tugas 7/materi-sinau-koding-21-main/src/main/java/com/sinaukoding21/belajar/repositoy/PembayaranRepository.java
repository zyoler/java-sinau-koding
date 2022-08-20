package com.sinaukoding21.belajar.repositoy;

import com.sinaukoding21.belajar.model.Pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembayaranRepository extends JpaRepository<Pembayaran,Integer> {
}
