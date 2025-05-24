package com.example.demo.internship.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Student_Info {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dob;
    private String gender;
    private String residentialAddress;
    private String degree;
    private String branch;
    private String status; // "completed" or "pursuing"
    private String university;
    private String college;
    private String collegeAddress;
    private String universityState;
    private String email;
    private String mobile;
    private String internshipDuration;
    private String internshipStartDate;
    private String internshipEndDate;
    private String areaOfInterest;
    private Double cgpa;

    private String referenceLetterPath;
    private String resumePath;
    private String marksheetPath;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCollegeAddress() {
        return collegeAddress;
    }

    public void setCollegeAddress(String collegeAddress) {
        this.collegeAddress = collegeAddress;
    }

    public String getUniversityState() {
        return universityState;
    }

    public void setUniversityState(String universityState) {
        this.universityState = universityState;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getInternshipDuration() {
        return internshipDuration;
    }

    public void setInternshipDuration(String internshipDuration) {
        this.internshipDuration = internshipDuration;
    }

    public String getInternshipStartDate() {
        return internshipStartDate;
    }

    public void setInternshipStartDate(String internshipStartDate) {
        this.internshipStartDate = internshipStartDate;
    }

    public String getInternshipEndDate() {
        return internshipEndDate;
    }

    public void setInternshipEndDate(String internshipEndDate) {
        this.internshipEndDate = internshipEndDate;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public String getReferenceLetterPath() {
        return referenceLetterPath;
    }

    public void setReferenceLetterPath(String referenceLetterPath) {
        this.referenceLetterPath = referenceLetterPath;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getMarksheetPath() {
        return marksheetPath;
    }

    public void setMarksheetPath(String marksheetPath) {
        this.marksheetPath = marksheetPath;
    }
}