package Tema7Prog.mapas;

import java.util.HashMap;

public class EjemploHashMap {
    public static void main(String[] args) {

        HashMap<Integer, String> dorsales = new HashMap<>();

        //put(key, value)
        dorsales.put(10, "Modric");
        dorsales.put(11, "Fulanito");
        dorsales.put(1, "Courtois");
        dorsales.put(1, "Manolo"); //Modifica el valor asociado a la clave

        //get(clave) -> valor
        System.out.println(dorsales.get(1));

        System.out.println(dorsales.containsKey(10));
        System.out.println(dorsales.containsValue("Fulanito"));

        //.values() devuelve todos los valores
        System.out.println(dorsales.values());

        //.keySet() devuelve un set con todas las claves
        for(Integer clave: dorsales.keySet()) { //1, 10, 11
            System.out.println(clave + " -> " + dorsales.get(clave));
        }

        dorsales.remove(11);
        System.out.println(dorsales.size());


    }
}
