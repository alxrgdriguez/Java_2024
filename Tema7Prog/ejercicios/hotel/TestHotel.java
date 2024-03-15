package Tema7Prog.ejercicios.hotel;

import java.util.*;

public class TestHotel {

    public static void main(String[] args) {

        HashSet<Hotel> hoteles = new HashSet<>(20);
        hoteles.add(new Hotel(1, Zona.PLAYA, 100.0));
        hoteles.add(new Hotel(2, Zona.PLAYA, 110.0));
        hoteles.add(new Hotel(3, Zona.PLAYA, 120.0));
        hoteles.add(new Hotel(4, Zona.PLAYA, 105.0));
        hoteles.add(new Hotel(5, Zona.PLAYA, 101.0));
        hoteles.add(new Hotel(6, Zona.MONTAÑA, 80.0));
        hoteles.add(new Hotel(7, Zona.MONTAÑA, 82.0));
        hoteles.add(new Hotel(8, Zona.MONTAÑA, 85.0));
        hoteles.add(new Hotel(9, Zona.MONTAÑA, 90.0));
        hoteles.add(new Hotel(10, Zona.MONTAÑA, 79.0));
        hoteles.add(new Hotel(11, Zona.RURAL, 120.0));
        hoteles.add(new Hotel(12, Zona.RURAL, 110.0));
        hoteles.add(new Hotel(13, Zona.RURAL, 120.0));
        hoteles.add(new Hotel(14, Zona.RURAL, 130.0));
        hoteles.add(new Hotel(15, Zona.RURAL, 120.0));
        hoteles.add(new Hotel(15, Zona.RURAL, 120.0));

        /*
        for(Hotel h: hoteles) {
            System.out.println(h);
        }
        */

        // ORDENAR CON TREESET SI TENGO CONTROLADOS LOS REPETIDOS
        TreeSet<Hotel> hotelesOrdenados = new TreeSet<>();
        for(Hotel h: hoteles) {
            if (h.getZona().equals(Zona.PLAYA)) {
                hotelesOrdenados.add(h);
            }
        }

        for(Hotel h: hotelesOrdenados) {
            System.out.println(h);
        }

        //ORDENAR CON ARRAYLIST, SI TENGO CON LOS REPETIDOS

        ArrayList<Hotel> hotelesOrdenados2 = new ArrayList<>();
        for(Hotel h: hoteles) {
            if (h.getZona().equals(Zona.PLAYA)) {
                hotelesOrdenados2.add(h);
            }
        }
        /*
        hotelesOrdenados2.stream()
                .filter( h -> h.getZona().equals(Zona.PLAYA))
                .filter( h -> h.getPrecio() < 100)
                .map( h -> h.getId())
                .forEach(System.out::println);
        */
        Collections.sort(hotelesOrdenados2, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {
                return o1.getPrecio().compareTo(o2.getPrecio());
            }
        });

        System.out.println("------------");
        for(Hotel h: hotelesOrdenados2) {
            System.out.println(h);
        }

        hotelesOrdenados2.forEach(System.out::println);




    }
}
