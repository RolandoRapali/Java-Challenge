package com.example.Alumno.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Modelo.Materia;
import com.example.Alumno.Servicio.AlumnoServicio;
import com.example.Alumno.Servicio.MateriaServicio;

@Controller
public class MateriaControl {

	
	private final MateriaServicio materiaServicio;
	private final AlumnoServicio alumnoServicio;
	
	

	public MateriaControl(MateriaServicio materiaServicio, AlumnoServicio alumnoServicio) {
		this.materiaServicio = materiaServicio;
		this.alumnoServicio = alumnoServicio;
	}
	
	@PostMapping("students/registration_student/add")
	public String registrarAlumno(@RequestParam(name = "dni", defaultValue = "44524785") String dni, Model model) throws Exception {
		materiaServicio.inscribirAlumno(materiaServicio.traerMateria(1), alumnoServicio.traerAlumno(dni));
		
		return "registration_to_subject";
	}

	@GetMapping("students/registration_student")
	public String materiasInscripto(@RequestParam(name = "dni") String dni, Model model) {
		
		//List<Materia> inscripciones = materiaServicio.alumnoInscripciones(dni);
		Materia materia = materiaServicio.traerMateria(1);
		model.addAttribute("inscripcion", materia);
		
		return "registration_student";
	}
	
}
