package Tema7Prog_P2.practicaFicheros.io;

import Tema7Prog_P2.practicaFicheros.entidades.Finca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
                    return new Finca(Integer.parseInt(cad[0]), cad[1], Double.parseDouble(cad[2]), Double.parseDouble(cad[3]), cad[4],
                            cad[5], cad[6]);
                })
                .toList();

        fincas.addAll(fincasFichero);//Añade todos los elementos encontrados en el fichero al ArrayList

        return fincas;
    }

    /**
     * Buscan en fincas y devuelve aquella que tenga el id indicado
     * @param id
     * @return
     * @throws NoSuchElementException
     */
    public static Finca findById(int id) throws NoSuchElementException {

        try {
            return fincas.stream()
                    .filter(finca -> finca.getIdFinca().equals(id))
                    .findFirst()
                    .get(); //findFirst para que encuentre el primero
        }catch (Exception e) {
            System.out.println("Error al buscar la finca: " + id);
            return null;
        }

    }

    /**
     * Metodo para añadir fincas
     * @param finca
     */
    public void addFinca(Finca finca){
        fincas.add(finca);
    }

    /**
     * Metodo para eliminar una finca
     */
    public void deleteFinca(Finca finca){
        fincas.remove(finca);
    }

    /**
     * Buscar eficiente las fincas con ese nombre.
     * @param nombre
     * @return
     */
    public List<Finca> findByName (String nombre){

        return fincas.stream()
                .filter(finca -> finca.getNombre().contains(nombre))
                .toList();
    }


}
