package com.recodeair.agencia.services;

import org.springframework.mail.SimpleMailMessage;

import com.recodeair.agencia.entities.Assinante;
import com.recodeair.agencia.entities.User;

public interface EmailService {
	
	void sendOfertaEmail(Assinante obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}

