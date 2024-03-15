package Tema7Prog.listas;

import Tema7Prog.sets.Empleado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EjemploOrdenarListas {

    public static void main(String[] args) {
        Empleado e1 = new Empleado("Nuria", "IA",
                55000d, "nuria@gmail.com", "Lituania");
        Empleado e2 = new Empleado("Javi", "IA",
                50000d, "jj@gmail.com", "España");
        Empleado e3 = new Empleado("Manuel", "RRHH",
                35000d, "manu@gmail.com", "Francia");
        Empleado e4 = new Empleado("Sonia", "RRHH",
                35000d, "sonia@gmail.com", "España");

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(e1);
        empleados.add(e2);
        empleados.add(e3);
        empleados.add(e4);

        Collections.sort(empleados); //Usa Comparable de Empleados

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

        empleados.sort(new Comparator<Empleado>() {
            @Override
            public int compare(Empleado o1, Empleado o2) {
                return o1.getSueldo().compareTo(o2.getSueldo());
            }
        });

        System.out.println();

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }

    }
}
