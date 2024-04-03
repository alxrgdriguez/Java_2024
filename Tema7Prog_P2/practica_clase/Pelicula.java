package Tema7Prog_P2.practica_clase;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Pelicula {

    private String id = UUID.randomUUID().toString();
    private String titulo;
    private Integer anio;
    private ArrayList<Genero> generos;
    private ArrayList<Director> directores;

    public Pelicula(String titulo, Integer anio) {
        this.titulo = titulo;
        this.anio = anio;
        this.id = UUID.randomUUID().toString();
        this.generos = new ArrayList<>();
        this.directores = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pelicula{");
        sb.append("id='").append(id).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", anio=").append(anio);
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
        return Objects.hash(id);
    }

    public void addGenero(Genero g) {
        generos.add(g);

    }

    public void deleteGenero(Genero g) {
        generos.remove(g);
    }

    public void addDirector(Director d) {
        directores.add(d);
    }

    public void deleteDirector(Director d) {
        directores.remove(d);
    }
}
