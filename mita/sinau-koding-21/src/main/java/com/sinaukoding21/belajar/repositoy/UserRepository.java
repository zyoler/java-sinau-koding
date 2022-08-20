package com.sinaukoding21.belajar.repositoy;

import com.sinaukoding21.belajar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
