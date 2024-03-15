package Tema7Prog.mapas;

import Tema7Prog.sets.Empleado;

import java.util.HashMap;

public class EjemploMapRaro {


    public static void main(String[] args) {

        Empleado e1 = new Empleado("Nuria", "IA",
                55000d, "nuria@gmail.com", "Lituania");
        Empleado e2 = new Empleado("Javi", "IA",
                50000d, "jj@gmail.com", "España");
        Empleado e3 = new Empleado("Manuel", "RRHH",
                35000d, "manu@gmail.com", "Francia");
        Empleado e4 = new Empleado("Sonia", "RRHH",
                35000d, "sonia@gmail.com", "España");

        HashMap<Empleado, Integer> proyectos = new HashMap<>();
        proyectos.put(e1, 3);
        proyectos.put(e2, 1);
        proyectos.put(e3, 5);
        proyectos.put(e4, 22);
        proyectos.put(e4, 33);

        for(Empleado e: proyectos.keySet()) {
            System.out.println(e.getEmail() + " -> " + proyectos.get(e));
        }

        System.out.println(proyectos.values());


    }
}
