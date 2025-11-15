package com.videoclub.pedflix.config;

import com.videoclub.pedflix.model.Pelicula;
import com.videoclub.pedflix.repository.PeliculaRepository;
import com.videoclub.pedflix.model.Rol;
import com.videoclub.pedflix.model.Usuario;
import com.videoclub.pedflix.repository.RolRepository;
import com.videoclub.pedflix.repository.UsuarioRepository;
import com.videoclub.pedflix.security.TripleHash;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final PeliculaRepository peliculaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public DataLoader(
            PeliculaRepository peliculaRepository,
            UsuarioRepository usuarioRepository,
            RolRepository rolRepository
    ) {
        this.peliculaRepository = peliculaRepository;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public void run(String... args) {

        // CREAR PELÍCULAS
        if (peliculaRepository.count() == 0) {

            Pelicula p1 = new Pelicula();
            p1.setTitulo("Matrix");
            p1.setAnio(1999);
            p1.setSinopsis("Neo descubre la verdad sobre la realidad simulada.");
            p1.setPuntuacion(9.0);
            p1.setImagen("https://ejemplo.com/matrix.jpg");
            p1.setGenero("Accion");

            Pelicula p2 = new Pelicula();
            p2.setTitulo("Titanic");
            p2.setAnio(1997);
            p2.setSinopsis("Historia de amor en un barco que se hunde.");
            p2.setPuntuacion(8.5);
            p2.setImagen("https://ejemplo.com/titanic.jpg");
            p2.setGenero("Drama");

            Pelicula p3 = new Pelicula();
            p3.setTitulo("Toy Story");
            p3.setAnio(1995);
            p3.setSinopsis("Los juguetes cobran vida.");
            p3.setPuntuacion(8.3);
            p3.setImagen("https://ejemplo.com/toystory.jpg");
            p3.setGenero("Animacion");

            peliculaRepository.save(p1);
            peliculaRepository.save(p2);
            peliculaRepository.save(p3);

            System.out.println("Películas creadas automáticamente.");
        }

        // CREAR ADMIN
        if (usuarioRepository.count() == 0) {

            Rol rolAdmin = rolRepository.findByNombre("ADMIN")
                    .orElseGet(() -> {
                        Rol r = new Rol();
                        r.setNombre("ADMIN");
                        return rolRepository.save(r);
                    });

            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(TripleHash.hash("admin123")); // triple hash
            admin.setRoles(Set.of(rolAdmin));

            usuarioRepository.save(admin);

            System.out.println("Usuario ADMIN creado: admin / admin123");
        }
    }
}
