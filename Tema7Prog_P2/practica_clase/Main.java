package Tema7Prog_P2.practica_clase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Genero g1 = new Genero("Scifi");
        Genero g2 = new Genero("Drama");
        Genero g3 = new Genero("Comedia");
        Genero g4 = new Genero("Histórico");
        Genero g5 = new Genero("Thriller");
        Genero g6 = new Genero("Mafia");

        Director d1 = new Director("Ridley Scott");
        Director d2 = new Director("F.F. Coppola");
        Director d3 = new Director("C. Nolan");
        Director d4 = new Director("Martin Scorsese");
        Director d5 = new Director("Quentin Tarantino");

        Pelicula pel1 = new Pelicula("Pull Fiction", 1999);
        Pelicula pel2 = new Pelicula("Reservoir Dogs", 1991);
        Pelicula pel3 = new Pelicula("Gladiator", 2000);
        Pelicula pel4 = new Pelicula("Blade Runner", 1990);
        Pelicula pel5 = new Pelicula("Alien, el octavo pasajero", 1985);
        Pelicula pel6 = new Pelicula("Apocalypse now", 1979);
        Pelicula pel7 = new Pelicula("El Padrino", 1977);
        Pelicula pel8 = new Pelicula("Tenet", 2018);
        Pelicula pel9 = new Pelicula("Casino", 2005);
        Pelicula pel10 = new Pelicula("El lobo de Wall Street", 2012);

        pel1.setGeneros(new ArrayList<Genero>(List.of(g2,g5,g6)));
        pel2.setGeneros(new ArrayList<Genero>(List.of(g2,g6)));
        pel3.setGeneros(new ArrayList<Genero>(List.of(g2,g4)));
        pel4.setGeneros(new ArrayList<Genero>(List.of(g1,g2)));
        pel5.setGeneros(new ArrayList<Genero>(List.of(g1,g2)));
        pel6.setGeneros(new ArrayList<Genero>(List.of(g2,g4)));
        pel7.setGeneros(new ArrayList<Genero>(List.of(g2,g6)));
        pel8.setGeneros(new ArrayList<Genero>(List.of(g1,g2)));
        pel9.setGeneros(new ArrayList<Genero>(List.of(g2,g5,g6)));
        pel10.setGeneros(new ArrayList<Genero>(List.of(g2,g3)));

        pel1.setDirectores(new ArrayList<Director>(List.of(d1,d2,d5)));
        pel2.setDirectores(new ArrayList<Director>(List.of(d3)));
        pel3.setDirectores(new ArrayList<Director>(List.of(d4)));
        pel4.setDirectores(new ArrayList<Director>(List.of(d3, d5)));
        pel5.setDirectores(new ArrayList<Director>(List.of(d4, d5)));
        pel6.setDirectores(new ArrayList<Director>(List.of(d2,d4)));
        pel7.setDirectores(new ArrayList<Director>(List.of(d1)));
        pel8.setDirectores(new ArrayList<Director>(List.of(d2)));
        pel9.setDirectores(new ArrayList<Director>(List.of(d1,d5)));
        pel10.setDirectores(new ArrayList<Director>(List.of(d2,d3)));

        //STREAMS ----------------------------------------------------------
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pel1);
        peliculas.add(pel2);
        peliculas.add(pel3);
        peliculas.add(pel4);
        peliculas.add(pel5);
        peliculas.add(pel6);
        peliculas.add(pel7);
        peliculas.add(pel8);
        peliculas.add(pel9);
        peliculas.add(pel10);

        //----------------------------------------------------------

        //pelisOrdenadasPorAño(): muestra todas las películas ordenadas por año
        peliculas.stream()
                .sorted(Comparator.comparing(Pelicula::getYear))
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        //scifi2000(): muestra las películas de ciencia ficción posteriores al año 2000
        peliculas.stream()
                .filter( pelicula -> pelicula.getYear() > 2000 )
                .filter( pelicula -> pelicula.getGeneros().stream()
                        .anyMatch( genero -> genero.getNombre().equals("Scifi")) )
                .forEach(System.out::println);


        System.out.println("-------------------------------------");

        //tituloMasLargo(): muestra la película cuyo título es más largo
        peliculas.stream()
                .max(Comparator.comparing(pelicula -> pelicula.getTitulo().length()))
                .ifPresent(System.out::println);

        // O orElse -->


        System.out.println("-------------------------------------");

        //directoresMayúsculas(): muestra los nombres de los directores ordenados y en mayúsculas.

        peliculas.stream()
                .flatMap(pelicula -> pelicula.getDirectores().stream())
                .map(Director::getNombre)
                .distinct()
                .map(String:: toUpperCase)
                .sorted()
                .forEach(System.out::println);

        System.out.println("-------------------------------------");

        //numPelis(): muestra el director y al lado el número de películas de cada director. Hay que usar
        //collect.

        /*peliculas.stream()
                .flatMap(pelicula -> pelicula.getDirectores().stream())
                .distinct()
                .forEach(director -> {

                   Long numPeliculas = peliculas.stream()

                           .filter(pelicula -> pelicula.getDirectores().stream())
                           .anyMatch(direc -> direc.getId() == director.getId())

                });*/









    }




}
