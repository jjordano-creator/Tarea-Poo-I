import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private ArrayList<ListaReproduccion> listas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.listas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void crearLista(String nombreLista) {
        ListaReproduccion nuevaLista = new ListaReproduccion(nombreLista);
        listas.add(nuevaLista);
    }

    public ArrayList<ListaReproduccion> getListas() {
        return listas;
    }

    public void mostrarListas() {
        System.out.println("Listas de " + nombre + ":");

        if (listas.isEmpty()) {
            System.out.println("No tiene listas creadas.");
        } else {
            for (ListaReproduccion lista : listas) {
                System.out.println("- " + lista.getNombre());
            }
        }
    }
}
