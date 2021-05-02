package com.example.Alumno.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejoExcepcion {
	
	@ExceptionHandler(value = {PedidoExcepcion.class})
	public ResponseEntity<Object> manejoApiPedidoExcepcion(PedidoExcepcion e){
		HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiExcepcion apiExcepcion = new ApiExcepcion(
				e.getMessage(),
				badRequest
				);
		return new ResponseEntity<>(apiExcepcion, badRequest);
	}
}
