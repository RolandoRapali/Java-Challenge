package com.example.Alumno.Excepciones;

import org.springframework.http.HttpStatus;

public class ApiExcepcion {
	private final String mensaje;
	private final HttpStatus httpStatus;
	
	public ApiExcepcion(String mensaje , HttpStatus httpStatus) {
		super();
		this.mensaje = mensaje;
		this.httpStatus = httpStatus;
	}

	public String getMensaje() {
		return mensaje;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
}
