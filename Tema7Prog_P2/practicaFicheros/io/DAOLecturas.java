package Tema7Prog_P2.practicaFicheros.io;

import Tema7Prog_P2.practicaFicheros.entidades.Finca;
import Tema7Prog_P2.practicaFicheros.entidades.Lectura;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DAOLecturas {

    //Propiedades
    private static Set<Lectura> lecturas;

    //Constructor
    public DAOLecturas() throws IOException {
        lecturas = cargarDatos();
    }

    public static Set<Lectura> cargarDatos() throws IOException {

        Path rutaLecturas = Paths.get("Tema7Prog_P2", "practicaFicheros", "recursos", "lecturas.csv");

        Set<Lectura> lecturas1 = new HashSet<>();

        List<Lectura> lecturasFichero = Files.lines(rutaLecturas)
                .map(str -> {
                    String[] cad = str.split(",");

                    Finca fincaOb = DAOFinca.findById(Integer.parseInt(cad[4]));

                    //Creamos el objeto lectura
                    return new Lectura(Integer.parseInt(cad[0]), Double.parseDouble(cad[1]), Double.parseDouble(cad[2]),
                            LocalDate.parse(cad[3]), fincaOb);

                }).toList();

        lecturas1.addAll(lecturasFichero);
        return lecturas1;
    }

    public static Lectura FindById(Integer id) throws NoSuchElementException {

            return lecturas.stream()
                    .filter(lectura -> lectura.getId().equals(id))
                    .findFirst()
                    .orElse(null);

    }

    /**
     *  Tomará la colección de lecturas y las grabará en el fichero de texto lecturas.csv
     */
    public static void grabarDatos() throws IOException{
        Path rutaLecturas = Paths.get("Tema7Prog_P2", "practicaFicheros", "recursos", "lecturas.csv");

        //Files.deleteIfExists(rutaLecturas); Otra posible solución, si n es con el TRUNCATE_EXISTING

        BufferedWriter bw = Files.newBufferedWriter(rutaLecturas,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE);

        //For each lecturas
        StringBuffer sb = new StringBuffer();
        for (Lectura l: lecturas ){
            //StringBuffer sb = new StringBuffer();
            sb.append(l.getId()).append(",");
            sb.append(l.getTemperatura()).append(",");
            sb.append(l.getHumedad()).append(",");
            sb.append(l.getMomento()).append(",");
            sb.append(l.getFinca().getIdFinca()).append("\n");

            bw.write(sb.toString());
            sb.delete(0, sb.length());
        }

        //Cerramos el BufferedWriter
        bw.close();

    }


    /**
     * Metodo para añadir una lectura
     * @param lectura
     */
    public static void addLectura(Lectura lectura){
        lecturas.add(lectura);
    }

    /**
     * Metodo para eliminar lectura
     * @param lectura
     */
    public static void deleteLectura(Lectura lectura){
        lecturas.remove(lectura);
    }

    // STREAMS --------------------------------

    /**
     *  Devuelve todas las lecturas agrupadas por finca (por su id)
     */

    public static HashMap<Integer, List<Lectura>> getLecturasPorFinca(){
        return new HashMap<>(lecturas.stream()
               .collect(Collectors.groupingBy(lectura -> lectura.getFinca().getIdFinca())));
    }

    /**
     *  Devuelve la temperatura máxima de todas las lecturas de una finca.
     */

    public static Double getTempMaximaFinca(Integer id){
        return lecturas.stream()
                .filter(lectura -> lectura.getFinca().getIdFinca().equals(id))
                .map(Lectura::getTemperatura)
                .max(Double::compareTo)
                .orElse(null);

    }

    /**
     *  Devuelve la temperatura máxima de todas las lecturas de una finca.
     */
    public static Double getTempMinimaFinca(Integer id){
        return lecturas.stream()
               .filter(lectura -> lectura.getFinca().getIdFinca().equals(id))
               .map(Lectura::getTemperatura)
               .min(Double::compareTo)
               .orElse(null);
    }

    /**
     * Para una finca devuelve una lista de los valores de humedad ordenados por fecha
     */

    public static List<Double> getHumedadesPorFinca(Integer id){
        return lecturas.stream()
                .filter(lectura -> lectura.getFinca().getIdFinca().equals(id))
                .map(Lectura::getHumedad)
                .sorted()
                .toList();
    }

    /**
     * Para una finca devuelve una lista de los valores de temperatura ordenados por fecha.
     */
    public static List<Double> getTemperaturaPorFinca(Integer id){
        return lecturas.stream()
                .filter(lectura -> lectura.getFinca().getIdFinca().equals(id))
                .map(Lectura::getTemperatura)
                .sorted()
                .toList();
    }


    /**
     * Muestra todas las temperaturas de una finca en un día concreto
     */
    public static List<Double> getTempDiaPorFinca(Integer id, LocalDate dia){
        return lecturas.stream()
                .filter(lectura -> lectura.getFinca().getIdFinca().equals(id))
                .filter(lectura -> lectura.getMomento().equals(dia))
                .map(Lectura::getTemperatura)
                .sorted()
                .toList();

        //No te lo he hecho por la hora por que no sabía :D
    }



}
