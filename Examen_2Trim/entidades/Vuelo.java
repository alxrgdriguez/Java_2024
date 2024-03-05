package Examen_2Trim.entidades;

import Examen_2Trim.enums.TipoAsiento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Vuelo {

    //Propiedades

    private String codigo;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private double precioBase;
    private int asientosDisponibles;
    private ArrayList<ArrayList<Asiento>> asientos;

    //Constructor

    /**
     *Constructor parametrizado
     */
    public Vuelo(String codigo, String origen, String destino, LocalDate fecha, LocalTime hora, double precioBase, int asientosDisponibles) {
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precioBase = precioBase;
        this.asientosDisponibles = asientosDisponibles;
        this.asientos = new ArrayList<>();

    }

    public Vuelo(ArrayList<Asiento> asientos){


        for (int i = 0; i < this.asientos.size(); i++){
            double asientoBussines = (asientosDisponibles * 0.3);
            this.asientos.add(asientos);

        }

        for (int i = 0; i < this.asientos.size(); i++){
            double asientoTurista = (asientosDisponibles * 0.70);
            this.asientos.add(asientos);
        }
    }


    //Getters and Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public ArrayList<ArrayList<Asiento>> getAsientos() {
        return asientos;
    }

    public void setAsientos(ArrayList<ArrayList<Asiento>> asientos) {
        this.asientos = asientos;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Vuelo{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", origen='").append(origen).append('\'');
        sb.append(", destino='").append(destino).append('\'');
        sb.append(", fecha=").append(fecha);
        sb.append(", hora=").append(hora);
        sb.append(", precioBase=").append(precioBase);
        sb.append(", asientosDisponibles=").append(asientosDisponibles);
        sb.append(", asientos=").append(asientos);
        sb.append('}');
        return sb.toString();
    }

    //equals -- codigo

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vuelo vuelo = (Vuelo) o;
        return Objects.equals(codigo, vuelo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // --- Metodos ---

    public boolean ocuparAsiento(){

        boolean estaOcupado = false;

        if (this.asientos == null){

            estaOcupado = true;

        }
        return estaOcupado;
    }


    public void diasFaltanVuelo(){


    }

}

