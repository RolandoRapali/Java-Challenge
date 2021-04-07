package com.example.Alumno.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String registrarAlumno(@RequestParam(name = "dni") String dni, Model model) throws Exception {
		materiaServicio.inscribirAlumno(materiaServicio.traerMateria(1), alumnoServicio.traerAlumno(dni));
		
		return "registration_to_subject";
	}
	
	@RequestMapping(path = "/subjects/all", method = RequestMethod.GET)
	public String traerMaterias(Model model) {
		/*for(Materia materia :materiaServicio.traerTodasMaterias()) {
			System.out.println(materia);
		}*/
		List<Materia> materias = materiaServicio.traerTodasMaterias();
		model.addAttribute("materias", materias);
		
		return "subjects";
		
	}

	@GetMapping("students/registration_student")
	public String materiasInscripto( String dni, Model model) {
		
		List<Materia> inscripciones = materiaServicio.alumnoInscripciones("44524785");
		//Materia materia = materiaServicio.traerMateria(1);
		model.addAttribute("inscripcion", inscripciones);
		return "registration_student";
	}
	
}
