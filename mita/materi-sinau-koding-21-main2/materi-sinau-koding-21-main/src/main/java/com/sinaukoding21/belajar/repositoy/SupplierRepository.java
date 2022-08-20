package com.sinaukoding21.belajar.repositoy;

import com.sinaukoding21.belajar.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
