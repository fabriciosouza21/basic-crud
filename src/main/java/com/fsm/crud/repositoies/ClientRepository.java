package com.fsm.crud.repositoies;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.crud.entities.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
