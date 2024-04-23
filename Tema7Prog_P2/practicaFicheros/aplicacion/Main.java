package Tema7Prog_P2.practicaFicheros.aplicacion;

import Tema7Prog_P2.practicaFicheros.entidades.Lectura;
import Tema7Prog_P2.practicaFicheros.io.DAOFinca;
import Tema7Prog_P2.practicaFicheros.io.DAOLecturas;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {


        //Crea una clase TestFincas, que cree los dos objetos DAOFinca y DAOReserva. Al crearlos se habrá
        //cargado toda la información de los ficheros .csv

        DAOFinca probarFincas = new DAOFinca();
        DAOLecturas probarLecturas = new DAOLecturas();

        //Ahora prueba a llamar y a pintar el resultado de todos los métodos de la Parte 3

        //DAOFINCA -----------------------------------------------
        System.out.println("\n-------------- DAOFINCA --------------  ");
        System.out.println("\n------------------getFincasPorSuperficie-------------------");
        DAOFinca.getFincasPorSuperfie().forEach(System.out::println);
        System.out.println("\n------------------getFincasMedio-------------------");
        DAOFinca.getFincasMedio().forEach(System.out::println);
        System.out.println("\n---------------getMasGrandes----------------------");
        DAOFinca.getMasGrandes().forEach(System.out::println);
        System.out.println("\n---------------getFincasPorCiudad------------------");
        DAOFinca.getFincasPorCiudad().forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("------------------FIN DAOFINCA-------------------\n");


        //DAOLECTURAS -----------------------------------------------
        System.out.println("\n-------------- DAOLECTURAS --------------  ");
        System.out.println("\n------------------getLecturasPorFinca-------------------");
        DAOLecturas.getLecturasPorFinca().forEach(((k, v) -> System.out.println(k + ": " + v)));
        System.out.println("\n------------------getHumedadesPorFinca-------------------");
        DAOLecturas.getHumedadesPorFinca(1).forEach(System.out::println);
        System.out.println("\n------------------getTempMaximaFinca-------------------");
        System.out.println( "Temperatura maxima: " + DAOLecturas.getTempMaximaFinca(2));
        System.out.println("\n------------------getTempMinimaFinca-------------------");
        System.out.println( "Temperatura minima: " + DAOLecturas.getTempMinimaFinca(2));
        System.out.println("\n------------------getTemperaturaPorFinca-------------------");
        System.out.println(DAOLecturas.getTemperaturaPorFinca(2));
        System.out.println("\n------------------getTempDiaPorFinca-------------------");
        System.out.println(DAOLecturas.getTempDiaPorFinca(4, LocalDate.parse("2023-04-02")));

        //Elimina 5 lecturas y llama a grabarDatos() de DAOReserva

        System.out.println("\n------------------deleteLectura-------------------");
        DAOLecturas.deleteLectura(DAOLecturas.FindById(1));
        DAOLecturas.grabarDatos();

    }
}
