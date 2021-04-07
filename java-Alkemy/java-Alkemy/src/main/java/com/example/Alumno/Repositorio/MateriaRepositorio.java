package com.example.Alumno.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Materia;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Integer> {

	@Query("SELECT s FROM Materia s WHERE s.id = ?1")
	Materia findSubjectById(int id);
	@Query("SELECT s FROM Materia s WHERE s.nombre = ?1")
	Materia findSubjectByName(String name);
}
