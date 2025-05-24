package com.example.demo.internship.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.internship.Repository.StudentRepo;
import com.example.demo.internship.model.Student;
import com.example.demo.internship.service.Emailservice;
import com.example.demo.internship.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	@Autowired
	private Emailservice emailserve;
	
    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private JavaMailSender mailSender;
    
  

    @PostMapping("/students/register")
    public ResponseEntity<Student> addNewStudent(@RequestBody Student student) {
        // Save the student
        Student savedStudent = studentservice.savestudent(student);

        // Logging the student registration process
        System.out.println("Student data coming: " + student.getUsername());

        // ✅ Send welcome email
        emailserve.sendWelcomeEmail(savedStudent.getEmail(), savedStudent.getUsername());

        // Return the saved student data with a success status
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }




	@GetMapping("/login")
	    public ResponseEntity<String> login(
	            @RequestParam String username,
	            @RequestParam String password) {

	        Optional<Student> optionalStudent = studentRepository.findByUsername(username);
	        if (optionalStudent.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
	        }

	        Student student = optionalStudent.get();

	        if (!student.getPassword().equals(password)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
	        }

	        return ResponseEntity.ok("Login successful");
	    }
	 @PostMapping("students/reset-password")
	    public ResponseEntity<String> resetPassword(
	            @RequestParam String email,
	            @RequestParam String newPassword) {

	        Optional<Student> studentOptional = studentRepository.findByEmail(email);

	        if (studentOptional.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                 .body("Email not found");
	        }

	        Student student = studentOptional.get();
	        student.setPassword(newPassword); // Stored as plain text (for now)
	        studentRepository.save(student);

	        emailserve.sendPasswordChangedEmail(email, student.getUsername());

	        return ResponseEntity.ok("Password updated successfully");
	    }
	/*
	  @PostMapping("/save")
	    public ResponseEntity<String> saveStudentDetails(
	            @RequestParam("fullName") String fullName,
	            @RequestParam("gender") String gender,
	            @RequestParam("dob") String dob,
	            @RequestParam("collegeName") String collegeName,
	            @RequestParam("aadhar") String aadhar,
	            @RequestParam("sscPercentage") double sscPercentage,
	            @RequestParam("pucPercentage") double pucPercentage,
	            @RequestParam("btechCollegeName") String btechCollegeName,
	            @RequestParam("btechSem7") double btechSem7,
	            @RequestParam("btechSem8") double btechSem8,

	            @RequestParam("aadharFile") MultipartFile aadharFile,
	            @RequestParam("pucCertificate") MultipartFile pucCertificate,
	            @RequestParam("btechCertificate") MultipartFile btechCertificate,
	            @RequestParam("bonafideCertificate") MultipartFile bonafideCertificate,
	            @RequestParam("signature") MultipartFile signature
	    ) {
	        try {
	            // Define upload directory
	            String uploadDir ="E:/Student_Data_files";
	            File dir = new File(uploadDir);
	            if (!dir.exists()) dir.mkdirs();

	            // Save all files with original names
	            saveFile(uploadDir, aadharFile);
	            saveFile(uploadDir, pucCertificate);
	            saveFile(uploadDir, btechCertificate);
	            saveFile(uploadDir, bonafideCertificate);
	            saveFile(uploadDir, signature);

	            // Optionally: Save student data to database here using a Student entity
	            // studentRepository.save(...)

	            return ResponseEntity.ok("Student details and files uploaded successfully.");

	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Failed to upload: " + e.getMessage());
	        }
	    }
	    }

	    private void saveFile(String dirPath, MultipartFile file) throws IOException {
	        if (!file.isEmpty()) {
	            String filePath = dirPath + file.getOriginalFilename();
	            file.transferTo(new File(filePath));
	        }*/
	    }


