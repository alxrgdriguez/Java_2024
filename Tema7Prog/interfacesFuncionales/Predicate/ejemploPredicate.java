package Tema7Prog.interfacesFuncionales.Predicate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ejemploPredicate {


    public static void main(String[] args) {

        List<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("John","john@gmail.com", "646558887", 21));
        listaPersonas.add(new Persona("Alex","Alex@gmail.com", "546577727", 32));
        listaPersonas.add(new Persona("Pepito","pepito@gmail.com", "946559087",20));
        listaPersonas.add(new Persona("Manolito","manolito@gmail.com", "236558887",5));

        listaPersonas.stream()
                .filter((p) -> p.getEdad() >= 21)
                .forEach(System.out::println);



    }



}
