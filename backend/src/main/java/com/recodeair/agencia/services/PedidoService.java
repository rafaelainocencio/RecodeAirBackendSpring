package com.recodeair.agencia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recodeair.agencia.dto.PedidoDTO;
import com.recodeair.agencia.entities.Pedido;
import com.recodeair.agencia.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	@Transactional(readOnly = true)
	public Page<PedidoDTO> findAll(Pageable pageable) {
		Page<Pedido> result = repository.findAll(pageable);
		Page<PedidoDTO> page = result.map(x -> new PedidoDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public PedidoDTO findById(Long id) {
		Pedido result = repository.findById(id).get();
		PedidoDTO dto = new PedidoDTO(result);
		return dto;
	}

	@Transactional
	public Pedido update(Long id, Pedido obj) {
		Pedido novoPedido = repository.getOne(id);
		updateData(novoPedido, obj);
		return repository.save(novoPedido);
	}

	private void updateData(Pedido result, Pedido obj) {
		result.setMoment(obj.getMoment());
	}

	public Pedido fromDTO(PedidoDTO objDto) {
		return new Pedido(objDto.getId(), objDto.getMoment(), objDto.getClient(), objDto.getDestino());
	}

	@Transactional
	public Pedido insert(Pedido obj) {
		return repository.save(obj);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}