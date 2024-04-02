package Tema8Prog.api_Stream.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Registro {

    // --- Propiedades ---

    private LocalDateTime fechaHora;
    private Double humedad;
    private Double temperatura;

    // --- Constructor ---

    /**
     * Constructor parametrizado
     */
    public Registro(LocalDateTime fechaHora, Double humedad, Double temperatura) {
        this.fechaHora = fechaHora;
        this.humedad = humedad;
        this.temperatura = temperatura;
    }

    /**
     * Constructor vacio
     */
    public Registro() {
    }

    // --- Getters y Setters ---

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getHumedad() {
        return humedad;
    }

    public void setHumedad(Double humedad) {
        this.humedad = humedad;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    // --- toString ---
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Registro{");
        sb.append("fechaHora=").append(fechaHora);
        sb.append(", humedad=").append(humedad);
        sb.append(", temperatura=").append(temperatura);
        sb.append('}');
        return sb.toString();
    }

    // --- equals por fechaHora ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registro registro = (Registro) o;
        return Objects.equals(fechaHora, registro.fechaHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora);
    }
}
