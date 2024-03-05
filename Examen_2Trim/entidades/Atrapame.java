package Examen_2Trim.entidades;

import Examen_2Trim.enums.TipoAsiento;
import Examen_2Trim.enums.TipoTarifa;

import java.util.ArrayList;

public class Atrapame {

    private ArrayList<Vuelo> vuelos;
    private ArrayList<ReservaVuelo> reservas;

    public Atrapame() {

        this.vuelos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    //Getters

    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public ArrayList<ReservaVuelo> getReservas() {
        return reservas;
    }

    // --- Metodos ---

    /**
     * Metodo para añadir un vuelo
     * @param vuelo
     */
    public void addVuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);

    }

}
