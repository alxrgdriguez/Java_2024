package Tema7Prog.ejercicios_UT7.equipo_basket.entidades;

import Tema4Prog.Practica_Objetos1.juego_bladeofdarkness.Jugador;

import java.util.*;
import java.util.function.BiConsumer;

public class EquipoBasket implements BiConsumer<String, EquipoBasket> {

    //Propiedades
    private String nombre;
    private Double partidosGanados;
    private Double PartidosPerdidos;
    private HashSet<JugadorBasket> jugadoresBaskets;

    //Constructor

    public EquipoBasket(String nombre, Double partidosGanados, Double getPartidosPerdidos) {
        this.nombre = nombre;
        this.partidosGanados = partidosGanados;
        this.PartidosPerdidos = getPartidosPerdidos;
        this.jugadoresBaskets = new HashSet<>();
    }

    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(Double partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public HashSet<JugadorBasket> getJugadoresBaskets() {
        return jugadoresBaskets;
    }

    public void setJugadoresBaskets(HashSet<JugadorBasket> jugadoresBaskets) {
        this.jugadoresBaskets = jugadoresBaskets;
    }

    public Double getPartidosPerdidos() {
        return PartidosPerdidos;
    }

    //equals por nombre

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipoBasket that = (EquipoBasket) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Equipo{ ");
        sb.append(" Nombre Equipo: ").append(getNombre());
        sb.append(", Partidos Ganados: ").append(getPartidosGanados());
        sb.append(", Partidos Perdidos: ").append(getPartidosPerdidos());
        sb.append(", Total de Jugadores: " + this.jugadoresBaskets.size()) ;

        return sb.toString();
    }

    //Metodos

    /**
     * Buscar el jugador en el equipo y lo devuelva. Intenta hacerlo
     * óptimo buscando con binarySearch.
     * @param nombre
     * @return
     */
    public JugadorBasket buscarJugador(String nombre){

        List<JugadorBasket> listaJugadores = new ArrayList<>(this.jugadoresBaskets);
        listaJugadores.sort(Comparator.comparing(JugadorBasket::getNombre));
        int bynary = Collections.binarySearch(listaJugadores, new JugadorBasket(nombre));

        return listaJugadores.get(bynary);

    }


    /**
     * Metodo para buscar un jugador por su dorsal
     * @param dorsal
     * @return Devuelve el jugador con el dorsal encontrado sino devuelve null
     */

    public JugadorBasket buscarJugador(int dorsal) {
        for (JugadorBasket jugador : this.jugadoresBaskets) {
            if (jugador.getDorsal().equals(dorsal)) {
                return jugador;
            }
        }
        return null;
    }



    /**
     * Metodo para mostrar la lista del equipo de baloncesto
     */
    public String mostrarEquipo(){
        StringBuffer sb = new StringBuffer("Equipo{ ");
        sb.append(" Nombre Equipo: ").append(getNombre());
        sb.append(", Partidos Ganados: ").append(getPartidosGanados());
        sb.append(", Partidos Perdidos: ").append(getPartidosPerdidos());
        sb.append(", Total de Jugadores: " + this.jugadoresBaskets.size()) ;

        return sb.toString();
    }

    /**
     * Añadir un Jugador al Equipo.
     * @param jugador
     */
    public void addJugador(JugadorBasket jugador){
        this.jugadoresBaskets.add(jugador);
    }

    /**
     * Eliminar ese Jugador del Equipo.
     * @param jugador
     */
    public void removeJugador(JugadorBasket jugador){
        this.jugadoresBaskets.remove(jugador);

    }

    @Override
    public void accept(String s, EquipoBasket equipoBasket) {

    }

    @Override
    public BiConsumer<String, EquipoBasket> andThen(BiConsumer<? super String, ? super EquipoBasket> after) {
        return BiConsumer.super.andThen(after);
    }
}
