package com.example.Alumno.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "student")
public class Alumno extends Persona {
	@Column(name = "file", nullable = false)
	private long legajo;

	public Alumno(String nombre, String apellido, String dni, long legajo) {
		super(nombre, apellido, dni);
		this.legajo = legajo;
	}

	public Alumno() {
	}

	public long getLegajo() {
		return legajo;
	}

	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}

}
