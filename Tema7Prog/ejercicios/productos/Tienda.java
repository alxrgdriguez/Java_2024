package Tema7Prog.ejercicios.productos;

import java.util.TreeMap;

public class Tienda {

    TreeMap<String, Producto> productos = new TreeMap<>();

    public TreeMap<String, Producto> getProductos() {
        return productos;
    }

    public void nuevoProducto(String clave, Producto p) {
        this.productos.put(clave, p);
    }

    public void eliminarProducto(String clave) {
        this.productos.remove(clave);
    }

    public void pintar() {
        for(String clave : productos.keySet()) {
            System.out.println(clave + " -> " + productos.get(clave));
        }
    }

    public Producto buscar(String clave) {
        return productos.get(clave);
    }
}
