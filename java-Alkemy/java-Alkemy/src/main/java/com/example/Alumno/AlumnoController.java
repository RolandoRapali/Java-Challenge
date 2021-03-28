package com.example.Alumno;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

@RestController
@RequestMapping(path = "v1/student")
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
	public @ResponseBody Iterable<Alumno> getAllAlumno() {
		return alumnoRepositorio.findAll();
	}

}
