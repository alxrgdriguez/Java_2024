package Tema7Prog.sets;

import java.util.Objects;

public class Empleado implements Comparable<Empleado> {

    private String nombre;
    private String departamento;
    private Double sueldo;
    private String email;
    private String pais;

    public Empleado(String nombre, String departamento, Double sueldo, String email, String pais) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.email = email;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", sueldo=" + sueldo +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(email, empleado.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    /**
     * @param o the object to be compared.
     * @return 0 si son iguales
     *         >0 si el objeto es mayor que o (parámetro)
     *         <0 si el objeto es menor que o (parámetro)
     */
    @Override
    public int compareTo(Empleado o) {
        return this.email.compareTo(o.getEmail());
    }
}
