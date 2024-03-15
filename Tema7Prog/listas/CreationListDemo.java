package Tema7Prog.listas;

import java.util.ArrayList;
import java.util.List;

public class CreationListDemo {

    public static void main(String[] args) {


        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("John","john@gmail.com", "646558887"));
        personas.add(new Persona("Ann","ann@gmail.com", "646544487"));
        personas.add(new Persona("Louise","louise@gmail.com", "646998887"));

        System.out.println(personas);
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        //Lista no modificable - usar solo con Streams
        List<String> nombres = List.of("Pepe", "Juan", "Ana");
        //nombres.add("hola"); Error
        System.out.println(nombres);

        //Lista no modificable - usar solo con Streams
        List<String> nombres2 = List.copyOf(nombres);

        //Ahora sí sería modificable
        List<String> nombres3 = new ArrayList<>(List.copyOf(nombres));
        nombres3.add("Luisa");
        System.out.println(nombres3);
    }
}
