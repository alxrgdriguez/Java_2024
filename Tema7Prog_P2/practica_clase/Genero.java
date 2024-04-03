package Tema7Prog_P2.practica_clase;

import java.util.Objects;

public class Genero {

    public static Long autoincremental = 1L;
    private Long id;
    private String nombre;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.id = autoincremental++;
    }

    //Getter and Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //toString

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Genero{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
