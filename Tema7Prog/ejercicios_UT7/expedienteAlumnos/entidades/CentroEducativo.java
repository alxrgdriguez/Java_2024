package Tema7Prog.ejercicios_UT7.expedienteAlumnos.entidades;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class CentroEducativo {

    //Atributos
    private TreeSet<Expediente> expedientes;
    private String nombreCentro;
    private String direccion;
    private String localidad;
    private Integer telefono;
    private String email;

    //Constructor
    public CentroEducativo(TreeSet<Expediente> expedientes, String nombreCentro, String direccion, String localidad, Integer telefono, String email) {
        this.expedientes = expedientes;
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.email = email;
    }

    //Getters y Setters
    public TreeSet<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(TreeSet<Expediente> expedientes) {
        this.expedientes = expedientes;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CentroEducativo{");
        sb.append("expedientes=").append(expedientes);
        sb.append(", nombreCentro='").append(nombreCentro).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", localidad='").append(localidad).append('\'');
        sb.append(", telefono=").append(telefono);
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //equals por nombreEducativo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroEducativo that = (CentroEducativo) o;
        return Objects.equals(nombreCentro, that.nombreCentro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombreCentro);
    }


    //METODOS -------------------------------

    /**
     * Metodo para añadir un expediente
     */
    public void addExpediente(Expediente expediente){
        this.expedientes.add(expediente);
    }

    /**
     * Metodo para eliminar un expediente
     */
    public void eliminarExpediente(Expediente expediente){
        this.expedientes.remove(expediente);
    }

    /**
     * Metodo para buscar un expediente por dni
     */
    public Expediente buscarExpediente(String dni){
       /* for (Expediente expedienteBuscado : this.expedientes){
            if (expedienteBuscado.getEstudiante().getDni().equals(dni))
                return expedienteBuscado;
        }
        return null;*/

       return this.expedientes.stream()
               .filter(expediente -> expediente.getEstudiante().getDni().equals(dni))
               .findFirst()
               .orElse(null);

    }

}
