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

	/*
	 * @GetMapping(path = "{alumnoDni}") public Optional<Alumno>
	 * getAlumno(@PathVariable("alumnoDni") String alumnoDni) throws Exception{
	 * return alumnoService.traerAlumno(alumnoDni); }
	 */

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Alumno> getAllAlumno() {
		return alumnoRepositorio.findAll();
	}

	/*
	 * private static final List<Alumno> STUDENTS = Arrays.asList( new
	 * Alumno("james", "bond", "11111111", 1245l), new Alumno("maria", "jones",
	 * "2222222", 1245l), new Alumno("Anna", "Smith", "2222222", 1245l) );
	 * 
	 * @GetMapping(path = "{studentId}") public Alumno
	 * getStudent(@PathVariable("studentId") String alumnoDni) { return
	 * STUDENTS.stream() .filter(Alumno -> alumnoDni.equals(Alumno.getDni()))
	 * .findFirst() .orElseThrow(() -> new IllegalStateException( "Student " +
	 * alumnoDni + " does not exists" )); }
	 */
}
