package com.mapstruct_libro.repository;

import com.mapstruct_libro.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}
