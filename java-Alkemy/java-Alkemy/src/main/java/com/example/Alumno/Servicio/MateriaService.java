package com.example.Alumno.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Modelo.Materia;
import com.example.Alumno.Repositorio.MateriaRepositorio;

@Service
public class MateriaService {

	private final MateriaRepositorio materiaRepositorio;
	
	@Autowired
	public MateriaService(MateriaRepositorio materiaRepositorio) {
		super();
		this.materiaRepositorio = materiaRepositorio;
	}
	
	public List<Materia> traerTodasMaterias(){
		return materiaRepositorio.findAll();
	}
	
	public List<Materia> alumnoInscripciones(String dni) {
		int contador;
		boolean encontrado;
		List<Materia> materiasInscripto = null;
		for (Materia materia : traerTodasMaterias()) {
			contador = 0;
			encontrado = false;
			while (materia.getLstAlumno().size() > contador && !encontrado) {
				if (materia.getLstAlumno().get(contador).getDni().equals(dni)) {
					materiasInscripto.add(materia);
					encontrado = true;
				}
				contador++;
			}
		}
		return materiasInscripto;
	}

	public List<Materia> materiasDisponibles(String dni){
		List<Materia> materiasDisponibles = null;
		for(Materia materia: traerTodasMaterias()) {
			for(Materia materiaInscripto: alumnoInscripciones(dni))
			if(materiaInscripto.getId() != materia.getId()) {
				materiasDisponibles.add(materia);
			}
		}
		return materiasDisponibles;
	}
	
}
