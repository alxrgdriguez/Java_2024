package Tema7Prog_P2.practica_clase2;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Pedido {

    private Long id;
    private LocalDate fechaPedido;
    private LocalDate fechaEnvio;
    private Estado estado;
    private Cliente cliente;
    private Set<Producto> producto;

    public Pedido(Long id, LocalDate fechaPedido, LocalDate fechaEnvio, Estado estado, Cliente cliente) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
        this.cliente = cliente;
        this.producto = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Set<Producto> producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pedido{");
        sb.append("id=").append(id);
        sb.append(", fechaPedido=").append(fechaPedido);
        sb.append(", fechaEnvio=").append(fechaEnvio);
        sb.append(", estado=").append(estado);
        sb.append(", cliente=").append(cliente);
        sb.append(", producto=").append(producto);
        sb.append('}');
        return sb.toString();
    }
}
