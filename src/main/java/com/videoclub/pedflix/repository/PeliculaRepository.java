package com.videoclub.pedflix.repository;

import com.videoclub.pedflix.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    // Buscar por género
    List<Pelicula> findByGenero(String genero);
}