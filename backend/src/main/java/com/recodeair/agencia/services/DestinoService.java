package com.recodeair.agencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recodeair.agencia.dto.DestinoDTO;
import com.recodeair.agencia.entities.Destino;
import com.recodeair.agencia.repositories.DestinoRepository;


@Service
public class DestinoService{
	
	@Autowired
	private DestinoRepository repository;

	@Transactional(readOnly = true)
	public Page<DestinoDTO> findAll(Pageable pageable) {
		Page<Destino> result = repository.findAll(pageable);
		Page<DestinoDTO> page = result.map(x -> new DestinoDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public DestinoDTO findById(Long id) {
		Destino result = repository.findById(id).get();
		DestinoDTO dto = new DestinoDTO(result);
		return dto;
	}

	@Transactional
	public Destino update(Long id, Destino obj){
		Destino novoDestino = repository.getOne(id);
		updateData(novoDestino, obj);
		return repository.save(novoDestino);
	}

	private void updateData(Destino result, Destino obj) {
		result.setNome(obj.getNome());
		result.setDescricao(obj.getDescricao());
		result.setImagem(obj.getImagem());
		result.setPreco(obj.getPreco());
	}
	public Destino fromDTO(DestinoDTO objDto){
		return new Destino(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getImagem(), objDto.getPreco());
	}

	@Transactional
	public Destino insert(Destino obj){
		return repository.save(obj);
	}

	@Transactional
	public void delete(Long id){
		repository.deleteById(id);
	}
}