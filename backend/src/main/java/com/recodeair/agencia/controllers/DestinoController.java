package com.recodeair.agencia.controllers;

import com.recodeair.agencia.entities.Destino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.recodeair.agencia.dto.DestinoDTO;
import com.recodeair.agencia.services.DestinoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/destinos")
public class DestinoController {
	
	@Autowired
	private DestinoService service;

	@GetMapping
	public Page<DestinoDTO> findAll(Pageable pageable){
		return service.findAll(pageable);
	}

	@GetMapping(value = "/{id}")
	public DestinoDTO findById(@PathVariable Long id){
		return service.findById(id);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody DestinoDTO objDto, @PathVariable Long id){
		Destino obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(id, obj);
		return ResponseEntity.noContent().build();
	}

	@PostMapping
	public ResponseEntity<Destino> insert(@RequestBody Destino obj){
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

