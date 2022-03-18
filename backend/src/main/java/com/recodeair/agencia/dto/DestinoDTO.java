package com.recodeair.agencia.dto;


import java.util.HashSet;

import java.util.Set;



import com.recodeair.agencia.entities.Destino;
import com.recodeair.agencia.entities.Pedido;

public class DestinoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String imagem;
	private Double preco;
	
	
	private Set<Pedido> pedidos = new HashSet<>();
	
	
	
	public DestinoDTO() {
	}

	public DestinoDTO(Long id, String nome, String descricao, String imagem, Double preco, Set<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
		this.pedidos = pedidos;
	}
	
	public DestinoDTO(Destino destino) {
		id = destino.getId();
		nome = destino.getNome();
		descricao = destino.getDescricao();
		imagem = destino.getImagem();
		preco = destino.getPreco();
		pedidos = destino.getPedidos();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}
}
