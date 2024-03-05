package BIBLIOTECA.ENTIDADES;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    private String dni;
    private String nombre;
    private Integer limitePrestamos;
    private Integer limitePlazoPrestamos; //Días
    private ArrayList<Documento> documentosEnPrestamo;

    //Constructor-----

    public Usuario(String dni, String nombre, Integer limitePrestamos, Integer limitePlazoPrestamos) {
        this.dni = dni;
        this.nombre = nombre;
        this.limitePrestamos = limitePrestamos;
        this.limitePlazoPrestamos = limitePlazoPrestamos;
        this.documentosEnPrestamo = new ArrayList<>();
    }

    //Getters and Setters-----

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLimitePrestamos() {
        return limitePrestamos;
    }

    public void setLimitePrestamos(Integer limitePrestamos) {
        this.limitePrestamos = limitePrestamos;
    }

    public Integer getLimitePlazoPrestamos() {
        return limitePlazoPrestamos;
    }

    public void setLimitePlazoPrestamos(Integer limitePlazoPrestamos) {
        this.limitePlazoPrestamos = limitePlazoPrestamos;
    }

    public ArrayList<Documento> getDocumentosEnPrestamo() {
        return documentosEnPrestamo;
    }
    //toString-----------------------------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usuario{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", limitePrestamos=").append(limitePrestamos);
        sb.append(", limitePlazoPrestamos=").append(limitePlazoPrestamos);
        sb.append(", documentosEnPrestamo=").append(documentosEnPrestamo);
        sb.append('}');
        return sb.toString();
    }

    //Equals-----------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(dni, usuario.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
    //Métodos-----------------------------------

    /**
     * Añadimos un documento a la colección
     * @param doc
     */
    public void addDocumento(Documento doc){
        this.documentosEnPrestamo.add(doc);
    }

    /**
     * Eliminamos documentos de la colección
     * @param doc
     */
    public void delDocumento(Documento doc){
        this.documentosEnPrestamo.remove(doc);
    }

    /**
     * Comprobamos que los documentos en posesion y el límite de prestamos son o no iguales
     * @return "true" si hemos llegado al límite de Docuemtnos, y "false" si todavía no hemos alcanzado ese límite.
     * Nunca nos vamos a poder pasar de ese límite.
     */
    public boolean alcanzadoLimitePrestamos(){
        if (this.limitePrestamos < this.documentosEnPrestamo.size()){
            return true;
        } else {
            return false;
        }
    }
}
