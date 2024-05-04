package Tema7Prog.ejercicios_UT7.expedienteAlumnos.aplicacion;

import Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades.CentroEducativo;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades.Estudiante;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades.Expediente;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades.NotasCurso;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.enums.Activo;
import Tema7Prog.ejercicios_UT7.expedienteAlumnos.enums.Etapa;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class TestExpediente {

    public static void main(String[] args) {

        Estudiante e1 = new Estudiante( "23456789E","Julian","Fernandez Ruiz", LocalDate.of(1997,11, 8),"Calle Pepino", "Gardfield", "julian@gmail.com",56345674);
        Estudiante e2 = new Estudiante( "73456789E","Alejandro","Rodriguez Gallardo", LocalDate.of(2003,9, 23),"Calle Ciclista", "Aguilas", "alex@gmail.com",66345674);

        NotasCurso n1 = new NotasCurso(Etapa.FPSuperior, "DAW", 2,2020);
        NotasCurso n2 = new NotasCurso(Etapa.Bachillerato, "Ciencias Sociales", 2, 2021);
        NotasCurso n3 = new NotasCurso(Etapa.ESO, "", 1, 2017);

        n1.addNota("Programacion", 8.2);
        n1.addNota("Lenguaje de Marcas", 9.0);

        n2.addNota("Geografía",  7.2);
        n2.addNota("Filosofia", 6.75);

        n3.addNota("Mates", 5.0);
        n3.addNota("Ingles",7.39);

        Expediente ex1 = new Expediente(e1, Activo.SI);
        Expediente ex2 = new Expediente(e2, Activo.SI);

        ex1.addNotas(n1);
        ex2.addNotas(n2);
        ex2.addNotas(n3);

        TreeSet<Expediente> expedientes = new TreeSet<>(Comparator.comparing(expediente -> expediente.getEstudiante().getDni()));
        expedientes.add(ex1);
        expedientes.add(ex2);

        CentroEducativo centro = new CentroEducativo(expedientes, "IES JAROSO", "Calle Cuevas", "Cuevas del Almanzora", 54533433, "jaroso@gmail.com");

        System.out.println(centro.buscarExpediente("73456789E"));

        System.out.println(ex2.mostrarNotas(2,  Etapa.Bachillerato));

        System.out.println(n1.buscarNota("Programacion"));


    }
}
