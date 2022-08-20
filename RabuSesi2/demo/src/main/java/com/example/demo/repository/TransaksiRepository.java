package com.example.demo.repository;

import com.example.demo.models.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
