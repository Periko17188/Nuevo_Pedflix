package com.videoclub.pedflix.controller;

import com.videoclub.pedflix.model.Pelicula;
import com.videoclub.pedflix.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return peliculaService.crear(pelicula);
    }

    @GetMapping
    public List<Pelicula> listar(@RequestParam(required = false) String genero) {

        if (genero != null) {
            return peliculaService.buscarPorGenero(genero);
        }

        return peliculaService.listar();
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.actualizar(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
    }


}
