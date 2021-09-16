package com.fsm.crud.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fsm.crud.services.exception.NotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StandardErro> notFound(NotFoundException e, HttpServletRequest http){
		StandardErro err = new StandardErro();
		HttpStatus status = HttpStatus.NOT_FOUND;
		err.setErro("not found");
		err.setMassage(e.getMessage());
		err.setStatus(status.value());
		err.setPath(http.getRequestURI());
		err.setTimestamp(Instant.now());
		return ResponseEntity.status(status).body(err);
	}
}
