package com.example.Alumno.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Alumno.Modelo.Materia;
import com.example.Alumno.Servicio.MateriaServicio;

@Controller
public class MateriaControl {

	
	private final MateriaServicio materiaServicio;

	
	public MateriaControl(MateriaServicio materiaServicio) {
		this.materiaServicio = materiaServicio;
	}
	
	@GetMapping("students/registration_student")
	public String materiasInscripto(@RequestParam String dni, Model model) {
		List<Materia> Inscripciones = materiaServicio.alumnoInscripciones(dni);
		model.addAttribute("Inscripcion", Inscripciones);
		return "registration_student";
	}
	
	
}
