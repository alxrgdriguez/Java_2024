package Tema8Prog.api_Stream.aplicacion;

import Tema8Prog.api_Stream.entidades.Registro;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {

    // --- Metodos ---
    /**
     * Generar un numero double aleatrorio entre un minimo y un maximo
     * @param min por defecto es el numero minimo
     * @param max es el numero maximo generado
     * @return un numero entre ese rango min-max
     */
    public static Double doubleAleatorio(Integer min, Integer max) {
        return Math.random() * (max - min) + min;
    }
    //---------------------------------------------------------------------

    public static void main(String[] args) {

        List<Registro> registros = new ArrayList<>();  //Creamos una lista de registros

        LocalDateTime fechaHoraInicial = LocalDateTime.now();

        //Crear un colección de 100 registros

        for (int i = 0; i < 100; i++){

            Double temperatura = doubleAleatorio(10, 50);
            Double humedad = doubleAleatorio(20, 100);

            registros.add(new Registro(fechaHoraInicial.plusMinutes(i), humedad, temperatura)); //plusMinutes --> La fecha y hora actual con un incremento de i minutos

        }

        //Pintamos el registro
        for (Registro r : registros) {
            System.out.println( "\n" + r);
        }

    }
}
