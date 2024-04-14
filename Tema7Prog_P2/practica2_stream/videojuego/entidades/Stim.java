package Tema7Prog_P2.practica2_stream.videojuego.entidades;

import Tema4Prog.Ejemplos_BasicosPOO.Jugador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Stim {

    //Propiedades
    private ArrayList<Juego> juegos;
    private LinkedList<Usuario> jugadores;

    //Constructor

    public Stim(){
        this.juegos = new ArrayList<>();
        this. jugadores = new LinkedList<>();
    }

    //Getters de las listas
    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public LinkedList<Usuario> getJugadores() {
        return jugadores;
    }

    // --- METODOS ---

    /**
     * Añadir un juego a la lista de juegos
     * @param juego
     */
    public void addJuego(Juego juego){

        this.juegos.add(juego);
    }

    /**
     * Eliminar un juego de la lista de juegos
     */
    public void delJuego(Juego juego){
        this.juegos.remove(juego);
    }

    /**
     * Añadir un usuario a los jugadores
     */
    public void addJugadores(Usuario jugador){

        this.jugadores.add(jugador);
    }

    /**
     * Pintar los jugadores
     */
    public void listarJugadores(){
        for (int i = 0; i < this.jugadores.size(); i++){
            System.out.println(this.jugadores.get(i).toString());
        }
    }

    /**
     * Que pinte todos los juegos
     */
    public void listarJuegos(){
        for (int i = 0; i < this.juegos.size(); i++){
            System.out.println(this.juegos.get(i).toString());
        }
    }

    /**
     * Generar un TreeSet de
     * Puntuacion, con todas las puntuaciones de los jugadores que jueguen a ese Juego
     */
    public TreeSet<Puntuacion> obtenerPuntuaciones(Integer idjuego){

        TreeSet<Puntuacion> obtengoPuntuacion = new TreeSet<>();

        for (int i = 0; i < this.jugadores.size(); i++){
            obtengoPuntuacion.add(this.jugadores.get(i).getPuntuaciones().get(idjuego));
        }
        return obtengoPuntuacion;
    }

    /**
     *  Que muestre la puntuación, partidas jugadas y
     * ganadas de ese usuario en ese juego. Debe hacerse lo más eficiente posible.
     */
    public void buscarPuntuacion(Integer idjuego, Integer idUsuario){

        StringBuffer sb = new StringBuffer("");
        sb.append("Usuario -> ").append(this.jugadores.get(idUsuario).getNick()).append("\n")
        .append("Puntuacion del juego -> ").append(this.jugadores.get(idUsuario).getPuntuaciones().get(idjuego).getPuntosObtenidos())
        .append("Partidas ganadas -> ").append(this.jugadores.get(idUsuario).getPuntuaciones().get(idjuego).getPartidosGanados())
        .append("Partidas jugadas -> ").append(this.jugadores.get(idUsuario).getPuntuaciones().get(idjuego).getPartidasJugadas());

    }

    /**
     *  Que pinte para cada juego una lista donde salga el Nick y los
     * puntos de cada Usuario que ha jugado ese juego, ordenado por puntuación de mayor a
     * menor. Intenta que salga en forma de tabla (printf). Debe hacerse lo más eficiente
     * posible.
     */
    /*public void pintarRankingJuegos(){

        StringBuffer sb = new StringBuffer("");

        for (int i = 0; i < this.juegos.size(); i++) {
           for (int j = 0; j < this.jugadores.size(); j++){
               if (this.jugadores.get(j).getPuntuaciones().containsKey(this.juegos.get(i))){
                   System.out.printf("Usuario --- " + this.jugadores.get(j).getNick());

               }
           }


        }
    }*/



}
