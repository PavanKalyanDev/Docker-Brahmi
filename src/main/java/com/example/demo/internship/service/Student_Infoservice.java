package com.example.demo.internship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.internship.Repository.StudentInfoRepository;
import com.example.demo.internship.model.Student_Info;

@Service
public class Student_Infoservice {
	@Autowired
	private StudentInfoRepository student;
	

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    public Student_Info uploadFiles(Student_Info studentInfo) {
        return studentInfoRepository.save(studentInfo);  // Corrected reference
    }

}
