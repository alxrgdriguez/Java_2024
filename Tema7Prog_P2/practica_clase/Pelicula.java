package Tema7Prog_P2.practica_clase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Pelicula {

    private String id;
    private String titulo;
    private Integer year;
    private ArrayList<Genero> generos;
    private ArrayList<Director> directores;

    public Pelicula(String titulo, Integer year) {
        this.titulo = titulo;
        this.year = year;
        this.id = UUID.randomUUID().toString();
        this.generos = new ArrayList<Genero>();
        this.directores = new ArrayList<Director>();
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getYear() {
        return year;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public ArrayList<Director> getDirectores() {
        return directores;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public void setDirectores(ArrayList<Director> directores) {
        this.directores = directores;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pelicula{");
        sb.append("id='").append(id).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", year=").append(year);
        sb.append(", generos=").append(generos);
        sb.append(", directores=").append(directores);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;

        return Objects.equals(id, pelicula.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void addGenero(Genero genero) {
        this.generos.add(genero);
    }

    public void deleteGenero(Genero genero) {
        this.generos.remove(genero);
    }

    public void addDirector(Director director) {
        this.directores.add(director);
    }

    public void deleteDirector(Director director) {
        this.directores.remove(director);
    }
}