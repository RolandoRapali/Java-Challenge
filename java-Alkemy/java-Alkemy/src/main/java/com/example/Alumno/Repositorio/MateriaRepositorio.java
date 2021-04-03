package com.example.Alumno.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Materia;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, Integer> {

	//Optional<Materia> findSubjectByName(String name);
}
