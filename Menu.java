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
            System.out.println("4. Salir");
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
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 4);
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
}