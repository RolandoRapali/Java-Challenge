package com.example.Alumno.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alumno.Modelo.Materia;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, String> {

}
