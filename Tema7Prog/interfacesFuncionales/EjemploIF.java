package Tema7Prog.interfacesFuncionales;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class EjemploIF {
    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<String> palabras = List.of("Hola", "Mundo", "hola", "adiós");

        palabras.stream()
                .filter( palabra -> palabra.startsWith("H") )
                .filter( palabra -> palabra.contains("a"))
                .map( palabra -> palabra.length())
                //.forEach( (palabra) -> {System.out.println(palabra);} );
                .forEach(System.out::println);



        /*
        Collections.sort(palabras, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Collections.sort(palabras, (o1, o2) -> o1.length() - o2.length());

        Collections.sort(palabras, String::compareTo);
        */

        Predicate<String> mayorOcho = s -> s.length() > 8;
        String password = "halhjdflajdflñaj";
        System.out.println(mayorOcho.test(password));


        List<String> palabras2 = new ArrayList<>(List.of("uno", "dos", "tres"));
        palabras2.stream() //convertir la colección en un flujo (stream)
                .forEach(str -> System.out.println(str));

        palabras2.removeIf( str -> str.contains("e") );
        palabras2.forEach( str -> System.out.println(str));


    }
}

