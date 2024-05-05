package Tema7Prog_P2.pruebaEscritaPasado.model;

import java.time.LocalDate;
import java.util.Objects;

public class RegistroDatosDia implements Comparable{

    //Propiedades
    private Integer id;
    private String fecha;
    private Double tempMax;
    private Double tempMin;
    private Double tempMedia;
    private Integer idEstacion;

    //Constructor

    /**
     * Constructor parametrizado
     * @param id
     * @param fecha
     * @param tempMax
     * @param tempMin
     * @param tempMedia
     */
    public RegistroDatosDia(Integer id, String fecha, Double tempMax, Double tempMin, Double tempMedia, Integer idEstacion) {
        this.id = id;
        this.fecha = fecha;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.tempMedia = tempMedia;
        this.idEstacion = idEstacion;
    }

    /**
     * Constructor vacio
     */
    public RegistroDatosDia() {
    }



    //Getters y Setters

    public Integer getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMedia() {
        return tempMedia;
    }

    public void setTempMedia(Double tempMedia) {
        this.tempMedia = tempMedia;
    }

    public Integer getIdEstacion() {
        return idEstacion;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RegistroDatosDia{");
        sb.append("id=").append(id);
        sb.append(", fecha=").append(fecha);
        sb.append(", tempMax=").append(tempMax);
        sb.append(", tempMin=").append(tempMin);
        sb.append(", tempMedia=").append(tempMedia);
        sb.append('}');
        return sb.toString();
    }

    //equals por id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroDatosDia that = (RegistroDatosDia) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public int compareTo(Object o) {
        if(((RegistroDatosDia)o).getId().equals(this.getId())){
            return 0;
        }else {
            return 1;
        }
    }
}
