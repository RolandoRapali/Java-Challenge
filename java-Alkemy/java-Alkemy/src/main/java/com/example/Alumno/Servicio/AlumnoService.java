package com.example.Alumno.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;

@Service
public class AlumnoService {

	private final AlumnoRepositorio alumnoRepositorio;

	@Autowired
	public AlumnoService(AlumnoRepositorio alumnoRepositorio) {
		this.alumnoRepositorio = alumnoRepositorio;
	}

	public List<Alumno> getAlumnos() {
		return alumnoRepositorio.findAll();
	}

	public Optional<Alumno> traerAlumno(String dni) throws Exception {
		Optional<Alumno> estudianteOpcional = alumnoRepositorio.findById(dni);
		if (estudianteOpcional.isEmpty()) {
			throw new Exception("No existe el dni");
		}
		return estudianteOpcional;
	}

	public void agregarNuevoAlumno(Alumno alumno) throws Exception {
		Optional<Alumno> estudianteOpcional = alumnoRepositorio.findStudentByDni(alumno.getDni());
		if (estudianteOpcional.isPresent()) {
			throw new Exception("el estudiante ya esta registrado");
		}
		System.out.println(alumno);
		alumnoRepositorio.save(alumno);
	}
}
