import java.util.ArrayList;

public class ListaReproduccion {

    private String nombre;
    private ArrayList<Pelicula> peliculas;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.peliculas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Pelicula agregada a la lista: " + pelicula.getNombre());
    }

    public void mostrarPeliculas() {
        System.out.println("Lista: " + nombre);

        if (peliculas.isEmpty()) {
            System.out.println("La lista no contiene peliculas.");
        } else {
            for (Pelicula pelicula : peliculas) {
                pelicula.mostrarInformacion();
            }
        }
    }
}
