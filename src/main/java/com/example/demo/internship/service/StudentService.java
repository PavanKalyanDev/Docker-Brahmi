package com.example.demo.internship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.internship.Repository.StudentRepo;
import com.example.demo.internship.model.Student;

@Service
public class StudentService {
@Autowired
	private StudentRepo sturepo;
	// saving student data
	public Student savestudent(Student student) {
		 return sturepo.save(student);
	}
	
}
