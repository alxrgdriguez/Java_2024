package Examen_2Trim.entidades;

public class AsientoBusiness extends Asiento {

    //Propiedades

    private boolean comida;

    //Constructor

    /**
     * Constructor parametrizado (sin pasajero ni tipoAsiento)
     */
    public AsientoBusiness(long id, double precioBase, int fila, String letra, boolean comida) {
        super(id, precioBase, fila, letra);
        this.comida = comida;
    }

    //Getters and Setters

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    // --- Metodos ---

    /**
     * Metodo para calcular el precio AsientoTurista
     * @return el precio del asiento
     */
    @Override
    public double calcularPrecio() {

        double precioasiento = this.precioBase;

            if (this.tipoAsiento.equals(comida)){

                precioasiento += 30;
            }

        return precioasiento + 0.25;

    }
}
