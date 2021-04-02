package com.example.Alumno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Alumno.Modelo.Profesor;
import com.example.Alumno.Repositorio.ProfesorRepositorio;

public class ProfesorService {

	private final ProfesorRepositorio profesorRepositorio;

	@Autowired
	public ProfesorService(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
	}

	public List<Profesor> getProfesor() {
		return profesorRepositorio.findAll();
	}

}
