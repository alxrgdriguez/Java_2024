package Tema7Prog.ejercicios_UT7.equipo_basket.entidades;

import java.util.*;

public class NBALeague {

    //Propiedades
    private HashMap<String, EquipoBasket> equipos;
    private TreeMap<String, EquipoBasket> equiposOrdenados;

    //Constructor
    public NBALeague() {
        this.equipos = new HashMap<>();
        this.equiposOrdenados = new TreeMap<>();
    }

    //Getters and Setters
    public HashMap<String, EquipoBasket> getEquipos() {
        return equipos;
    }

    public void setEquipos(HashMap<String, EquipoBasket> equipos) {
        this.equipos = equipos;
    }

    public TreeMap<String, EquipoBasket> getEquiposOrdenados() {
        return equiposOrdenados;
    }

    public void setEquiposOrdenados(TreeMap<String, EquipoBasket> equiposOrdenados) {
        this.equiposOrdenados = equiposOrdenados;
    }

    //Metodos

    /**
     * Metodo para agregar un equipo a NBALeague
     * @param equipo
     */
    public void agregarEquipo(EquipoBasket equipo) {
        this.equipos.put(equipo.getNombre(), equipo);
        this.equiposOrdenados.put(equipo.getNombre(), equipo);
    }

    /**
     * Metodo para eliminar un equipo de NBALeague
     * @param equipo
     */
    public void eliminarEquipo(EquipoBasket equipo) {
        this.equipos.remove(equipo.getNombre());
        this.equiposOrdenados.remove(equipo.getNombre());
    }

    /**
     * Metodo para buscar equipos por nombre
     */

    public EquipoBasket buscarNombre (String nombre){
        return equipos.get(nombre);
    }

    // --- Mostrar los equipos ---

    /**
     * Mostrar los equipos por HashMap
     */

    public void mostrarEquiposHashMap(){

        this.equipos.forEach((nombre,equipo) -> System.out.println( nombre + ": " + equipo));
    }

    /**
     * Mostrar equipos por TreeMap
     */

    public void mostrarEquiposTreeMap(){
        this.equiposOrdenados.forEach((nombre,equipo) -> System.out.println( nombre + ": " + equipo));
    }


    /**
     * Buscar el jugador más alto
     */

    public JugadorBasket buscarMasAlto(){

        List<EquipoBasket> equiposBasket = new ArrayList<>(this.equiposOrdenados.values());

        return equiposBasket.stream()

                .flatMap(equipoBasket -> equipoBasket.getJugadoresBaskets().stream())
                .max(Comparator.comparing(JugadorBasket::getAltuta))
                .orElse(null); //Se utiliza cuando es Optional
    }

    /**
     * Buscar el equipo con más partidos ganados
     */

    public EquipoBasket buscarMasPartidosGanados(){
        List<EquipoBasket> equiposBasket = new ArrayList<>(this.equiposOrdenados.values());

        return equiposBasket.stream()

                .max(Comparator.comparing(EquipoBasket::getPartidosGanados))
                .get(); //Se utiliza cuando es Optional
    }


}
