package com.example.Alumno.Control;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;
import com.example.Alumno.Servicio.AlumnoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("v1/student")
public class AlumnoController {

	private final AlumnoService alumnoService;

	public AlumnoController(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	@PostMapping
	public void registrarNuevoAlumno(@RequestBody Alumno alumno) throws Exception {
		alumnoService.agregarNuevoAlumno(alumno);
	}

	@GetMapping("/all")
	public String/*Iterable<Alumno>*/ getAllAlumno(Model model) {
		model.addAttribute("Students_list", alumnoService.getAlumnos());//getAlumnos();
		return "students_list";
	}

}