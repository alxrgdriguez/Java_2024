package Tema7Prog.ejercicios_UT7.equipo_basket.aplicacion;

import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.EquipoBasket;
import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.JugadorBasket;
import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.NBALeague;
import Tema7Prog.ejercicios_UT7.equipo_basket.enums.Posicion;

public class TestEquipo {

    public static void main(String[] args) {
        JugadorBasket j1 = new JugadorBasket("J1", 280.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,1);
        JugadorBasket j2 = new JugadorBasket("J2", 160.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,2);
        JugadorBasket j3 = new JugadorBasket("J3", 370.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,3);
        JugadorBasket j4 = new JugadorBasket("J4", 200.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,4);

        EquipoBasket e1 = new EquipoBasket("Equipo 1",  1.0, 2.0);
        EquipoBasket e2 = new EquipoBasket("Equipo 2",  8.0, 2.0);

        e1.addJugador(j1);
        e1.addJugador(j2);

        e2.addJugador(j3);
        e2.addJugador(j4);

        NBALeague nba = new NBALeague();

        nba.agregarEquipo(e2);
        nba.agregarEquipo(e1);

        System.out.println("----------------");
        System.out.println(e1.mostrarEquipo());
        System.out.println("----------------");
        System.out.println(e2.mostrarEquipo());
        System.out.println("-------ALTO------");
        System.out.println(nba.buscarMasAlto());
        System.out.println("----------------");
        System.out.println(nba.buscarMasPartidosGanados());
        System.out.println("----------------");
        System.out.println(e1.buscarJugador(1));
        System.out.println("----------------");
        System.out.println(e1.buscarJugador("J2"));
        System.out.println("---------------");
        nba.mostrarEquiposTreeMap();
        System.out.println("---------------");
        nba.mostrarEquiposHashMap();
        System.out.println("---------------");
        System.out.println(nba.buscarNombre("Equipo 2"));


    }
}
