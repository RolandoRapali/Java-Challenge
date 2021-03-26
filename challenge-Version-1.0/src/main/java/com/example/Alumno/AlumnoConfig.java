package com.example.Alumno;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlumnoConfig {

	@Bean
	CommandLineRunner commandLineRunner(AlumnoRepositorio repositorio) {
		return args ->{
			Alumno Rolando = new Alumno("Rolando", "Rapali", "38355972", 12546332l);
			Alumno Axel = new Alumno("Axel", "Bel", "38355941", 12546332l);
			
			repositorio.saveAll(List.of(Rolando, Axel));
		};
	}
}
