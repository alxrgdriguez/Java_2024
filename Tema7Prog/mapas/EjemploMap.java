package Tema7Prog.mapas;

import Tema7Prog.sets.Empleado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class EjemploMap {

    public static void main(String[] args) {

        Empleado e1 = new Empleado("Nuria", "IA",
                55000d, "nuria@gmail.com", "Lituania");
        Empleado e2 = new Empleado("Javi", "IA",
                50000d, "jj@gmail.com", "España");
        Empleado e3 = new Empleado("Manuel", "RRHH",
                35000d, "manu@gmail.com", "Francia");
        Empleado e4 = new Empleado("Sonia", "RRHH",
                35000d, "sonia@gmail.com", "España");

        TreeMap<Departamento, List<Empleado>> departamentos = new TreeMap<>(new Comparator<Departamento>() {
            @Override
            public int compare(Departamento o1, Departamento o2) {
                return o1.toString().compareTo(o2.toString());
            }
        });

        ArrayList<Empleado> l1 = new ArrayList<>();
        l1.add(e1);
        l1.add(e2);

        ArrayList<Empleado> l2 = new ArrayList<>();
        l2.add(e3);
        l2.add(e4);

        departamentos.put(Departamento.RRHH, l2);
        departamentos.put(Departamento.IA, l1);

        for(Departamento dep : departamentos.keySet()) {
            System.out.println(dep + " -> " + departamentos.get(dep));
        }

        System.out.println(departamentos.keySet().contains(Departamento.CONTABILIDAD));


    }
}
