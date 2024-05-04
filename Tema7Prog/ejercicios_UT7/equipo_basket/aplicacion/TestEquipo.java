package Tema7Prog.ejercicios_UT7.equipo_basket.aplicacion;

import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.EquipoBasket;
import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.JugadorBasket;
import Tema7Prog.ejercicios_UT7.equipo_basket.entidades.NBALeague;
import Tema7Prog.ejercicios_UT7.equipo_basket.enums.Posicion;

public class TestEquipo {

    public static void main(String[] args) {
        JugadorBasket j1 = new JugadorBasket("J1", 150.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,1);
        JugadorBasket j2 = new JugadorBasket("J2", 160.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,1);
        JugadorBasket j3 = new JugadorBasket("J3", 200.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,1);
        JugadorBasket j4 = new JugadorBasket("J4", 180.0, Posicion.PIVOT, 1.0, 1.0, 1.0, 1.0, 1.0 ,1);

        EquipoBasket e1 = new EquipoBasket("Equipo 1",  1.0, 2.0);
        EquipoBasket e2 = new EquipoBasket("Equipo 2",  1.0, 2.0);

        e1.addJugador(j1);
        e1.addJugador(j2);

        e2.addJugador(j3);
        e2.addJugador(j4);

        NBALeague nba = new NBALeague();

        nba.agregarEquipo(e1);
        nba.agregarEquipo(e2);

        System.out.println(nba.buscarMasAlto());

    }
}
