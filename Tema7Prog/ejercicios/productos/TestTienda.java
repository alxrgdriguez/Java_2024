package Tema7Prog.ejercicios.productos;

public class TestTienda {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        long antes = System.currentTimeMillis();

        for(long i=0; i<2000000; i++) {
            tienda.nuevoProducto("CR"+(2000000-i), new Producto(i, "Producto"+i, 100.0 + i%10000));
        }

        System.out.println(System.currentTimeMillis() - antes);

        //tienda.pintar();


    }
}
