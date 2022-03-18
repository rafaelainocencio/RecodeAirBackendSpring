package com.recodeair.agencia.dto;

import java.time.Instant;

import com.recodeair.agencia.entities.Destino;
import com.recodeair.agencia.entities.Pedido;
import com.recodeair.agencia.entities.User;

public class PedidoDTO {

	private Long id;
	private Instant moment;
	
	private User client;
	
	private Destino destino;
	
	
	
	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public PedidoDTO() {
	}

	public PedidoDTO(Long id, Instant moment, User client, Destino destino) {
		super();
		this.id = id;
		this.moment = moment;
		this.client = client;
		this.destino = destino;
	}
	
	public PedidoDTO(Pedido pedido) {
		super();
		id = pedido.getId();
		moment = pedido.getMoment();
		client = pedido.getClient();
		destino = pedido.getDestino();
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
