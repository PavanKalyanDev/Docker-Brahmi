package com.example.demo.internship.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.internship.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
	   Optional<Admin> findByUsernameAndPassword(String username, String password);

}
