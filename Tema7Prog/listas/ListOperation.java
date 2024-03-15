package Tema7Prog.listas;

import java.util.ArrayList;
import java.util.List;

public class ListOperation {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("John","john@gmail.com", "646558887"));
        personas.add(new Persona("Ann","ann@gmail.com", "646544487"));
        personas.add(new Persona("Louise","louise@gmail.com", "646998887"));
        personas.add(new Persona("Tony","tony@gmail.com", "646998887"));

        //System.out.println(personas);
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        //Foreach
        personas.forEach(persona -> System.out.println(persona.getNombre()));

        System.out.println("-------------------------------------");

        //Inserta en una posición y desplaza el resto
        personas.add(2, new Persona("Xavier", "xavi@gmail.com", "6544666"));
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        System.out.println("-------------------------------------");

        //Eliminar por índice
        personas.remove(1);
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        System.out.println("-------------------------------------");

        //Eliminar por objeto
        personas.remove(new Persona("","john@gmail.com", ""));
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        //Eliminar en un for no se puede
        //for(Persona persona: personas) {
        //    personas.remove(0);
        //}

        System.out.println("-------------------------------------");

        //Eliminar con una condición todos los elementos que la cumplan
        personas.removeIf(p -> p.getNombre().startsWith("L"));
        for(Persona persona: personas) {
            System.out.println(persona);
        }

        System.out.println("-------------------------------------");

        //ContainsAll comprueba si todos los elementos de la lista pasada por parámetro
        //están en la lista sobra la que se ejecuta
        List<Persona> otra = new ArrayList<>();
        otra.add(new Persona("","xavi@gmail.com",""));
        otra.add(new Persona("Tony","tony@gmail.com", "646998887"));
        System.out.println(personas.containsAll(otra));

        //Si está vacía o no
        System.out.println(personas.isEmpty());

        //Buscar elemento y nos devuelve la posición
        System.out.println(personas.indexOf(new Persona("","xavi@gmail.com","")));

        List<Persona> otra2 = new ArrayList<>();
        otra2.add(new Persona("","xavi@gmail.com",""));
        personas.retainAll(otra2);
        for(Persona persona: personas) {
            System.out.println(persona);
        }



    }

}
