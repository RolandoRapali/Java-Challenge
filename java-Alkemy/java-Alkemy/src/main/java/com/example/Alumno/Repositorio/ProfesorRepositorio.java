package com.example.Alumno.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Profesor;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, String>{

	Optional<Profesor> findProfessorByDni(String dni);
}
