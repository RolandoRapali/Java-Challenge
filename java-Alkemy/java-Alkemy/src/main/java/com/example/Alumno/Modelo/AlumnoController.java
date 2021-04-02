package com.example.Alumno.Modelo;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Alumno.Repositorio.AlumnoRepositorio;
import com.example.Alumno.Servicio.AlumnoService;

import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("v1/student")
public class AlumnoController {

	private final AlumnoService alumnoService;

	@Autowired
	private AlumnoRepositorio alumnoRepositorio;

	public AlumnoController(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	@PostMapping
	public void registrarNuevoAlumno(@RequestBody Alumno alumno) throws Exception {
		alumnoService.agregarNuevoAlumno(alumno);
	}

	@GetMapping(path = "/all")
	public Iterable<Alumno> getAllAlumno() {
		return alumnoRepositorio.findAll();
	}

}
