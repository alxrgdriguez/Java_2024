package Tema7Prog.ejercicios_UT7.equipo_basket.entidades;

import Tema7Prog.ejercicios_UT7.equipo_basket.enums.Posicion;

public class JugadorBasket{

    //Propiedades
    private String nombre;
    private Double altuta;
    private Posicion posicion;
    private Double puntosPorPartido;
    private Double rebotesPorPartido;
    private Double taponesPorPartido;
    private Double asistenciasPorPartido;
    private Double robosPorPartido;

    //Constructor


    public JugadorBasket(String nombre, Double altuta, Posicion posicion, Double puntosPorPartido, Double rebotesPorPartido, Double taponesPorPartido, Double asistenciasPorPartido, Double robosPorPartido) {
        this.nombre = nombre;
        this.altuta = altuta;
        this.posicion = posicion;
        this.puntosPorPartido = puntosPorPartido;
        this.rebotesPorPartido = rebotesPorPartido;
        this.taponesPorPartido = taponesPorPartido;
        this.asistenciasPorPartido = asistenciasPorPartido;
        this.robosPorPartido = robosPorPartido;
    }

    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAltuta() {
        return altuta;
    }

    public void setAltuta(Double altuta) {
        this.altuta = altuta;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(Double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }

    public Double getRebotesPorPartido() {
        return rebotesPorPartido;
    }

    public void setRebotesPorPartido(Double rebotesPorPartido) {
        this.rebotesPorPartido = rebotesPorPartido;
    }

    public Double getTaponesPorPartido() {
        return taponesPorPartido;
    }

    public void setTaponesPorPartido(Double taponesPorPartido) {
        this.taponesPorPartido = taponesPorPartido;
    }

    public Double getAsistenciasPorPartido() {
        return asistenciasPorPartido;
    }

    public void setAsistenciasPorPartido(Double asistenciasPorPartido) {
        this.asistenciasPorPartido = asistenciasPorPartido;
    }

    public Double getRobosPorPartido() {
        return robosPorPartido;
    }

    public void setRobosPorPartido(Double robosPorPartido) {
        this.robosPorPartido = robosPorPartido;
    }

    //toString

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JugadorBasket{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", altuta=").append(altuta);
        sb.append(", posicion=").append(posicion);
        sb.append(", puntosPorPartido=").append(puntosPorPartido);
        sb.append(", rebotesPorPartido=").append(rebotesPorPartido);
        sb.append(", taponesPorPartido=").append(taponesPorPartido);
        sb.append(", asistenciasPorPartido=").append(asistenciasPorPartido);
        sb.append(", robosPorPartido=").append(robosPorPartido);
        sb.append('}');
        return sb.toString();
    }
}
