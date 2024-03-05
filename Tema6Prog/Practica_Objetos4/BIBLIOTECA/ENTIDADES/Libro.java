package BIBLIOTECA.ENTIDADES;

public class Libro extends Documento{
    private Integer anioPublicacion;
    public Libro(String isbn, String titulo, Integer numPaginas, Integer anioPublicacion) {
        super(isbn, titulo, numPaginas);
        this.anioPublicacion = anioPublicacion;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Libro{");
        sb.append("anioPublicacion=").append(anioPublicacion);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", prestadoA=").append(prestadoA);
        sb.append(", fechaPrestamo=").append(fechaPrestamo);
        sb.append(", numPaginas=").append(numPaginas);
        sb.append('}');
        return sb.toString();
    }
}
