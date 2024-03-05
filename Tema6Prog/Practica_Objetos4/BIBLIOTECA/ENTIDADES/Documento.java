package BIBLIOTECA.ENTIDADES;

import BIBLIOTECA.INTERFACES.Prestable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Documento implements Prestable {
    //Hacemos la clase abstracta para no crear Objetos de esta clase.
    //No importa que los métodos tengan código.

    protected String isbn;
    protected String titulo;
    protected Usuario prestadoA;
    protected LocalDate fechaPrestamo;
    protected Integer numPaginas;
    protected ArrayList<Autor> autores = new ArrayList<>();
    //Constructor--------

    public Documento(String isbn, String titulo, Integer numPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.fechaPrestamo = LocalDate.now();
        this.prestadoA = null;
    }
    //Getters and setters------
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getPrestadoA() {
        return prestadoA;
    }

    public void setPrestadoA(Usuario prestadoA) {
        this.prestadoA = prestadoA;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(Integer numPaginas) {
        this.numPaginas = numPaginas;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
    //toString-------------

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Documento{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", prestadoA=").append(prestadoA);
        sb.append(", fechaPrestamo=").append(fechaPrestamo);
        sb.append(", numPaginas=").append(numPaginas);
        sb.append('}');
        return sb.toString();
    }
    //Equals-------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(isbn, documento.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    //Métodos-------------

    /**
     * Prestamos a User un documento.
     * Añadimos un Documento a la lista del Usuario.
     * @param user
     */

    @Override
    public void prestaAUsuario(Usuario user) {
        this.prestadoA = user;
        user.addDocumento(this);
    }

    /**
     * Eliminamos el documento de la lista de prestados del Usuario.
     * @param user
     */

    @Override
    public void devuelve(Usuario user) {
        this.prestadoA = null;
        user.delDocumento(this);

    }

    /**
     * Comprobamos el estado del Docuemto, si está prestado o no.
     * @return "fasle" si prestadoA == null, y "true" si lo tenemos prestado.
     */

    @Override
    public boolean estaPrestado() {
        if (this.prestadoA == null){
            return false;
        } else {
            return true;
        }
    }

    public void addAutores(Autor autor){
        this.autores.add(autor);
    }
    public void delAutores(Autor autor){
        this.autores.remove(autor);
    }
}
