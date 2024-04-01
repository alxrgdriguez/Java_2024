package Tema7Prog.ejercicios_UT7.equipo_basket.entidades;

import java.util.HashMap;
import java.util.TreeMap;

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




}
