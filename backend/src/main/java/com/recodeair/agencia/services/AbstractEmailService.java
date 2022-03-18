package com.recodeair.agencia.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.recodeair.agencia.entities.Assinante;


public class AbstractEmailService implements EmailService {
	
	@Value("$default.sender")
	private String sender;
	

	@Override
	public void sendOfertaEmail(Assinante obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUser(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUser(Assinante obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Promoção de Dia dos Namorados!");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Confira todas as promoções direto no nosso site!");
		sm.setText("*Site feito para a entrega de um trabalho da RecodePro. Todos os produtos e promoções são fictícias.*");
		return sm;
	}

	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		// TODO Auto-generated method stub
	}
}
