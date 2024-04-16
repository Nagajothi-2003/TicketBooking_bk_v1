 package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Register;

@Repository
public interface RegisterRepo extends JpaRepository< Register, Integer>{
	Register findByUsername(String username);
	Register findByEmail(String email);
}
