package com.example.demo.repository;

import com.example.demo.models.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PembeliRepository extends JpaRepository<Pembeli, Integer> {
}
