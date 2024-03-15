package Tema7Prog.ejercicios.productos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchProductos {

    public static void main(String[] args) {

        ArrayList<Producto> productos = new ArrayList<>();
        for(long i=0; i<20000000; i++) {
            productos.add(new Producto(i, "Producto"+i, 500.0 - i%10000));
        }

        Long tiempo = System.currentTimeMillis();
        int index = productos.indexOf(new Producto(12000000l, "", 0.0));
        System.out.println(System.currentTimeMillis() - tiempo);
        System.out.println(productos.get(index));


        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        /*
        for(Producto p: productos) {
            System.out.println(p);
        }
        */

        tiempo = System.currentTimeMillis();
        int indice = Collections.binarySearch(productos, new Producto(12000000l, "", 0.0));
        System.out.println(System.currentTimeMillis() - tiempo);

        System.out.println(productos.get(indice));




    }
}
