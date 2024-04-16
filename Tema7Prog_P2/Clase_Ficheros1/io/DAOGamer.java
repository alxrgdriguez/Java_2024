package Tema7Prog_P2.Clase_Ficheros1.io;

import Tema7Prog_P2.Clase_Ficheros1.model.Gamer;
import Tema7Prog_P2.Clase_Ficheros1.model.Nivel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class DAOGamer {

    public static List<Gamer> loadGamers() throws IOException {

        Path fileGamers= Paths.get("Tema7Prog_P2", "Clase_Ficheros1", "recursos", "gamers.csv");
        BufferedReader br = Files.newBufferedReader(fileGamers );

        return  br.lines()
                .map(line -> {
                    String[] cad = line.split(",");
                    return new Gamer(Long.parseLong(cad[0]), cad[1], cad[2], cad[3], Nivel.valueOf(cad[4]));
                })
                .toList();
    }

    public static void saveGamers(List<Gamer> gamers) throws IOException {

        //Abrir el archivo gamers.csv

        Path file = Paths.get("Tema7Prog_P2", "Clase_Ficheros1", "recursos", "gamers.csv");
        BufferedWriter bw = Files.newBufferedWriter(file,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);

        //For each
        for(Gamer gamer : gamers){
            StringBuffer sb = new StringBuffer();
            sb.append(gamer.getId()).append(" , ");
            sb.append(gamer.getNick()).append(" , ");
            sb.append(gamer.getEmail()).append(" , ");
            sb.append(gamer.getJuego()).append(" , ");
            sb.append(gamer.getNivel()).append(" , ");
        }





    }
}
