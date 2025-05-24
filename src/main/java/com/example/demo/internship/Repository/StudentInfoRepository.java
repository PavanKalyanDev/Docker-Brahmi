package com.example.demo.internship.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.internship.model.Student_Info;

public interface StudentInfoRepository extends JpaRepository<Student_Info, Long> {

}
