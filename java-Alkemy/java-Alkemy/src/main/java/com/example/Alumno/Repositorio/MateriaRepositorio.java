package com.example.Alumno.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Materia;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Long> {
	
	public abstract Materia findById(int id);
	
	public abstract Materia findByNombre(String name);
}
