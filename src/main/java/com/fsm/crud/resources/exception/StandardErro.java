package com.fsm.crud.resources.exception;

import java.io.Serializable;
import java.time.Instant;

public class StandardErro implements Serializable {
	private static final long serialVersionUID = 1L;

	private String erro;
	private String massage;
	private Integer status;
	private String path;
	private Instant timestamp;
	
	public StandardErro() { }
		
	public StandardErro(String erro, String massage, Integer status, String path, Instant timestamp) {
		this.erro = erro;
		this.massage = massage;
		this.status = status;
		this.path = path;
		this.timestamp = timestamp;
	}



	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
