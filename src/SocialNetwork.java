import java.util.*;


public class SocialNetwork {

    //Atributos (cola - Personas no activas; colaPrioridad - Personas activas; pila - Personas eliminadas)
    private Queue<Persona> cola;
    private Queue<Persona> colaPrioridad;
    private Stack<Persona> pila;

    //Constructor
    public SocialNetwork(){
        cola =  new LinkedList<>();
        colaPrioridad =  new PriorityQueue<>(new Comparator<Persona>() {
            public int compare(Persona p1, Persona p2) {
                if (p1.getPrioridad() < p2.getPrioridad()) {
                    return 1;
                } else if (p1.getPrioridad() > p2.getPrioridad()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        pila = new Stack<>();
    }

    //Metodos

    public Queue<Persona> getCola() {
        return cola;
    }

    public Queue<Persona> getColaPrioridad() {
        return colaPrioridad;
    }

    public Stack<Persona> getPila() {
        return pila;
    }

    public boolean agregarPersona(Persona p){
        boolean value = false;

        if(buscarPersona(p.getNombreCompleto())){
            cola.add(p);
            value = true;
        }


        return value;
    }

    public boolean buscarPersona(String nombre){
        boolean value = true;
        Iterator<Persona> iterador = cola.iterator();

        while (iterador.hasNext()) {
            Persona elemento = iterador.next();
            if (elemento.getNombreCompleto().equals(nombre)){
                value = false;
            }
        }

        return value;
    }

    public Queue<Persona> BuscarPorId(int id, boolean buscarColaActiva) {
        Queue<Persona> encontradas = new LinkedList<>();
        Queue<Persona> colaBuscarP = buscarColaActiva ? colaPrioridad : cola;
        for(Persona p: colaBuscarP){
            if(p.getId() == id){
                encontradas.add(p);
            }
        }
        return encontradas;
    }

    public List<Persona> BuscarPorPrioridad(boolean buscarColaActiva) {
        Queue<Persona> colaBuscarPersona = buscarColaActiva ? colaPrioridad : cola;
        List<Persona> personasEncontradas = new ArrayList<>();
        for(Persona p: colaBuscarPersona){
            if(p.getPrioridad() >= 50){
                personasEncontradas.add(p);
            }
        }
        return personasEncontradas;
    }

}
