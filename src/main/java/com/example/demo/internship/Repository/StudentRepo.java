package com.example.demo.internship.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.internship.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	Optional<Student> findByUsername(String username);

	Optional<Student> findByEmail(String email);

}
