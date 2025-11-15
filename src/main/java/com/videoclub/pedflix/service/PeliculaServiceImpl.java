package com.videoclub.pedflix.service;

import com.videoclub.pedflix.model.Pelicula;
import com.videoclub.pedflix.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public Pelicula actualizar(Long id, Pelicula datos) {
        return peliculaRepository.findById(id)
                .map(p -> {
                    p.setTitulo(datos.getTitulo());
                    p.setAnio(datos.getAnio());
                    p.setSinopsis(datos.getSinopsis());
                    p.setPuntuacion(datos.getPuntuacion());
                    p.setImagen(datos.getImagen());
                    p.setGenero(datos.getGenero());
                    return peliculaRepository.save(p);
                })
                .orElse(null); // más adelante haremos excepciones personalizadas
    }

    @Override
    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }


    @Override
    public Pelicula crear(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public List<Pelicula> listar() {
        return peliculaRepository.findAll();
    }

    @Override
    public List<Pelicula> buscarPorGenero(String genero) {
        return peliculaRepository.findByGenero(genero);
    }
}
