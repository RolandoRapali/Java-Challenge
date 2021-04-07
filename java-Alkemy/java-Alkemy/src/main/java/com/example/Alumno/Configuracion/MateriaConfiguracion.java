package com.example.Alumno.Configuracion;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Modelo.Materia;
import com.example.Alumno.Repositorio.MateriaRepositorio;

@Configuration
public class MateriaConfiguracion {
	
	@Bean
	CommandLineRunner commandLineRunnerMateria(MateriaRepositorio materiaRepositorio) {
		return args -> {
			Materia matematicas = new Materia("Matematicas", LocalTime.of(8, 00), "una materia con muchos numeros y letras", 0, 10);
			Materia lengua = new Materia("Lengua", LocalTime.of(18, 00), "analisis de las palabras", 0, 10);
			Materia programacion = new Materia("Programacion", LocalTime.of(22, 00), "una materia donde se pueden construir programas", 0, 10);
			matematicas.getLstAlumno().add(new Alumno("Rolando", "Rapali", "44524785", 12546332l));
			materiaRepositorio.saveAll(List.of(matematicas, lengua, programacion));
		};
	}
	
}
