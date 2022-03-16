package com.recodeair.agencia.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.recodeair.agencia.dto.PedidoDTO;
import com.recodeair.agencia.entities.Pedido;
import com.recodeair.agencia.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService service;

	@GetMapping
	public Page<PedidoDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public PedidoDTO findById(@PathVariable Long id){
		return service.findById(id);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody PedidoDTO objDto, @PathVariable Long id){
		Pedido obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Pedido> insert(@RequestBody Pedido obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

