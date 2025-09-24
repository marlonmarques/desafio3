package com.desafio3.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio3.desafio.dto.ClientDTO;
import com.desafio3.desafio.entities.Client;
import com.desafio3.desafio.repositories.ClientRepository;
import com.desafio3.desafio.service.excepitos.ResourceNotFoundExcepiton;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;


    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        // TODO Auto-generated method stub
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExcepiton("Recurso não encontrado!")
                );
        return new ClientDTO(client);
    }

}
