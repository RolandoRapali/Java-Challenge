package com.example.Alumno.Excepciones;

public class PedidoExcepcion extends RuntimeException{

	public PedidoExcepcion(String message) {
		super(message);
	}

	public PedidoExcepcion(String message, Throwable cause) {
		super(message, cause);
	}

}
