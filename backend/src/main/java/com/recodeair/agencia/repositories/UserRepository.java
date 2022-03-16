package com.recodeair.agencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recodeair.agencia.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
