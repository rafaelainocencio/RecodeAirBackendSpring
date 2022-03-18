package com.recodeair.agencia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.recodeair.agencia.services.EmailService;
import com.recodeair.agencia.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class DevConfig {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
	
}
