package com.fsm.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.crud.dto.ClientDTO;
import com.fsm.crud.entities.Client;
import com.fsm.crud.repositoies.ClientRepository;
import com.fsm.crud.services.exception.NotFoundException;

@Service
public class ClientServices {
	@Autowired
	ClientRepository repository;
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(PageRequest pageRequest) {
		Page<Client> clients = repository.findAll(pageRequest);
		return clients.map(x -> new ClientDTO(x));
		 
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> clientOptional = repository.findById(id);
		Client client = clientOptional.orElseThrow(() -> new NotFoundException("Client not found"));
		return new ClientDTO(client);
	}
	@Transactional
	public ClientDTO insert(ClientDTO newClient) {
		Client client = new Client();
		
		client = copyFromDtoToEntity(newClient, client);
		
		return new ClientDTO(client);
	}
	

	private Client copyFromDtoToEntity(ClientDTO newClient, Client client) {
		client.setName(newClient.getName());
		client.setCpf(newClient.getCpf());
		client.setChildren(newClient.getChildren());
		client.setBithDate(newClient.getBirthDate());
		client.setIncome(newClient.getIncome());
		client = repository.save(client);
		return client;
	}

}
