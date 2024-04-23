package Tema7Prog_P2.practicaFicheros.io;

import Tema7Prog_P2.practicaFicheros.entidades.Finca;
import Tema7Prog_P2.practicaFicheros.entidades.Lectura;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DAOFinca {

    private static ArrayList<Finca> fincas;

    //Constructor
    public DAOFinca() throws IOException {
        fincas = cargarDatos();
    }

    /**
     * Leerá el fichero fincas.csv y para cada línea creará un objeto Finca y lo añadirá a fincas.
     * @return
     * @throws IOException
     */
    public static ArrayList<Finca> cargarDatos() throws IOException {

        Path rutaFincas = Paths.get("Tema7Prog_P2","practicaFicheros", "recursos", "fincas.csv");

        ArrayList<Finca> fincas = new ArrayList<>();

        List<Finca> fincasFichero = Files.lines(rutaFincas)
                .map(str -> {
                    String[] cad = str.split(",");

                    //Creamos el objeto finca
                    return new Finca(Integer.parseInt(cad[0]), cad[1], Double.parseDouble(cad[2]), Double.parseDouble(cad[3]), Integer.parseInt(cad[4]),
                            cad[5], cad[6]);
                })
                .toList();

        fincas.addAll(fincasFichero);//Añade todos los elementos encontrados en el fichero al ArrayList

        return fincas;
    }

    /**
     * Buscan en fincas y devuelve aquella que tenga el id_indicado
     * @param id
     * @return
     * @throws NoSuchElementException
     */
    public static Finca findById(int id) throws NoSuchElementException {
            return fincas.stream()
                    .filter(finca -> finca.getIdFinca().equals(id))
                    .findFirst() //findFirst para que encuentre el primero
                    .orElse(null);

    }

    /**
     * Metodo para añadir fincas
     * @param finca
     */
    public static void addFinca(Finca finca){
        fincas.add(finca);
    }

    /**
     * Metodo para eliminar una finca
     */
    public static void deleteFinca(Finca finca){
        fincas.remove(finca);
    }

    /**
     * Buscar eficiente las fincas con ese nombre.
     * @param nombre
     * @return
     */
    public static List<Finca> findByName (String nombre){

        return fincas.stream()
                .filter(finca -> finca.getNombre().contains(nombre))
                .toList();
    }

    // STREAMS --------------------------------

    /**
     * Devuelve todas las fincas ordenadas de menor a mayor superficie.
     * @return
     */
    public static List<Finca> getFincasPorSuperfie(){
        return fincas.stream()
                .sorted(Comparator.comparing(Finca::getSuperficie))
                .toList();
    }

    /**
     *  Devuelve las tres fincas más grandes
     */
    public static List<Finca> getMasGrandes(){
        return fincas.stream()
                .sorted(Comparator.comparing(Finca::getSuperficie).reversed())
                .limit(3)
                .toList();
    }

    /**
     * Muestra las fincas agrupadas por ciudad.
     */
    public static HashMap<String, List<Finca>> getFincasPorCiudad(){
        return new HashMap<>(fincas.stream()
                .collect(Collectors.groupingBy(Finca::getLocalidad)));

    }

    /**
     * Devuelve el nombre de todas las fincas entre 50 y 150 metros cuadrados.
     */

    public static List<String> getFincasMedio(){
        return fincas.stream()
                .filter(finca -> finca.getSuperficie() > 50)
                .filter(finca -> finca.getSuperficie() < 150)
                .map(Finca::getNombre)
                .toList();
    }


}

