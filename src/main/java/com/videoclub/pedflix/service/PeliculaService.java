package com.videoclub.pedflix.service;

import com.videoclub.pedflix.model.Pelicula;
import java.util.List;

public interface PeliculaService {
    Pelicula crear(Pelicula pelicula);
    List<Pelicula> listar();
    List<Pelicula> buscarPorGenero(String genero);

    Pelicula actualizar(Long id, Pelicula pelicula);
    void eliminar(Long id);

}
