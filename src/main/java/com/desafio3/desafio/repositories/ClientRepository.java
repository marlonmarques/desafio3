package com.desafio3.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio3.desafio.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
