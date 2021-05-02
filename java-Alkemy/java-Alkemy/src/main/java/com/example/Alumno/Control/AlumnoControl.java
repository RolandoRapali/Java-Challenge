package com.example.Alumno.Control;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.Alumno.Helpers.VistasHtml;
import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;
import com.example.Alumno.Servicio.AlumnoServicio;
import com.sun.istack.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("/students")
public class AlumnoControl {

	private final AlumnoServicio alumnoService;

	public AlumnoControl(AlumnoServicio alumnoService) {
		this.alumnoService = alumnoService;
	}
	
	@GetMapping("/new_student")
	public String alumno(Model model) {
		model.addAttribute("alumno", new Alumno());
		return VistasHtml.STUDENT_FORM;
	}

	@PostMapping("/add")
	public ModelAndView registrarNuevoAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) throws Exception {
		ModelAndView mV = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mV.setViewName(VistasHtml.STUDENT_FORM);
		}else {
			alumnoService.agregarNuevoAlumno(alumno);
			mV.setViewName(VistasHtml.STUDENT_NEW);
			mV.addObject("alumno", alumno);
		}
		return mV;	
	}

	@GetMapping("/all")
	public String getAllAlumno(Model model) {
		model.addAttribute("alumnos", alumnoService.getAlumnos());
		return VistasHtml.STUDENT_LIST;
	}

}
