package Tema7Prog_P2.Clase_Ficheros1.servicios;

import Tema7Prog_P2.Clase_Ficheros1.io.DAOGamer;
import Tema7Prog_P2.Clase_Ficheros1.model.Gamer;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Integer opcion = 0;

        List<Gamer> gamers = DAOGamer.loadGamers(); //Leer el fichero y creara una lista si esta repetido los borra
        Discord discord = new Discord(gamers);
        discord.listGamers();


        do {
            System.out.println("1. Añadir jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Buscar jugador");
            System.out.println("4. Listar");
            System.out.println("5. Salir");
            System.out.println(" --------------------- ");
            System.out.print("Introduce una opcion: ");
            try {
                Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            switch (opcion){

                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    DAOGamer.saveGamers(discord.getGamers().stream().toList());
                    System.out.println("Su fichero se ha guardado correctamente");

                    break;

            }

        }while (true);



    }
}
