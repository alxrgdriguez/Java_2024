package Tema7Prog.ejercicios_UT7.equipo_basket.entidades;

import Tema4Prog.Practica_Objetos1.juego_bladeofdarkness.Jugador;

import java.util.HashSet;
import java.util.Objects;

public class EquipoBasket {

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


    //Metodos

    //Hacer mas tarde..
    //public JugadorBasket buscarJugador(String nombre)


    /**
     * Metodo para buscar un jugador por su dorsal
     * @param dorsal
     * @return Devuelve el jugador con el dorsal encontrado sino deveulve null
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
    public void mostrarEquipo(){
        StringBuffer sb = new StringBuffer("Equipo{ ");
        sb.append(" Nombre Equipo: ").append(getNombre());
        sb.append(", Partidos Ganados: ").append(getPartidosGanados());
        sb.append(", Partidos Perdidos: ").append(getPartidosPerdidos());
        sb.append(", Total de Jugadores: ") ;
        for(JugadorBasket jugador: jugadoresBaskets){
            sb.append(jugador.getNombre());
            sb.append(" }");
        }

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

}
