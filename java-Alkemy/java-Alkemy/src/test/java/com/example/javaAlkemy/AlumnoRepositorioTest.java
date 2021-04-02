package com.example.javaAlkemy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.Alumno.Modelo.Alumno;
import com.example.Alumno.Repositorio.AlumnoRepositorio;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class AlumnoRepositorioTest {

	@Autowired
	private AlumnoRepositorio repositorio;
	
	
	@Test
	public void testCreateStudent() {
		Alumno alumnoSave = repositorio.save(new Alumno("Rol", "pal", "1114523", 111452l));
		
		assertThat(alumnoSave.getDni().equals(String.format("1114523", alumnoSave)));
	}
}
