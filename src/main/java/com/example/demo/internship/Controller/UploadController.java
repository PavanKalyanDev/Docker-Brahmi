package com.example.demo.internship.Controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.internship.model.Student_Info;
import com.example.demo.internship.service.Student_Infoservice;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private Student_Infoservice service;

    // Inject the upload directory from application.properties
    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/submit")
    public ResponseEntity<String> submitStudentInfo(
        @RequestParam String name,
        @RequestParam String dob,
        @RequestParam String gender,
        @RequestParam String residentialAddress,
        @RequestParam String degree,
        @RequestParam String branch,
        @RequestParam String status,
        @RequestParam String university,
        @RequestParam String college,
        @RequestParam String collegeAddress,
        @RequestParam String universityState,
        @RequestParam String email,
        @RequestParam String mobile,
        @RequestParam String internshipDuration,
        @RequestParam String internshipStartDate,
        @RequestParam String internshipEndDate,
        @RequestParam String areaOfInterest,
        @RequestParam Double cgpa,
        @RequestParam MultipartFile referenceLetter,
        @RequestParam MultipartFile resume,
        @RequestParam MultipartFile marksheet
    ) throws IOException {

        // Create a subdirectory for the student using their name
        String studentDirPath = uploadDir + name + "/";
        File studentDir = new File(studentDirPath);
        if (!studentDir.exists()) studentDir.mkdirs();  // Create student folder if not exists

        // Get file extensions
        String refExt = getFileExtension(referenceLetter.getOriginalFilename());
        String resExt = getFileExtension(resume.getOriginalFilename());
        String markExt = getFileExtension(marksheet.getOriginalFilename());

        // Set destination file paths
        String referenceLetterPath = studentDirPath + "reference_letter" + refExt;
        String resumePath = studentDirPath + "resume" + resExt;
        String marksheetPath = studentDirPath + "marksheet" + markExt;

        // Save the uploaded files
        referenceLetter.transferTo(new File(referenceLetterPath));
        resume.transferTo(new File(resumePath));
        marksheet.transferTo(new File(marksheetPath));

        // Populate and save student info
        Student_Info student = new Student_Info();
        student.setName(name);
        student.setDob(dob);
        student.setGender(gender);
        student.setResidentialAddress(residentialAddress);
        student.setDegree(degree);
        student.setBranch(branch);
        student.setStatus(status);
        student.setUniversity(university);
        student.setCollege(college);
        student.setCollegeAddress(collegeAddress);
        student.setUniversityState(universityState);
        student.setEmail(email);
        student.setMobile(mobile);
        student.setInternshipDuration(internshipDuration);
        student.setInternshipStartDate(internshipStartDate);
        student.setInternshipEndDate(internshipEndDate);
        student.setAreaOfInterest(areaOfInterest);
        student.setCgpa(cgpa);
        student.setReferenceLetterPath(referenceLetterPath);
        student.setResumePath(resumePath);
        student.setMarksheetPath(marksheetPath);

        service.uploadFiles(student);
        return ResponseEntity.ok("Student information submitted successfully.");
    }

    // Helper method to get file extension (e.g., ".pdf")
    private String getFileExtension(String filename) {
        if (filename != null && filename.contains(".")) {
            return filename.substring(filename.lastIndexOf("."));
        }
        return ""; // Default to empty if no extension
    }
}
