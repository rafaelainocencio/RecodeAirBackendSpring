package com.recodeair.agencia.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recodeair.agencia.dto.AssinanteDTO;
import com.recodeair.agencia.entities.Assinante;
import com.recodeair.agencia.repositories.AssinanteRepository;

@Service
public class AssinanteService {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AssinanteRepository repository;

	@Transactional(readOnly = true)
	public Page<AssinanteDTO> findAll(Pageable pageable) {
		Page<Assinante> result = repository.findAll(pageable);
		Page<AssinanteDTO> page = result.map(x -> new AssinanteDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public AssinanteDTO findById(Long id) {
		Assinante result = repository.findById(id).get();
		AssinanteDTO dto = new AssinanteDTO(result);
		return dto;
	}

	@Transactional
	public Assinante update(Long id, Assinante obj) {
		Assinante novoAssinante = repository.getOne(id);
		updateData(novoAssinante, obj);
		return repository.save(novoAssinante);
	}

	private void updateData(Assinante result, Assinante obj) {
		result.setNome(obj.getNome());
		result.setEmail(obj.getEmail());
	}

	public Assinante fromDTO(AssinanteDTO objDto) {
		return new Assinante(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}

	@Transactional
	public Assinante insert(Assinante obj) {
		emailService.sendOfertaEmail(obj);
		return repository.save(obj);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}