package com.example.Profesor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ProfesorService {
	
	private final ProfesorRepositorio profesorRepositorio;
	
	@Autowired
	public ProfesorService(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
	}
	
	public List<Profesor> getProfesor(){
		return profesorRepositorio.findAll();
	}
	
}
