package com.example.Alumno.Configuracion;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Alumno.Modelo.Profesor;
import com.example.Alumno.Repositorio.ProfesorRepositorio;

@Configuration
public class ProfesorConfiguracion {

	@Bean
	CommandLineRunner commandLineRunnerProfesor(ProfesorRepositorio profesorRepositorio) {
		return args -> {
			Profesor Carlos = new Profesor("Carlos", "Franco", "14225635", true);
			Profesor Pedro = new Profesor("Pedro", "Bernardi", "14225142", true);

			profesorRepositorio.saveAll(List.of(Carlos, Pedro));
		};
	}

}
