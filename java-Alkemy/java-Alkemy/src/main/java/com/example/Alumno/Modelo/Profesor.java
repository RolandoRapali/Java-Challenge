package com.example.Alumno.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//import com.example.javaAlkemy.*;

@Entity
@Table(name="Professor")
public class Profesor extends Persona{
	@Column(name = "is_active",
			nullable = false)
	private boolean activo;

	public Profesor(String nombre, String apellido, String dni, boolean activo) {
		super(nombre, apellido, dni);
		this.activo = activo;
	}

	public Profesor() {
		super();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Profesor [activo=" + activo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
}
