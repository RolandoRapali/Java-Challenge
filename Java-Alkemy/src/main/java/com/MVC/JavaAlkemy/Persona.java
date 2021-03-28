package com.MVC.JavaAlkemy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {
	@Column(name = "first_name",
			nullable = false,
			length = 50)
	protected String nombre;
	@Column(name = "last_name",
			nullable = false,
			length = 50)
	protected String apellido;
	@Id
	@Column(name = "dni",
			unique = true,
			nullable = false,
			length = 10)
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
