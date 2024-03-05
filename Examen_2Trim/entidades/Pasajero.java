package Examen_2Trim.entidades;

import Tema5Prog.ejemploArrayList.Producto;

public class Pasajero extends Persona{

    //Propiedades

   private String preferenciasComida;
   private String restriccionesMedicas;
   private Asiento asiento;

   //Constructor

   /**
    * Constructor con todos los parametros
    */

   public Pasajero(long id, String nombre, String apellidos, String dniPasaporte, String email, String direccion, String ciudad, String pais, int telefono, String preferenciasComida, String restriccionesMedicas, Asiento asiento) {
      super(id, nombre, apellidos, dniPasaporte, email, direccion, ciudad, pais, telefono);
      this.preferenciasComida = preferenciasComida;
      this.restriccionesMedicas = restriccionesMedicas;
      this.asiento = asiento;
   }

   /**
    * Constructor copia
    */

   public Pasajero(Pasajero pasajero) {

     this.preferenciasComida = pasajero.getPreferenciasComida();
     this.restriccionesMedicas = pasajero.getRestriccionesMedicas();
     this.asiento = pasajero.getAsiento();
   }

   //Getters and Setters

   public String getPreferenciasComida() {
      return preferenciasComida;
   }

   public void setPreferenciasComida(String preferenciasComida) {
      this.preferenciasComida = preferenciasComida;
   }

   public String getRestriccionesMedicas() {
      return restriccionesMedicas;
   }

   public void setRestriccionesMedicas(String restriccionesMedicas) {
      this.restriccionesMedicas = restriccionesMedicas;
   }

   public Asiento getAsiento() {
      return asiento;
   }

   public void setAsiento(Asiento asiento) {
      this.asiento = asiento;
   }

   //toString

   @Override
   public String toString() {
      final StringBuffer sb = new StringBuffer("Pasajero{");
      sb.append("preferenciasComida='").append(preferenciasComida).append('\'');
      sb.append(", restriccionesMedicas='").append(restriccionesMedicas).append('\'');
      sb.append(", asiento=").append(asiento);
      sb.append(", id=").append(id);
      sb.append(", nombre='").append(nombre).append('\'');
      sb.append(", apellidos='").append(apellidos).append('\'');
      sb.append(", dniPasaporte='").append(dniPasaporte).append('\'');
      sb.append(", email='").append(email).append('\'');
      sb.append(", direccion='").append(direccion).append('\'');
      sb.append(", ciudad='").append(ciudad).append('\'');
      sb.append(", pais='").append(pais).append('\'');
      sb.append(", telefono=").append(telefono);
      sb.append('}');
      return sb.toString();
   }


}
