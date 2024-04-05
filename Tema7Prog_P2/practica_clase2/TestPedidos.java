package Tema7Prog_P2.practica_clase2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

        Pedido ped1 = new Pedido(1L, LocalDate.now().plusDays(10), LocalDate.now().minusDays(5), Estado.ENVIADO, cliente1);
        Pedido ped2 = new Pedido(2L, LocalDate.now().plusDays(5), LocalDate.now().minusDays(4), Estado.ENVIADO, cliente2);
        Pedido ped3 = new Pedido(3L, LocalDate.now().plusDays(10), LocalDate.now().minusDays(3), Estado.ENVIADO, cliente3);

        ped1.setProducto(new HashSet<>(List.of(periferico1, periferico2, periferico3, periferico4, periferico5)));
        ped2.setProducto(new HashSet<>(List.of(libro1, libro2, libro3, libro4, libro5)));
        ped3.setProducto(new HashSet<>(List.of(juego1, juego2, juego3, juego4, juego5)));


        ArrayList<Pedido> pedidos = new ArrayList<>(List.of(ped1, ped2, ped3));
        //STREAMS -----------------------------

        //Muestra los libros cuyo precio sea mayor de 20€
        pedidos.stream()
                .flatMap(pedido -> pedido.getProducto().stream())
                .distinct()
                .filter(producto -> producto.getCategoria().equals(Categoria.LIBROS))
                .filter(producto -> producto.getPrecio() > 20)
                .forEach(System.out::println);

        System.out.printf("----------------------------------------------------");


        //Muestra los pedidos que tengan algún pedido de "Juegos"

        pedidos.stream()
                .filter(pedido -> pedido.getProducto().stream()

                        .anyMatch(producto -> producto.getCategoria().equals(Categoria.JUEGOS))
                )
                .forEach(System.out::println);

        System.out.printf("----------------------------------------------------");

    }
}
