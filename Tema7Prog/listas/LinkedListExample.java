package Tema7Prog.listas;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<Persona> personas = new LinkedList<>();

        //Pila: primero que entra es el último en salir
        personas.push(new Persona("John","john@gmail.com", "646558887"));
        personas.push(new Persona("Ann","ann@gmail.com", "646544487"));
        personas.push(new Persona("Louise","louise@gmail.com", "646998887"));
        personas.push(new Persona("Tony","tony@gmail.com", "646998887"));

        System.out.println(personas.peek()); //Devuelve pero No elimina
        System.out.println("---------------");

        System.out.println(personas.pop()); //Devuelve y Elimina
        System.out.println("---------------");

        personas.forEach(System.out::println);

        System.out.println("COLA --------------------------");

        LinkedList<Persona> personas2 = new LinkedList<>();

        //Cola: primero que entra es el primero en salir
        personas2.offer(new Persona("John","john@gmail.com", "646558887"));
        personas2.offer(new Persona("Ann","ann@gmail.com", "646544487"));
        personas2.offer(new Persona("Louise","louise@gmail.com", "646998887"));
        personas2.offer(new Persona("Tony","tony@gmail.com", "646998887"));

        System.out.println(personas2.peek()); //Devuelve pero No elimina
        System.out.println("---------------");

        System.out.println(personas2.poll()); //Devuelve y Elimina
        System.out.println("---------------");

        personas2.forEach(System.out::println);


    }
}
