package com.example.Alumno.Modelo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


@MappedSuperclass
public abstract class Persona {
	@Column(name = "name", nullable = false, length = 50)
	protected String nombre;
	@Column(name = "surname", nullable = false, length = 50)
	protected String apellido;
	@Id
	@Column(name = "dni", nullable = false, length = 10)
	protected String dni;

	public Persona() {
	}

	public Persona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
