package Tema7Prog_P2.practica2_stream.videojuego.entidades;

import Tema7Prog_P2.practica2_stream.videojuego.enums.Plataforma;

public class Juego {

    //Propiedades
    public static Integer id = 0;
    private String nombre;
    private Plataforma plataforma;

    //Constructor
    public Juego(String nombre, Plataforma plataforma) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        id++;
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Juego{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", plataforma=").append(plataforma);
        sb.append('}');
        return sb.toString();
    }
}
