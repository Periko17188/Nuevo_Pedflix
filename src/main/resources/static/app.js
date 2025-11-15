fetch("https://localhost:8443/peliculas")
    .then(r => r.json())
    .then(data => {

        const contenedor = document.getElementById("peliculas");

        data.forEach(p => {
            const div = document.createElement("div");
            div.className = "pelicula";

            div.innerHTML = `
                <img src="${p.imagen}" alt="${p.titulo}">
                <h3>${p.titulo} (${p.anio})</h3>
                <p>${p.sinopsis}</p>
                <p><strong>Género:</strong> ${p.genero}</p>
                <p><strong>Puntuación:</strong> ${p.puntuacion}</p>
            `;

            contenedor.appendChild(div);
        });

    })
    .catch(e => console.error("Error cargando películas:", e));
