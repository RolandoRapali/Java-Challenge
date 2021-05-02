package com.example.Alumno.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Alumno.Excepciones.ManejoExcepcion;
import com.example.Alumno.Excepciones.PedidoExcepcion;
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
		Alumno estudianteOpcional = alumnoRepositorio.findByDni(dni);
		if (estudianteOpcional == null) {
			throw new PedidoExcepcion("No existe el dni(traer alumno)");
		}
		return estudianteOpcional;
	}

	public void agregarNuevoAlumno(Alumno alumno)  throws Exception {
		Alumno estudianteOpcional = alumnoRepositorio.findByDni(alumno.getDni());
		if (estudianteOpcional != null) {
			throw new PedidoExcepcion("El dni ya existe");
		}
		System.out.println(alumno);
		alumnoRepositorio.save(alumno);
	}
}
