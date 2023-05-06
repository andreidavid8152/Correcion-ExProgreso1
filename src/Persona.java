public class Persona {

    //Atributos
    private int id;
    private String nombreCompleto;
    private int edad;
    private int prioridad;
    private int amigos;

    //Constructor
    public Persona(int id, String nombreCompleto, int edad, int prioridad, int amigos) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "Id: " + id + "\nNombre: " + nombreCompleto + "\nEdad: " + edad + "\nPrioridad: " + prioridad + "\nAmigos: " + amigos + "\n\n";
    }
}
