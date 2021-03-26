package com.example.Alumno;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, String>{
	
	
	Optional<Alumno> findStudentByDni(String dni);
}
