package BIBLIOTECA.App;

import BIBLIOTECA.ENTIDADES.*;
import BIBLIOTECA.SERVICIOS.Biblioteca;

import java.util.Scanner;

public class Test {

    public static void menu(){
        System.out.println("1. Prestar");
        System.out.println("2. Devolver");
        System.out.println("3. Buscar");
        System.out.println("4. Salir");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        //Autores
        Autor autor = new Autor("Josema", "Flores Gallardo", 45, "Sevilla", "La Giralda 27, 1ºI", "jose@gmail.com");
        Autor autor2 = new Autor("Arturo", "Perez Reverte", 50, "Madrid", "", "arturito@gmail.com");
        Autor autor3 = new Autor("Juan Antonio", "Sobrino", 12, "Olula del río", "La baldosa 54", "sobriniko@gmail.com");

        //Añadimos 10 libros a la biblioteca
        for (int i = 0; i < 10; i++) {
            Libro libro = new Libro("87654H" + i, "lIBRO" + i, 130, 2015);
            libro.addAutores(autor);
            biblioteca.addDocumento(libro);
        }
        //Creamos y añadimos 5 revistas a la biblioteca
        for (int i = 0; i < 5; i++) {
           Revista revista = new Revista("872329U" + i, "Revista" + i, 24, i);
           revista.addAutores(autor2);
            biblioteca.addDocumento(revista);
        }
        /**
         * Creamos los usuarios y lo añadimos a la biblioteca
         */
        Usuario usuario = new Usuario("89325412Y", "Adrian", 3, 15);
        biblioteca.addUsuario(usuario);
        Usuario usuario2 = new Usuario("33225412L", "Jose", 3, 15);
        biblioteca.addUsuario(usuario2);

        Integer opcion = 0;
        String titulo = "";
        String dni = "";
        do {
            menu();
            System.out.println("Ingrese la opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion){
                case 1:
                    System.out.println("Escribe el título del Documento: ");
                    titulo = sc.nextLine();
                    Documento documento = biblioteca.buscarDocumento(titulo);
                    if (documento != null){
                        System.out.println("Escribe el DNI del Usuario: ");
                        dni = sc.nextLine();
                        if (biblioteca.prestaDocumento(documento, dni)){
                            System.out.println("Documento prestado correctamente.");
                        } else {
                            System.out.println("Error.");
                        }
                    } else {
                        System.out.println("El documento no está en nuestra lista.");
                    }
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Hasta Pronto.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
                    break;
            }

        } while (opcion != 4);



    }
}
