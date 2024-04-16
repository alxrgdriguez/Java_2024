package Tema7Prog_P2.Clase_Ficheros1.servicios;

import Tema7Prog_P2.Clase_Ficheros1.model.Gamer;

import java.util.*;

public class Discord {

    //Atributos
    private HashSet<Gamer> gamers;

    //Constructor
    public Discord(List<Gamer> gamers) {
        this.gamers = new HashSet<>(gamers);
    }

    public Discord() {
        this.gamers = new HashSet<>();
    }

    public HashSet<Gamer> getGamers() {
        return gamers;
    }

    // -- Metodos --

    /**
     * Metodo para añadir un jugador
     * @param gamer
     */
    public void addGamer(Gamer gamer) {
        this.gamers.add(gamer);
    }

    /**
     * Metodo para eliminar un jugador
     * @param gamer
     */
    public void delGamer(Gamer gamer) {
        this.gamers.remove(gamer);
    }

    /**
     * Encontrar un jugador encontrado por nick
     */
    public Gamer findGamer(String nick) throws NoSuchElementException {
      return gamers.stream()
                .filter(j -> j.getNick().equals(nick))
                .findFirst()
                .orElse(new Gamer());
    }

    /**
     *Mostrar todos los jugadores con su información
     */

    public void listGamers() {
        gamers.stream()
                .sorted(Comparator.comparing(Gamer::getId))
                .forEach(System.out::println);
    }

    /**
     *  Deberá tomar la colección de Gamers y sobreescribir el fichero “gamers.txt” con los
     * que haya en la colección. Prueba a crear un destructor y llamar a este método en un destructor.
     */

    public void setGamers(HashSet<Gamer> gamers) {
        this.gamers = gamers;

    }

    public Long getMaxId(){
        return gamers.stream()
                .mapToLong(Gamer::getId)
                .max()
                .orElse(10000000L);

    }


}
