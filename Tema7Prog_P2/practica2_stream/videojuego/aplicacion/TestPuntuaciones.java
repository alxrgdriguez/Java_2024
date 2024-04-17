package Tema7Prog_P2.practica2_stream.videojuego.aplicacion;

import Tema4Prog.Ejemplos_BasicosPOO.Jugador;
import Tema7Prog_P2.practica2_stream.videojuego.entidades.Juego;
import Tema7Prog_P2.practica2_stream.videojuego.entidades.Stim;
import Tema7Prog_P2.practica2_stream.videojuego.entidades.Usuario;
import Tema7Prog_P2.practica2_stream.videojuego.enums.Plataforma;

import java.util.Comparator;
import java.util.List;

public class TestPuntuaciones {

    public static void main(String[] args) {

        // ---- JUEGOS -----
        Juego j1 = new Juego("Fortnite", Plataforma.PC);
        Juego j2 = new Juego("Overwatch", Plataforma.PLAYSTATION);
        Juego j3 = new Juego("PUBG", Plataforma.MOVIL);
        Juego j4 = new Juego("CSGO", Plataforma.PC);
        Juego j5 = new Juego("Call of duty", Plataforma.PLAYSTATION);
        Juego j6 = new Juego("Minecraft", Plataforma.PC);
        Juego j7 = new Juego("World of Warcraft", Plataforma.PC);
        Juego j8 = new Juego("Resident Evil 4", Plataforma.PLAYSTATION);
        Juego j9 = new Juego("Clash Royale", Plataforma.MOVIL);
        Juego j10 = new Juego("Pokemon Go", Plataforma.MOVIL);

        // ---- USUARIOS -----
        Usuario usu1 = new Usuario("Alejandro","alexred@gmail.com", "Alexred99");
        Usuario usu2 = new Usuario("Pepito","pepito@gmail.com", "Pepito69");
        Usuario usu3 = new Usuario("Manolito","manolitol@gmail.com", "ManolitoXD");
        Usuario usu4 = new Usuario("Antonio","antonio@gmail.com", "AntonioElMejor");
        Usuario usu5 = new Usuario("Laura","laura@gmail.com", "LauraGamer");
        Usuario usu6 = new Usuario("Mario","mario@gmail.com", "marioBr0s");
        Usuario usu7 = new Usuario("Robert","robert@gmail.com", "Topeto14");
        Usuario usu8 = new Usuario("Gabriel","comparitiko@gmail.com", "Comparitiko");
        Usuario usu9 = new Usuario("Adrian","norteño@gmail.com", "Norteño");
        Usuario usu10 = new Usuario("Sobrino","sobrino@gmail.com", "fuckingAmo");

        // ----- AÑADIR A LOS USUARIOS AL MENOS 5 PUNTUACIONES -----

        //Puntuaciones usu1
        usu1.addPuntuacion(j1.getId(), true, 20);
        usu1.addPuntuacion(j10.getId(), true, 10);
        usu1.addPuntuacion(j9.getId(), false, -32);
        usu1.addPuntuacion(j7.getId(), true, 15);
        usu1.addPuntuacion(j6.getId(), true, 100);

        //Puntuaciones usu2
        usu2.addPuntuacion(j2.getId(), false, 3);
        usu2.addPuntuacion(j8.getId(), false, 0);
        usu2.addPuntuacion(j10.getId(), true, 12);
        usu2.addPuntuacion(j7.getId(), false, 3);
        usu2.addPuntuacion(j5.getId(), true, 45);

        //Puntuaciones usu3
        usu3.addPuntuacion(j3.getId(), true, 62);
        usu3.addPuntuacion(j2.getId(), true, 40);
        usu3.addPuntuacion(j1.getId(), true, 22);
        usu3.addPuntuacion(j5.getId(), true, 35);
        usu3.addPuntuacion(j4.getId(), false, -40);

        //Puntuaciones usu4
        usu4.addPuntuacion(j4.getId(), false, -14);
        usu4.addPuntuacion(j1.getId(), false, -5);
        usu4.addPuntuacion(j2.getId(), true, 34);
        usu4.addPuntuacion(j7.getId(), true, 22);
        usu4.addPuntuacion(j10.getId(), true, 50);

        //Puntuaciones usu5
        usu5.addPuntuacion(j5.getId(), false, -40);
        usu5.addPuntuacion(j8.getId(), true, 40);
        usu5.addPuntuacion(j6.getId(), false, -30);
        usu5.addPuntuacion(j9.getId(), true, 22);
        usu5.addPuntuacion(j7.getId(), false, 20);

        //Puntuaciones usu6
        usu6.addPuntuacion(j6.getId(), true, 40);
        usu6.addPuntuacion(j8.getId(), false, -10);
        usu6.addPuntuacion(j1.getId(), true, 20);
        usu6.addPuntuacion(j2.getId(), true, 22);
        usu6.addPuntuacion(j7.getId(), false, -5);


        //Puntuaciones usu7
        usu7.addPuntuacion(j7.getId(), true, 40);
        usu7.addPuntuacion(j8.getId(), true, 40);
        usu7.addPuntuacion(j5.getId(), false, -30);
        usu7.addPuntuacion(j9.getId(), true, 40);
        usu7.addPuntuacion(j7.getId(), false, -20);


        //Puntuaciones usu8
        usu8.addPuntuacion(j8.getId(), true, 50);
        usu8.addPuntuacion(j10.getId(), true, 65);
        usu8.addPuntuacion(j6.getId(), false, -34);
        usu8.addPuntuacion(j9.getId(), true, 48);
        usu8.addPuntuacion(j7.getId(), false, -20);


        //Puntuaciones usu9
        usu9.addPuntuacion(j9.getId(), true, 40);
        usu9.addPuntuacion(j8.getId(), true, 45);
        usu9.addPuntuacion(j6.getId(), false, -30);
        usu9.addPuntuacion(j9.getId(), true, 40);
        usu9.addPuntuacion(j1.getId(), true, 20);


        //Puntuaciones usu10
        usu10.addPuntuacion(j10.getId(), true, 40);
        usu10.addPuntuacion(j1.getId(), true, 40);
        usu10.addPuntuacion(j6.getId(), false, -32);
        usu10.addPuntuacion(j3.getId(), true, 48);
        usu10.addPuntuacion(j7.getId(), false, -20);


        // -------- STREAMS --------

        Stim steam = new Stim();
        steam.getJuegos().addAll(List.of(j1,j2,j3,j3,j4,j5,j6,j7,j8,j9,j10));
        steam.getJugadores().addAll(List.of(usu1, usu2, usu3, usu4, usu5, usu6, usu7, usu8, usu9, usu10));

        //Muestra por pantalla todos los usuarios ordenados por Nick, muestra email y Nick

        steam.getJugadores().stream()
                .sorted(Comparator.comparing(Usuario::getNick))
                .forEach(System.out::println);

        System.out.println("----------------------------------------");

        //Método que muestre cada usuario (Nick) y para cada uno la puntuación de los juegos a los
        //que juega.

       steam.getJugadores().stream()

                .forEach(j -> {
                    System.out.println("\n");
                    System.out.println("Nick -> " + j.getNick());
                    steam.getJuegos().stream()
                            .filter(juego -> j.getPuntuaciones().containsKey(juego.getId()))
                            .forEach(juego -> System.out.println(j.getPuntuaciones().get(juego.getId())));
                });


        System.out.println("----------------------------------------");

        //Método que reciba como parámetro un Usuario y muestre todas sus puntuaciones (puntos,
        //partidas jugadas, …) ordenadas por puntos.

        steam.getJugadores().stream()
                .filter(j -> j.getNick().equals("Alexred99"))
                .flatMap(j -> j.getPuntuaciones().values().stream())
                .sorted(Comparator.comparing(puntuacion -> puntuacion.getPuntosObtenidos()))
                .forEach(System.out::println);

        //Método que pinte el ranking de los juegos. Es decir, cada juego y debajo el ranking de los
        //jugadores que lo juegan ordenados por puntuación.

        steam.getJuegos().forEach(juego -> {
            System.out.println();
            System.out.println(juego.getNombre());

            steam.getJugadores().stream()
                    .filter(jugador -> jugador.getPuntuaciones().containsKey(juego.getId()))
                    .sorted(Comparator.comparing(jugador -> jugador.getPuntuacion(juego.getId())))
                    .forEach(jugador -> {
                        System.out.println(jugador.getNombre() + " -> " + jugador.getPuntuaciones().get(juego.getId()));
                    });
        });


    }






}
