package com.example.Alumno.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, String> {

	public abstract Alumno findByDni(String dni);
	
}
