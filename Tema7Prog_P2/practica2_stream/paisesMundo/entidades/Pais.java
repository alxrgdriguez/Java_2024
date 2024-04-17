package Tema7Prog_P2.practica2_stream.paisesMundo.entidades;

import Tema7Prog_P2.practica2_stream.paisesMundo.enums.Continente;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pais {

    //Propiedades
    public static Integer id = 0;
    private Integer idPais;
    private String nombre;
    private Integer superficie;
    private Continente continente;
    private Ciudad capital;
    private Integer poblacion;
    private List<Ciudad> ciudades;

    //Constructor
    public Pais(String nombre, Integer superficie, Continente continente, Ciudad ciudad, Integer poblacion) {
        this.idPais = id++;
        this.nombre = nombre;
        this.superficie = superficie;
        this.continente = continente;
        this.capital = capital;
        this.poblacion = poblacion;
        this.ciudades = new ArrayList<>();
    }

    //Getters y Setters

    public Integer getIdPais() {
        return idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public Ciudad getCapital() {
        return capital;
    }

    public void setCapital(Ciudad capital) {
        this.capital = capital;
    }

    public Integer getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(Integer poblacion) {
        this.poblacion = poblacion;
    }


    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pais{");
        sb.append("idPais=").append(idPais);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", superficie=").append(superficie);
        sb.append(", continente=").append(continente);
        sb.append(", capital=").append(capital);
        sb.append(", poblacion=").append(poblacion);
        sb.append(", ciudades=").append(ciudades);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(idPais, pais.idPais);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPais);
    }

    // --- Metodos ---

    /**
     * Metodo para añadir una ciudad a la List<Ciudad>
     */
    public void addCiudad(Ciudad ciudad){
        this.ciudades.add(ciudad);
    }

    /**
     * Metodo para eliminar una ciudad de List<Ciudad>
     */
    public void removeCiudad(Ciudad ciudad){
        this.ciudades.remove(ciudad);
    }
}
