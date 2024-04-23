package Tema7Prog_P2.practicaFicheros.entidades;

import java.util.Objects;

public class Finca {

    //Propiedades
    public static Integer id = 0;
    private Integer idFinca;
    private String nombre;
    private Double longitud;
    private Double latitud;
    private Integer superficie;
    private String localidad;
    private String provincia;

    //Constructor
    public Finca(Integer id, String nombre, Double longitud, Double latitud, Integer superficie, String localidad, String provincia) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
        this.superficie = superficie;
        this.localidad = localidad;
        this.provincia = provincia;
        this.idFinca = id;
    }

    //Getters y Setters


    public Integer getIdFinca() {
        return idFinca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Finca{");
        sb.append("idFinca=").append(idFinca);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", longitud=").append(longitud);
        sb.append(", latitud=").append(latitud);
        sb.append(", superficie='").append(superficie).append('\'');
        sb.append(", localidad='").append(localidad).append('\'');
        sb.append(", provincia='").append(provincia).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //equals por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finca finca = (Finca) o;
        return Objects.equals(idFinca, finca.idFinca);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idFinca);
    }
}
