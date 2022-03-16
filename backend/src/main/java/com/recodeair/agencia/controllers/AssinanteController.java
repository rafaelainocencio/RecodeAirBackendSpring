package com.recodeair.agencia.controllers;

import com.recodeair.agencia.entities.Assinante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recodeair.agencia.dto.AssinanteDTO;
import com.recodeair.agencia.services.AssinanteService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/assinantes")
public class AssinanteController {

	@Autowired
	private AssinanteService service;

	@GetMapping
	public Page<AssinanteDTO> findAll(Pageable pageable) {
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public AssinanteDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody AssinanteDTO objDto, @PathVariable Long id) {
		Assinante obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Assinante> insert(@RequestBody Assinante obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
