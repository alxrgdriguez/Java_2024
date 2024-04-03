package Tema7Prog_P2.practica_clase;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Introduce 12 películas y los directores de esas películas.

        //Creamos Generos
        Genero g1 = new Genero("Comedy");
        Genero g2 = new Genero("Drama");
        Genero g3 = new Genero("Horror");
        Genero g4 = new Genero("Romance");
        Genero g5 = new Genero("Action");
        Genero g6 = new Genero("Thriler");

        //Creamos Directores
        Director d1 = new Director("Ridley Scott");
        Director d2 = new Director("F.F. Coppola");
        Director d3 = new Director("C. Nolan");
        Director d4 = new Director("Martin Scorsese");
        Director d5 = new Director("Quentin Tarantino");

        //Creamos Películas
        Pelicula p1 = new Pelicula("Pull Fiction,", 1990);
        Pelicula p2 = new Pelicula("Gladiator, Blade Runner", 2015);
        Pelicula p3 = new Pelicula("Reservoir Dogs", 1992);
        Pelicula p4 = new Pelicula("Gladiator", 2004);
        Pelicula p5 = new Pelicula("Blade Runner, Alien", 1994);
        Pelicula p6 = new Pelicula("Apocalypse now", 1995);
        Pelicula p7 = new Pelicula("El Padrino", 1996);
        Pelicula p8 = new Pelicula("Tenet", 1997);
        Pelicula p9 = new Pelicula("Origen", 1960);
        Pelicula p10 = new Pelicula("El lobo de Wall Street", 2000);

        //Añadir
        /*p1.setGenero(new ArrayList<Genero>(List.of(g2,g5,g6)));
        p2.setDirector(new ArrayList<Genero>(List.of(g2, g6)));
        p3.setDirector(new ArrayList<Genero>(List.of(g4, g1)));
        p4.setDirector(new ArrayList<Genero>(List.of(g1, g4)));
        p5.setDirector(new ArrayList<Genero>(List.of(g3, g6)));
        p6.setDirector(new ArrayList<Genero>(List.of(g2, g6)));
        p7.setDirector(new ArrayList<Genero>(List.of(g2, g5)));
        p8.setDirector(new ArrayList<Genero>(List.of(g1, g3)));
        p9.s(new ArrayList<Genero>(List.of(g4, g5, g6)));
        p10.setDirector(new ArrayList<Genero>(List.of(g2, g6)));

        p1.setDirector(new ArrayList<Director>(List.of(d2,d5)));
        p2.setDirector(new ArrayList<Director>(List.of(d2)));
        p3.setDirector(new ArrayList<Director>(List.of(d4, d1)));
        p4.setDirector(new ArrayList<Director>(List.of(d1, d4)));
        p5.setDirector(new ArrayList<Director>(List.of(d3)));*/














    }

}
