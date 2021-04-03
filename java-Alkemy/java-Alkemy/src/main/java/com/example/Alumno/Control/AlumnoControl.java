package com.example.Alumno.Control;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;
import com.example.Alumno.Servicio.AlumnoServicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AlumnoControl {

	private final AlumnoServicio alumnoService;

	public AlumnoControl(AlumnoServicio alumnoService) {
		this.alumnoService = alumnoService;
	}

	@PostMapping("/students/add")
	public void registrarNuevoAlumno(@RequestBody Alumno alumno) throws Exception {
		alumnoService.agregarNuevoAlumno(alumno);
	}

	@GetMapping("/students")
	public String getAllAlumno(Model model) {
		List<Alumno> alumnos = alumnoService.getAlumnos();
		model.addAttribute("students", alumnos);
		return "students_list";
	}

}
