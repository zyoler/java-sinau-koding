package com.example.TugasAkhir_Perpustakaan.repository;

import com.example.TugasAkhir_Perpustakaan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
User findByUsername(String username);
}
