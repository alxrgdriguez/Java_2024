package Tema7Prog_P2.pruebaEscritaPasado.aplicacion;

import Tema7Prog_P2.pruebaEscritaPasado.io.MeteoFile;
import Tema7Prog_P2.pruebaEscritaPasado.model.EstacionMeteorologica;
import Tema7Prog_P2.pruebaEscritaPasado.model.RegistroDatosDia;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<EstacionMeteorologica> em = new ArrayList<>();

        MeteoFile mto1 = new MeteoFile();

        /*Scanner sc = new Scanner(System.in);
        Integer opcion = 0;

        do {

            System.out.println("---------- MENU --------------");
            System.out.println("1. nuevaEstacion");
            System.out.println("2. eliminarEstacion");
            System.out.println("3. buscarEstacion");
            System.out.println("4. getTempPorEstacion");
            System.out.println("5. getTempPorAnioEstacion");
            System.out.println("6. getTempPorComunidad");
            System.out.println("7. getTempMaxRegistrada");
            System.out.println("8. getEstacionesPorComunidad");
            System.out.println("9. isTempMediaAlta");
            System.out.println("10. getTempMaxPorComunidad");
            System.out.println("11. borrarEstacionesComunidad");
            System.out.println("12. pintaTempEstacionFarenheit");
            System.out.println("13.  getNumRegistros");
            System.out.println("14. Salir y guardar");
            System.out.print("\n Introduce la opcion que deseas realizar: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }while (opcion != 14);


*/
        RegistroDatosDia rdd1 = new RegistroDatosDia(1001, "05/05/2024", 35.0, 25.0, 30.0, 101);
        TreeSet<RegistroDatosDia> registrosPrueba = new TreeSet<>();
        registrosPrueba.add(rdd1);
        EstacionMeteorologica em1 = new EstacionMeteorologica(101, "Estacion de prueba", "Murcia", 3.2542125, -3.32874, registrosPrueba);

        mto1.cargarDatosCSV();

        //Añadimos una nueva estacion
        //mto1.getSgm().nuevaEstacion(em1);

        mto1.getSgm().eliminarEstacion(em1);

        //em.forEach(System.out::println);

        System.out.println(mto1.getSgm());

        mto1.grabarCSV();


    }
}


/* */
