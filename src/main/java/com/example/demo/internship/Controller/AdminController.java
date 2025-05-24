package com.example.demo.internship.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.internship.Repository.AdminRepo;
import com.example.demo.internship.model.Admin;

@RestController
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private AdminRepo adminrepo;
	@PostMapping("/admin/login")
	public ResponseEntity<String>Adminlogin(@RequestBody Admin admin) {
		String username=admin.getUsername();
		String password=admin.getPassword();
		Optional<Admin> savedadmin=adminrepo.findByUsernameAndPassword(username, password);
		if(savedadmin.isPresent()) {
			return ResponseEntity.ok("login verified succussfully");
		}
		else {
			return ResponseEntity.ok("invalid credentials");
			
		}
		
	}

}
