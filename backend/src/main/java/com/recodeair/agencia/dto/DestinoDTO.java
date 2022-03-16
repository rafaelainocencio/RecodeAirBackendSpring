package com.recodeair.agencia.dto;

import com.recodeair.agencia.entities.Destino;

public class DestinoDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String imagem;
	private Double preco;
	
	public DestinoDTO() {
	}

	public DestinoDTO(Long id, String nome, String descricao, String imagem, Double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
	}
	
	public DestinoDTO(Destino destino) {
		id = destino.getId();
		nome = destino.getNome();
		descricao = destino.getDescricao();
		imagem = destino.getImagem();
		preco = destino.getPreco();
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
}
