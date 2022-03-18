package com.recodeair.agencia.dto;

import java.util.ArrayList;
import java.util.List;

import com.recodeair.agencia.entities.Pedido;
import com.recodeair.agencia.entities.User;

public class UserDTO {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	public UserDTO() {
	}

	public UserDTO(Long id, String nome, String email, String telefone, String senha, List<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.pedidos = pedidos;
		
	}
	
	public UserDTO(User user) {
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
		telefone = user.getTelefone();
		senha = user.getSenha();
		pedidos = user.getPedidos();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

}

	//public UserDTO(User x) {
	//}

	