public class Pelicula {

    private String nombre;
    private String categoria;
    private int duracion;
    private double calificacion;

    public Pelicula(String nombre, String categoria, int duracion, double calificacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.duracion = duracion;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void mostrarInformacion() {
        System.out.println("Titulo: " + nombre);
        System.out.println("Categoria: " + categoria);
        System.out.println("Duracion: " + duracion + " minutos");
        System.out.println("Calificacion: " + calificacion);
        System.out.println("---------------------------");
    }
}