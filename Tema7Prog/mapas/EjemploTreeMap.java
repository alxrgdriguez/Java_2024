package Tema7Prog.mapas;

import java.util.TreeMap;

public class EjemploTreeMap {

    public static void main(String[] args) {

        //ORDENA LAS CLAVES
        TreeMap<String, String> diccionario = new TreeMap<>();
        diccionario.put("casa", "house");
        diccionario.put("coche", "car");
        diccionario.put("perro", "dog");
        diccionario.put("perro", "dog");
        diccionario.put("dia", "day");

        for(String clave: diccionario.keySet()) {
            System.out.println(clave + " -> " + diccionario.get(clave));
        }
    }
}
