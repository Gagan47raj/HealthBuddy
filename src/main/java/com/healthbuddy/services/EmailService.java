package com.healthbuddy.services;


public interface EmailService {
	public void sendEmail(String to, String subject, String body);
}
