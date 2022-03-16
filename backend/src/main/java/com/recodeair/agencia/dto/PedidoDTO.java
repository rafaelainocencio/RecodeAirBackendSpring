package com.recodeair.agencia.dto;

import java.time.Instant;

import com.recodeair.agencia.entities.Pedido;
import com.recodeair.agencia.entities.User;

public class PedidoDTO {

	private Long id;
	private Instant moment;
	private User client;
	
	public PedidoDTO() {
	}

	public PedidoDTO(Long id, Instant moment, User client) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
	}
	
	public PedidoDTO(Pedido pedido) {
		super();
		id = pedido.getId();
		moment = pedido.getMoment();
		client = pedido.getClient();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
}
