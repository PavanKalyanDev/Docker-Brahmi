package com.example.demo.internship.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.internship.service.Emailservice;

@RestController
@RequestMapping("/api")
public class EmailController {
	@Autowired
	private Emailservice emailservice;
	

    @PostMapping("/send-otp")
    public String sendOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        emailservice.sendOtp(email);
        return "OTP sent to your email";
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Map<String, String>> verifyOtp(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String otp = request.get("otp");
        boolean valid = emailservice.verifyOtp(email, otp);
        
        Map<String, String> response = new HashMap<>();
        if (valid) {
            response.put("message", "OTP verified successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid OTP");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }


}
