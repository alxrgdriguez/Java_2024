package Tema7Prog_P2.practica_clase;

import Tema6Prog.Practica_Objetos4.ArquilerPeliculas.entidades.Pelicula;

import java.util.ArrayList;
import java.util.Objects;

public class Director {

    public static Long autoincremental = 1L;
    private Long id;
    private String nombre;
    private ArrayList<Pelicula> peliculas;

    public Director(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.peliculas = new ArrayList<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Director{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", peliculas=").append(peliculas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(id, director.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addPelicula (Pelicula p){
        peliculas.add(p);
    }

    public void deletePelicula(Pelicula p){
        peliculas.remove(p);
    }
}
