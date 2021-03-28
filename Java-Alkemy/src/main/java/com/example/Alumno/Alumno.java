package com.example.Alumno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.MVC.JavaAlkemy.*;

@Entity
@Table(name = "Student")
public class Alumno extends Persona{
	@Column(name = "file",
			nullable = false,
			updatable = true)
	private long legajo;
	
	
	public Alumno(String nombre, String apellido, String dni, long legajo) {
		super(nombre,apellido,dni);
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
