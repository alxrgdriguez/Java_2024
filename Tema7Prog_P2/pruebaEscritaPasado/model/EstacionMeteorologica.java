package Tema7Prog_P2.pruebaEscritaPasado.model;

import java.time.LocalDate;
import java.util.*;

public class EstacionMeteorologica {

    //Propiedades
    private Integer id;
    private String nombre;
    private String comunidad;
    private Double latitud;
    private Double longitud;
    private TreeSet<RegistroDatosDia> registrosDia;

    //Constructor
    public EstacionMeteorologica(Integer id, String nombre, String comunidad, Double latitud, Double longitud, TreeSet<RegistroDatosDia> registrosDia) {
        this.id = id;
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.latitud = latitud;
        this.longitud = longitud;
        this.registrosDia = registrosDia;
    }

    public EstacionMeteorologica() {
        this.id = null;
        this.nombre = null;
        this.comunidad = null;
        this.latitud = null;
        this.longitud = null;
        this.registrosDia = null;
    }

    //Getters y Setters

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public TreeSet<RegistroDatosDia> getRegistrosDia() {
        return registrosDia;
    }

    public void setRegistrosDia(TreeSet<RegistroDatosDia> registrosDia) {
        this.registrosDia = registrosDia;
    }

    //toString
    @Override
    public java.lang.String toString() {
        final StringBuffer sb = new StringBuffer("EstacionMeteorologica{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", comunidad=").append(comunidad);
        sb.append(", latitud=").append(latitud);
        sb.append(", longitud=").append(longitud);
        sb.append(", registrosDia=").append(registrosDia);
        sb.append('}');
        return sb.toString();
    }

    //equals por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacionMeteorologica that = (EstacionMeteorologica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //METODOS ---------------------------

    /**
     * Añadir un registro
     */
    public void addRegistro(RegistroDatosDia registro) {
        this.registrosDia.add(registro);
    }

    /**
     * Eliminar un registro
     */
    public void delRegistro(RegistroDatosDia registro) {
        this.registrosDia.remove(registro);
    }

    /**
     * Devuelve todos los registros de esa fecha.
     * @param fecha
     * @return
     */
    public List<RegistroDatosDia> buscarRegistro(LocalDate fecha){
        return registrosDia.stream()
               .filter(registro -> registro.getFecha().equals(fecha))
               .toList();

    }
}
