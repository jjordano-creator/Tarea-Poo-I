import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private ArrayList<Usuario> usuarios;
    private Pelicula[] catalogo;

    public Menu() {
        scanner = new Scanner(System.in);
        usuarios = new ArrayList<>();
        catalogo = Catalogo.obtenerCatalogo();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n=== PETFLIX ===");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar usuarios");
            System.out.println("3. Mostrar catalogo");
            System.out.println("4. Seleccionar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    crearUsuario();
                    break;

                case 2:
                    mostrarUsuarios();
                    break;

                case 3:
                    mostrarCatalogo();
                    break;

                case 4:
                    seleccionarUsuario();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 5);
    }


    private void crearUsuario() {

        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();

        Usuario usuario = new Usuario(nombre);
        usuarios.add(usuario);

        System.out.println("Usuario creado correctamente");
    }


    private void mostrarUsuarios() {

        if(usuarios.isEmpty()) {
            System.out.println("No existen usuarios");
            return;
        }

        for(Usuario usuario : usuarios) {
            System.out.println(usuario.getNombre());
        }
    }


    private void mostrarCatalogo() {

        for(Pelicula pelicula : catalogo) {
            pelicula.mostrarInformacion();
        }
    }


    private void seleccionarUsuario() {

        if(usuarios.isEmpty()) {
            System.out.println("No existen usuarios");
            return;
        }

        System.out.print("Nombre del usuario: ");
        String nombre = scanner.nextLine();

        Usuario usuario = buscarUsuario(nombre);

        if(usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        menuUsuario(usuario);
    }


    private Usuario buscarUsuario(String nombre) {

        for(Usuario usuario : usuarios) {
            if(usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }

        return null;
    }


    private void menuUsuario(Usuario usuario) {

        int opcion;

        do {
            System.out.println("\n=== Usuario: " + usuario.getNombre() + " ===");
            System.out.println("1. Crear lista de reproduccion");
            System.out.println("2. Agregar pelicula a una lista");
            System.out.println("3. Mostrar listas y peliculas");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {

                case 1:
                    crearLista(usuario);
                    break;

                case 2:
                    agregarPeliculaALista(usuario);
                    break;

                case 3:
                    mostrarListas(usuario);
                    break;

                case 4:
                    System.out.println("Volviendo al menu principal...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 4);
    }


    private void crearLista(Usuario usuario) {

        System.out.print("Nombre de la lista: ");
        String nombreLista = scanner.nextLine();

        usuario.crearLista(nombreLista);

        System.out.println("Lista creada correctamente");
    }


    private void agregarPeliculaALista(Usuario usuario) {

        if(usuario.getListas().isEmpty()) {
            System.out.println("El usuario no tiene listas creadas");
            return;
        }

        System.out.println("Listas de " + usuario.getNombre() + ":");
        for(ListaReproduccion lista : usuario.getListas()) {
            System.out.println("- " + lista.getNombre());
        }

        System.out.print("Nombre de la lista: ");
        String nombreLista = scanner.nextLine();

        ListaReproduccion lista = buscarLista(usuario, nombreLista);

        if(lista == null) {
            System.out.println("Lista no encontrada");
            return;
        }

        mostrarCatalogo();

        System.out.print("Nombre de la pelicula a agregar: ");
        String nombrePelicula = scanner.nextLine();

        Pelicula pelicula = buscarPelicula(nombrePelicula);

        if(pelicula == null) {
            System.out.println("Pelicula no encontrada en el catalogo");
            return;
        }

        lista.agregarPelicula(pelicula);
    }


    private ListaReproduccion buscarLista(Usuario usuario, String nombreLista) {

        for(ListaReproduccion lista : usuario.getListas()) {
            if(lista.getNombre().equalsIgnoreCase(nombreLista)) {
                return lista;
            }
        }

        return null;
    }


    private Pelicula buscarPelicula(String nombrePelicula) {

        for(Pelicula pelicula : catalogo) {
            if(pelicula.getNombre().equalsIgnoreCase(nombrePelicula)) {
                return pelicula;
            }
        }

        return null;
    }


    private void mostrarListas(Usuario usuario) {

        if(usuario.getListas().isEmpty()) {
            System.out.println("El usuario no tiene listas creadas");
            return;
        }

        for(ListaReproduccion lista : usuario.getListas()) {
            lista.mostrarPeliculas();
        }
    }
}