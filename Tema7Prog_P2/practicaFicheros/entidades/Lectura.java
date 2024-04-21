package Tema7Prog_P2.practicaFicheros.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Lectura {

    //Propiedades
    private Integer id;
    private Double temperatura;
    private Double humedad;
    private LocalDate momento;
    private Finca finca;

    //Constructor
    public Lectura(Integer id, Double temperatura, Double humedad, LocalDate momento, Finca finca) {
        this.id = id;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.momento = momento;
        this.finca = finca;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
        this.momento = momento;
    }

    public Finca getFinca() {
        return finca;
    }

    public void setFinca(Finca finca) {
        this.finca = finca;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lectura{");
        sb.append("id=").append(id);
        sb.append(", temperatura=").append(temperatura);
        sb.append(", humedad=").append(humedad);
        sb.append(", momento=").append(momento);
        sb.append(", finca=").append(finca);
        sb.append('}');
        return sb.toString();
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lectura lectura = (Lectura) o;
        return Objects.equals(id, lectura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
