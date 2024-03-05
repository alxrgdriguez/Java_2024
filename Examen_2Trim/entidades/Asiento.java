package Examen_2Trim.entidades;

import Examen_2Trim.enums.TipoAsiento;

import java.util.Objects;

public abstract class Asiento {

    //Propiedades

    protected long id;
    protected Pasajero pasajero;
    protected double precioBase;
    protected int fila;
    protected  String letra;
    protected TipoAsiento tipoAsiento;

    //Constructor

    /**
     * Constructor parametrizado (sin pasajero ni tipoAsiento)
     *
     */

    public Asiento(long id, double precioBase, int fila, String letra) {
        this.id = id;
        this.precioBase = precioBase;
        this.fila = fila;
        this.letra = letra;

    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public void setTipoAsiento(TipoAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    //equals por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asiento asiento = (Asiento) o;
        return id == asiento.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // --- Metodos ---

    public String getCodigo(){

        //Verlo despues
        this.fila = getFila();
        return getLetra();
    }

    /**
     * Metodo abstracto para calcular el precio dependiendo de cada vuelo
     * @return
     */
    public abstract double calcularPrecio();
}
