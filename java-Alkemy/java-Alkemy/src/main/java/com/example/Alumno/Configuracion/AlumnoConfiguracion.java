package com.example.Alumno.Configuracion;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;

@Configuration
public class AlumnoConfiguracion {

	@Bean
	CommandLineRunner commandLineRunnerAlumno(AlumnoRepositorio alumnoRepositorio) {
		return args -> {
			Alumno Rolando = new Alumno("Rolando", "Rapali", "44524785", 12546332l);
			Alumno Axel = new Alumno("Axel", "Bel", "12354778", 12546332l);

			alumnoRepositorio.saveAll(List.of(Rolando, Axel));
		};
	}
}
