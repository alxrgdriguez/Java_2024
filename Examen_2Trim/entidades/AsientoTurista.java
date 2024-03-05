package Examen_2Trim.entidades;

import Examen_2Trim.enums.TipoAsiento;

public class AsientoTurista extends Asiento {

    //Propiedades
    private boolean ventana;

    //Constructor

    /**
     * Constructor parametrizado (sin pasajero ni tipoAsiento)
     */
    public AsientoTurista(long id, double precioBase, int fila, String letra, boolean ventana) {
        super(id, precioBase, fila, letra);
        this.tipoAsiento = TipoAsiento.TURISTA;
        this.ventana = ventana;
    }

    //Getters and Setters

    public boolean isVentana() {
        return ventana;
    }

    public void setVentana(boolean ventana) {
        this.ventana = ventana;
    }

    //toString


    // --- Metodos ---

    /**
     * Metodo para calcular el precio AsientoTurista
     * @return el precio del asiento
     */
    @Override
    public double calcularPrecio() {

        double precioasiento = this.precioBase;

        if (tipoAsiento.equals(ventana)){

            precioasiento += 10;
        }
        return precioasiento;
    }
}
