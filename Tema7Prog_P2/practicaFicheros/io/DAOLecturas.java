package Tema7Prog_P2.practicaFicheros.io;

import Tema7Prog_P2.practicaFicheros.entidades.Finca;
import Tema7Prog_P2.practicaFicheros.entidades.Lectura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOLecturas {

    //Propiedades
    Set<Lectura> lecturas;

    public static Set<Finca> cargarDatos() throws IOException{

        Path rutaLecturas= Paths.get("Tema7Prog_P2","practicaFicheros", "recursos", "lecturas.csv");

        Set<Lectura> lecturas1 = new HashSet<>();

        List<Lectura> lecturasFichero = Files.lines(rutaLecturas)
                .map(str ->{
                     String[] cad = str.split(",");

                     //Creamos el objeto lectura
                    /*return new Lectura(Integer.parseInt(cad[0]), Double.parseDouble(cad[1]), Double.parseDouble(cad[2]),
                            LocalDate.parse(cad[3]),)*/

                })
    }
}
