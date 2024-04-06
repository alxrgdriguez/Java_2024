package Tema7Prog_P2.practica_clase2;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TestPedidos {

    public static void main(String[] args) {

        // Crear 3 clientes
        Cliente cliente1 = new Cliente(1L, "Alex", 2);
        Cliente cliente2 = new Cliente(2L, "Juan", 10);
        Cliente cliente3 = new Cliente(3L, "Pedro", 5);

        //Crear 5 productos para cada
        Producto periferico1 = new Producto(4L, "TECLADO1", Categoria.PERIFERICOS, 52.50);
        Producto periferico2 = new Producto(5L, "TECLADO2", Categoria.PERIFERICOS, 32.50);
        Producto periferico3 = new Producto(6L, "TECLADO3", Categoria.PERIFERICOS, 76.50);
        Producto periferico4 = new Producto(7L, "TECLADO4", Categoria.PERIFERICOS, 43.50);
        Producto periferico5 = new Producto(8L, "TECLADO5", Categoria.PERIFERICOS, 65.50);

        Producto libro1 = new Producto(9L, "LIRBO1", Categoria.LIBROS, 10.90);
        Producto libro2 = new Producto(10L, "LIRBO2", Categoria.LIBROS, 20.90);
        Producto libro3 = new Producto(11L, "LIRBO3", Categoria.LIBROS, 30.90);
        Producto libro4 = new Producto(12L, "LIRBO4", Categoria.LIBROS, 40.90);
        Producto libro5 = new Producto(13L, "LIRBO5", Categoria.LIBROS, 50.90);

        Producto juego1 = new Producto(14L, "JUEGO1", Categoria.JUEGOS, 25.60);
        Producto juego2 = new Producto(15L, "JUEGO2", Categoria.JUEGOS, 35.60);
        Producto juego3 = new Producto(16L, "JUEGO3", Categoria.JUEGOS, 45.60);
        Producto juego4 = new Producto(17L, "JUEGO4", Categoria.JUEGOS, 55.60);
        Producto juego5 = new Producto(18L, "JUEGO5", Categoria.JUEGOS, 65.60);


        //-------------------------------------------------------------------------------------

        //Realiza al menos
        //cuatro pedidos con al menos 5 productos en cada pedido

        Pedido ped1 = new Pedido(1L,LocalDate.of(2022, 4,20),
                LocalDate.of(2022, 4, 24 ), Estado.RECIBIDO, cliente1);
        Pedido ped2 = new Pedido(2L, LocalDate.of(2022, 10, 2),
                LocalDate.of(2022, 10, 3), Estado.PROCESADO, cliente2);
        Pedido ped3 = new Pedido(3L, LocalDate.of(2021, 9, 23),
                LocalDate.of(2021, 4, 28), Estado.RECIBIDO, cliente3);
        Pedido ped4 = new Pedido(4L, LocalDate.now(),
                LocalDate.of(2022, 4, 12), Estado.ENVIADO, cliente1);

        ped1.setProducto(new HashSet<>(List.of(periferico1, periferico2, periferico3, periferico4, periferico5)));
        ped2.setProducto(new HashSet<>(List.of(libro1, libro2, libro3, libro4, libro5)));
        ped3.setProducto(new HashSet<>(List.of(juego1, juego2, juego3, juego4, juego5)));
        ped4.setProducto(new HashSet<>(List.of(juego2, periferico4, libro5, juego5, libro2)));

        //STREAMS -----------------------------

        ArrayList<Pedido> pedidos = new ArrayList<>(List.of(ped1, ped2, ped3, ped4));

        //Muestra los libros cuyo precio sea mayor de 20€
        pedidos.stream()
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .filter(producto -> producto.getCategoria().equals(Categoria.LIBROS))
                .filter(producto -> producto.getPrecio() > 20)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");


        //Muestra los pedidos que tengan algún pedido de "Juegos"

        pedidos.stream()
                .filter(pedido -> pedido.getProducto().stream()

                        .anyMatch(producto -> producto.getCategoria().equals(Categoria.JUEGOS))
                )
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        //Genera una lista con todos los Libros pero cambia su precio para que lleven un 10% de descuento

        List<Producto> productoLibro = pedidos.stream()
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .filter(producto -> producto.getCategoria().equals(Categoria.LIBROS))
                .peek(producto -> producto.setPrecio(producto.getPrecio() * 0.90))
                .toList();
        System.out.println(productoLibro);

        System.out.println("----------------------------------------------------");

        //Saca los productos que aparecen en los pedidos de clientes de nivel 2, realizados entre el 20-04-
        //2022 y el 20-05-2022. Hay que usar flatmap para unir todos los productos de todos los pedidos:
        //.flatMap( p -> p.getProductos().stream())

        pedidos.stream()
                .filter(pedido -> pedido.getCliente().getNivel().equals(2))
                .filter(pedido -> pedido.getFechaPedido().isAfter(LocalDate.of(2022, 4, 19)))
                .filter(pedido -> pedido.getFechaPedido().isBefore(LocalDate.of(2022, 5, 21)))
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .forEach(System.out::println);

        //Muestra el producto más caro de la categoría Juegos

        System.out.println("----------------------------------------------------");

        Producto productoP = pedidos.stream()
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .filter(producto -> producto.getCategoria().equals(Categoria.JUEGOS))
                .max(Comparator.comparing(Producto::getPrecio))
                .orElse(null);
        System.out.println(productoP);

        System.out.println("----------------------------------------------------");

        //Devuelve los dos pedidos más recientes

        pedidos.stream()
            .sorted(Comparator.comparing(Pedido::getFechaPedido).reversed())
            .limit(2)
            .forEach(System.out::println);

        System.out.println("----------------------------------------------------");

        //Muestra los pedidos hechos hoy, debe aparecer el pedido y debajo la lista de productos de ese
        //pedido (peek y flatmap)

        pedidos.stream()
                .filter(pedido -> pedido.getFechaPedido().equals(LocalDate.of(2022, 4,20)))
                .peek(pedido -> System.out.println("Id de pedido: " + pedido.getId()))
                .flatMap(pedido -> pedido.getProducto().stream())
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");


        //Calcula el total de todos los pedidos de Abril de 2022

       Double total = pedidos.stream()

               .filter(pedido -> pedido.getFechaPedido().getYear() == 2022)
               .filter(pedido -> pedido.getFechaPedido().getMonth() == Month.APRIL)
               .flatMap(pedido -> pedido.getProducto().stream())
               .map(Producto::getPrecio)
               .mapToDouble(Double::doubleValue)
               .sum();
        System.out.println( "El total de pedidos de Abril de 2022 es de " + total + " € ");


        System.out.println("----------------------------------------------------");

        //Obtén una colección de estadísticas de los Juegos: número, media, máximo, mínimo, total. Hay que
        //usar el método de Streams summaryStatistics() que devuelve un DoubleSummaryStatistics

        List<Producto> juegosP = pedidos.stream()
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .filter(producto -> producto.getCategoria().equals(Categoria.JUEGOS))
                .toList();

        DoubleSummaryStatistics estadistica = juegosP.stream()
                .mapToDouble(Producto::getPrecio)
                .summaryStatistics();

        double min = estadistica.getMin();
        double max = estadistica.getMax();
        double media = estadistica.getAverage();
        double totalJuegos = estadistica.getSum();
        double numJuegos = estadistica.getCount();

        System.out.println("Coleccion estadista juegos: " + " numero de juegos: " + numJuegos + " min: " +
                min + " max: " + max + " media: " + media + " total: " + totalJuegos);





    }
}
