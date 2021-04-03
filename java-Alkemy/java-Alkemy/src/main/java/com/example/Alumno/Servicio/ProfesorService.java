package com.example.Alumno.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumno.Modelo.Profesor;
import com.example.Alumno.Repositorio.ProfesorRepositorio;

@Service
public class ProfesorService {

	private final ProfesorRepositorio profesorRepositorio;

	@Autowired
	public ProfesorService(ProfesorRepositorio profesorRepositorio) {
		this.profesorRepositorio = profesorRepositorio;
	}
	
	public List<Profesor> getProfesor(){
		return profesorRepositorio.findAll();
	}
	
	public Optional<Profesor> traerProfesor(String dni) throws Exception {
		Optional<Profesor> profesorOpcional = profesorRepositorio.findById(dni);
		if (profesorOpcional.isEmpty()) {
			throw new Exception("no existe el profesor");
		}
		return profesorOpcional;
	}
	
	public void agregarProfesor(Profesor profesor) throws Exception{
		Optional<Profesor> profesorOpcional = profesorRepositorio.findProfessorByDni(profesor.getDni());
		if(profesorOpcional.isPresent()) {
			throw new Exception("el profesor ya esta registrado");
		}
		System.out.println(profesor);
		profesorRepositorio.save(profesor);
	}
}
