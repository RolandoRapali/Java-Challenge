package com.example.Alumno.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;

@Service
public class AlumnoServicio {

	private final AlumnoRepositorio alumnoRepositorio;

	@Autowired
	public AlumnoServicio(AlumnoRepositorio alumnoRepositorio) {
		this.alumnoRepositorio = alumnoRepositorio;
	}

	public List<Alumno> getAlumnos() {
		return alumnoRepositorio.findAll();
	}

	public Alumno traerAlumno(String dni) throws Exception {
		Alumno estudianteOpcional = alumnoRepositorio.findStudentByDni(dni);
		if (estudianteOpcional == null) {
			throw new Exception("No existe el dni(traer alumno)");
		}
		return estudianteOpcional;
	}

	public void agregarNuevoAlumno(Alumno alumno) throws Exception {
		Alumno estudianteOpcional = alumnoRepositorio.findStudentByDni(alumno.getDni());
		if (estudianteOpcional != null) {
			throw new Exception("el estudiante ya esta registrado");
		}
		System.out.println(alumno);
		alumnoRepositorio.save(alumno);
	}
}
