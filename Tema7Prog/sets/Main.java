package Tema7Prog.sets;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TreeSet<Double> numeros = new TreeSet<>();
        numeros.add(4d);
        numeros.add(6d);
        numeros.add(1d);
        numeros.add(14d);
        numeros.add(24d);

        for(Double numero: numeros) {
            System.out.println(numero);
        }

        TreeSet<String> palabras = new TreeSet<>();
        palabras.add("Hola");
        palabras.add("Mundo");
        palabras.add("Amigo");
        palabras.add("Casa");

        for(String palabra: palabras) {
            System.out.println(palabra);
        }

        PlantillaEmpresa pe = new PlantillaEmpresa();
        pe.addEmpleado(new Empleado("Nuria", "IA",
                55000d, "nuria@gmail.com", "Lituania"));
        pe.addEmpleado(new Empleado("Javi", "IA",
                50000d, "jj@gmail.com", "España"));
        pe.addEmpleado(new Empleado("Maria Isabel", "Programación",
                30000d, "isa@gmail.com", "España"));
        pe.addEmpleado(new Empleado("Manuel", "RRHH",
                35000d, "manu@gmail.com", "Francia"));
        pe.addEmpleado(new Empleado("Isabel", "Programación",
                30000d, "isa@gmail.com", "España"));
        pe.addEmpleado(new Empleado("Isabel", "Programación",
                30000d, "isa@gmail.com", "España"));

        System.out.println(pe);

        /**
         * ORDENAR POR LO QUE ME PIDAN UN ARRAYLIST
         * Collections.sort(lista<T>, Comparator<T>)
         */

        ArrayList<Empleado> empleadosList = new ArrayList<>(pe.getPlantilla());
        Collections.sort(empleadosList, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getDepartamento().compareTo(o2.getDepartamento());
            }
        });
        for(Empleado e: empleadosList) {
            System.out.println(e);
        }

        Collections.sort(empleadosList, new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getSueldo().compareTo(o2.getSueldo());
            }
        });
        for(Empleado e: empleadosList) {
            System.out.println(e);
        }


    }
}
