package Tema7Prog_P2.pruebaEscritaPasado2.entidades;

public class HotelRural extends Hotel {

    private Boolean calefacion;


    public HotelRural(String nombre, String direccion, String localidad, String provincia, Integer numHabitaciones, Double precioNoche, Integer calificacion, Boolean calefacion) {
        super(nombre, direccion, localidad, provincia, numHabitaciones, precioNoche, calificacion);
        this.calefacion = calefacion;
    }

    public Boolean getCalefacion() {
        return calefacion;
    }

    public void setCalefacion(Boolean calefacion) {
        this.calefacion = calefacion;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HotelRural{");
        sb.append("idHotelRural=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", localidad='").append(localidad).append('\'');
        sb.append(", provincia='").append(provincia).append('\'');
        sb.append(", numHabitaciones=").append(numHabitaciones);
        sb.append(", precioNoche=").append(precioNoche);
        sb.append(", calificacion=").append(calificacion);
        sb.append(", calefacion=").append(calefacion);
        sb.append('}');
        return super.toString();
    }


}
