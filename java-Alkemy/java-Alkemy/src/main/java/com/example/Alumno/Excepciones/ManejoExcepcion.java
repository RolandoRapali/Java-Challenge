package com.example.Alumno.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoExcepcion {
	
	@ExceptionHandler(value = {PedidoExcepcion.class})
	public ResponseEntity<Object> manejoApiPedidoExcepcion(PedidoExcepcion e){
		HttpStatus exists = HttpStatus.INTERNAL_SERVER_ERROR;
		ApiExcepcion apiExcepcion = new ApiExcepcion(
				e.getMessage(),
				exists
				);
		return new ResponseEntity<>(apiExcepcion, exists);
	}
	
	
}
