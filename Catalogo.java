public class Catalogo {
    public static Pelicula[] obtenerCatalogo() {
        Pelicula[] peliculas = {
            new Pelicula("La toalla del mojado", "Drama", 120, 9.3),
            new Pelicula("La Odisea", "Drama", 170, 9.2),
            new Pelicula("The Backrooms", "Terror", 130, 9.0),
            new Pelicula("Iron Lung", "Terror", 145, 8.9),
            new Pelicula("Deep Sea", "Animacion", 126, 8.8),
            new Pelicula("La historia de la Princesa Kaguya", "Animacion", 180, 9.3),
            new Pelicula("Pinochio", "Animacion", 105, 9.2),
            new Pelicula("El caballero de la Noche", "Accion", 140, 9.0),
            new Pelicula("Superman (Jaime Pistolas)", "Accion", 110, 8.9),
            new Pelicula("Better Call Saul", "Serie", 620, 8.8)
        };

        return peliculas;
    }
}

