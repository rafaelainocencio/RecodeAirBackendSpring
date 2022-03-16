package com.recodeair.agencia.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recodeair.agencia.dto.UserDTO;
import com.recodeair.agencia.entities.User;
import com.recodeair.agencia.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<User> result = repository.findAll(pageable);
		Page<UserDTO> page = result.map(x -> new UserDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		User result = repository.findById(id).get();
		UserDTO dto = new UserDTO(result);
		return dto;
	}

	@Transactional
	public User update(Long id, User obj) {
		User novoUser = repository.getOne(id);
		updateData(novoUser, obj);
		return repository.save(novoUser);
	}

	private void updateData(User result, User obj) {
		result.setNome(obj.getNome());
		result.setEmail(obj.getEmail());
		result.setTelefone(obj.getTelefone());
		result.setSenha(obj.getSenha());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getTelefone(), objDto.getSenha());
	}

	@Transactional
	public User insert(User obj) {
		return repository.save(obj);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}