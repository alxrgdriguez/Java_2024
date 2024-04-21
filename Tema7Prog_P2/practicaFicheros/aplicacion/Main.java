package Tema7Prog_P2.practicaFicheros.aplicacion;

import Tema7Prog_P2.practicaFicheros.io.DAOFinca;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DAOFinca probar = new DAOFinca();

        System.out.println(probar.findById(9));
        System.out.println(probar.findByName("ss"));
    }
}
