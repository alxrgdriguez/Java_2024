package BIBLIOTECA.ENTIDADES;

public class Revista extends Documento{

    private Integer numero;
    public Revista(String isbn, String titulo, Integer numPaginas, Integer numero) {
        super(isbn, titulo, numPaginas);
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Revista{");
        sb.append("numero=").append(numero);
        sb.append(", isbn='").append(isbn).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", prestadoA=").append(prestadoA);
        sb.append(", fechaPrestamo=").append(fechaPrestamo);
        sb.append(", numPaginas=").append(numPaginas);
        sb.append('}');
        return sb.toString();
    }
}
