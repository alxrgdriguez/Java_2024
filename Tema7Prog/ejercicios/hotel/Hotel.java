package Tema7Prog.ejercicios.hotel;

import java.util.Objects;

public class Hotel implements Comparable<Hotel> {

    private Integer id;
    private Zona zona;
    private Double precio;

    public Hotel(Integer id, Zona zona, Double precio) {
        this.id = id;
        this.zona = zona;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", zona=" + zona +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Hotel o) {
        return this.getPrecio().compareTo(o.getPrecio());
    }
}
