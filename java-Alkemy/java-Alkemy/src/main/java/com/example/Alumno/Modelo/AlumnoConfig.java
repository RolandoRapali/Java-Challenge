package com.example.Alumno.Modelo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Alumno.Repositorio.AlumnoRepositorio;

@Configuration
public class AlumnoConfig {

	@Bean
	CommandLineRunner commandLineRunner(AlumnoRepositorio repositorio) {
		return args -> {
			Alumno Rolando = new Alumno("Rolando", "Rapali", "44524785", 12546332l);
			Alumno Axel = new Alumno("Axel", "Bel", "12354778", 12546332l);

			repositorio.saveAll(List.of(Rolando, Axel));
		};
	}
}
