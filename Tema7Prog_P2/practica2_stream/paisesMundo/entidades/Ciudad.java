package Tema7Prog_P2.practica2_stream.paisesMundo.entidades;

import java.util.Objects;

public class Ciudad {

    //Propiedades
    public static Integer id = 0;
    private Integer idCiudad;
    private String nombre;
    private Integer poblacion;
    private Pais pais;

    //Constructor
    public Ciudad(String nombre, Integer poblacion, Pais pais) {
        this.idCiudad = id++;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;

    }

    //Getters y Setters
    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Ciudad.id = id;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }


    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ciudad{");
        sb.append("idCiudad=").append(idCiudad);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", poblacion=").append(poblacion);
        sb.append(", pais=").append(pais);
        sb.append('}');
        return sb.toString();
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ciudad ciudad = (Ciudad) o;
        return Objects.equals(idCiudad, ciudad.idCiudad);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idCiudad);
    }
}
