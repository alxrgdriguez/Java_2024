package Examen_2Trim.entidades;

import Examen_2Trim.enums.TipoAsiento;
import Examen_2Trim.enums.TipoTarifa;
import Tema5Prog.McBurger.dominio.Menu;

import java.util.ArrayList;

public class ReservaVuelo {

    //Propiedades

    protected static long id;
    protected Vuelo vuelo;
    protected ArrayList<Pasajero> pasajeros;
    protected TipoTarifa tipoT;
    protected TipoAsiento tipoA;

    //Constructor
    public ReservaVuelo(Vuelo vuelo, ArrayList<Pasajero> pasajeros, TipoTarifa tipoT, TipoAsiento tipoA) {
        id++;
        this.vuelo = vuelo;
        this.pasajeros = pasajeros;
        this.tipoT = tipoT;
        this.tipoA = tipoA;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(ArrayList<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public TipoTarifa getTipoT() {
        return tipoT;
    }

    public void setTipoT(TipoTarifa tipoT) {
        this.tipoT = tipoT;
    }

    public TipoAsiento getTipoA() {
        return tipoA;
    }

    public void setTipoA(TipoAsiento tipoA) {
        this.tipoA = tipoA;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReservaVuelo{");
        sb.append("id=").append(id);
        sb.append(", vuelo=").append(vuelo);
        //imprimirBilletes()
        sb.append('}');
        return sb.toString();
    }

    // --- Metodos ---

    /**
     * Metodo para añadir un pasajero
     * @param pasajero
     */
    public void addPasajero(Pasajero pasajero){

        this.pasajeros.add(pasajero);
    }

    /**
     * Metodo para eliminar un pasajero
     */

    public void delPasajero(Pasajero pasajero){

        this.pasajeros.remove(pasajero);
    }

   /*public double calcularPrecioTotal(){

        double asientosReserva = 0;

   }*/



}
