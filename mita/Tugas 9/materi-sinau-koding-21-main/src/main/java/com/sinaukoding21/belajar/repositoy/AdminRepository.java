package com.sinaukoding21.belajar.repositoy;

import com.sinaukoding21.belajar.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUsername(String username);
}
