package com.example.demo.internship.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailservice {
	 private final Map<String, String> otpMap = new HashMap<>();

	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendOtp(String email) {
	        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
	        otpMap.put(email, otp);

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Your One-Time Password (OTP) Code");
	        message.setText(
	            "Dear User,\n\n" +
	            "Thank you for using our service. Please find your One-Time Password (OTP) below.\n\n" +
	            "OTP: " + otp + "\n\n" +
	            "This OTP is valid for a limited time only and is required to complete your authentication process. Please do not share it with anyone.\n\n" +
	            "If you did not request this OTP, please ignore this message.\n\n" +
	            "Best regards,\n" +
	            "The Pavan IT Solutions Team"
	        );
	        mailSender.send(message);

	    }

	    public boolean verifyOtp(String email, String otp) {
	        String storedOtp = otpMap.get(email);
	        // Check if the stored OTP exists and is equal to the provided OTP
	        return storedOtp != null && storedOtp.equals(otp);
	    }
	    public void sendWelcomeEmail(String toEmail, String username) {
	        String subject = "🎉 Welcome to Pavan IT Solutions!";
	        String body = "Hi " + username + ",\n\n"
	                + "🎊 Congratulations! Your account has been successfully created.\n"
	                + "We’re excited to have you with us.\n\n"
	                + "Best regards,\nPavan IT Solutions Team";

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);

	        mailSender.send(message);
	    }
	    public void sendPasswordChangedEmail(String toEmail, String username) {
	        String subject = "🔐 Your Password Has Been Changed";
	        String body = "Hi " + username + ",\n\n"
	                + "Your password was successfully changed.\n"
	                + "If you didn't request this, please contact support immediately.\n\n"
	                + "Regards,\nPavan IT Solutions Team";

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	    }

}
