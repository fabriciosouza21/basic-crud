package com.fsm.crud.dto;

import java.time.Instant;

import com.fsm.crud.entities.Client;

public class ClientDTO {

	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Integer children;
	private Instant bithDate;
	
	public ClientDTO() { }

	public ClientDTO(Long id, String name, String cpf, Double income, Integer children, Instant bithDate) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
		this.bithDate = bithDate;
	}
	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.children = entity.getChildren();
		this.bithDate = entity.getBithDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Instant getBithDate() {
		return bithDate;
	}

	public void setBithDate(Instant bithDate) {
		this.bithDate = bithDate;
	}
	
	
}
