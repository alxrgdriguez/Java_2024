package Tema7Prog_P2.practica2_stream.videojuego.entidades;

import Tema4Prog.Ejemplos_BasicosPOO.Jugador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
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
        this.jugadores.forEach(System.out::println);
    }

    /**
     * Que pinte todos los juegos
     */
    public void listarJuegos(){
        this.juegos.forEach(System.out::println);
    }

    /**
     * Generar un TreeSet de
     * Puntuacion, con todas las puntuaciones de los jugadores que jueguen a ese Juego
     */
    public TreeSet<Puntuacion> obtenerPuntuaciones(Integer idjuego){

        TreeSet<Puntuacion> obtengoPuntuacion = new TreeSet<>(Comparator.comparing(Puntuacion::getPuntosObtenidos));

       this.jugadores.stream()
               .filter(j -> j.getPuntuaciones().containsKey(idjuego))
               .map(jugador -> jugador.getPuntuaciones().get(idjuego))
               .forEach(obtengoPuntuacion::add);
        return obtengoPuntuacion;
    }

    /**
     *  Que muestre la puntuación, partidas jugadas y
     * ganadas de ese usuario en ese juego. Debe hacerse lo más eficiente posible.
     */
    public void buscarPuntuacion(Integer idjuego, Integer idUsuario){

       this.jugadores.stream()
               .filter(jugador -> jugador.getId().equals(idUsuario))
               .map(jugador -> jugador.getPuntuaciones().get(idjuego))
               .forEach(System.out::println);
    }

    /**
     *  Que pinte para cada juego una lista donde salga el Nick y los
     * puntos de cada Usuario que ha jugado ese juego, ordenado por puntuación de mayor a
     * menor. Intenta que salga en forma de tabla (printf). Debe hacerse lo más eficiente
     * posible.
     */
    public void pintarRankingJuegos(){

        this.juegos.forEach(juego -> {
            System.out.println( "----- " + juego.getNombre() + " -----");
            this.jugadores.stream()
                    .filter(jugador -> jugador.getPuntuaciones().containsKey(juego.getId()))
                    .sorted(new Comparator<Usuario>() {
                        @Override
                        public int compare(Usuario o1, Usuario o2) {
                            return o2.getPuntuacion(juego.getId()).compareTo(o1.getPuntuacion(juego.getId()));
                        }
                    })
                    .forEach(jugador -> {
                        System.out.printf("Nick -> " + jugador.getNick() + " | " + "Puntos -> " + jugador.getPuntuacion(juego.getId()));
                    });
        });

   }

}
