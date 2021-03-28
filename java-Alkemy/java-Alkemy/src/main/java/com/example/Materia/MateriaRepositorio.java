package com.example.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, String> {

}
