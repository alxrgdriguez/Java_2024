package Tema8Prog.api_Stream.aplicacion;
import Tema8Prog.api_Stream.entidades.Registro;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Alejandro Rodríguez Gallardo
 */

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

        //--------------------------------------------------------------------------------------------------------------------------------


        // a) Filtrar los registros de temperatura que sean mayores a 25 grados, la humedad sea menor a
        //70 y la fecha sea anterior a la fecha actual, y mostrarlos.

        System.out.println(" ------------ REGISTRO A ------------ ");
        registros.stream()
                .filter(registro -> registro.getTemperatura() > 25)
                .filter(registro -> registro.getHumedad() < 70)
                .filter(registro -> registro.getFechaHora().isBefore(LocalDateTime.now()))
                .forEach(System.out::println);

        System.out.println();

        // b) Encontrar el registro con la temperatura más alta y mostrar el registro completo

        System.out.println(" ------------ REGISTRO B ------------ ");
        registros.stream()
                .max(Comparator.comparing(Registro::getTemperatura))
                .ifPresent(System.out::println);

        System.out.println();

        // c) Obtener una lista con las fechas/horas de todas las tomas de datos

        System.out.println(" ------------ REGISTRO C ------------ ");
        registros.stream()
                .map(Registro::getFechaHora)
                .forEach(System.out::println);

        System.out.println();

        // d) Incrementar en 5 unidades la humedad de todos los registros y mostrar las temperaturas,
        //humedades y fechas/horas actualizadas

        System.out.println(" ------------ REGISTRO D ------------ ");
        registros.stream()
                .peek(registro -> registro.setHumedad(registro.getHumedad() + 5)) //peek para modificar y seguir trabajando con el mismo stream
                .forEach(System.out::println);

        System.out.println();

        // e) Encontrar el registro con la temperatura más baja que tenga una humedad mayor a 80 y
        //mostrar la temperatura, humedad y fecha

        System.out.println(" ------------ REGISTRO E ------------ ");
        registros.stream()
                .filter(registro -> registro.getHumedad() > 80)   //Primero filtrar para quitar las que no culplan
                .min(Comparator.comparing(Registro::getTemperatura))
                .ifPresent(System.out::println);

        System.out.println();

        // f) Verificar si algún registro tiene una temperatura mayor a 30 grados, humedad mayor a 90 y
        //la fecha es de hoy. Mostrar un mensaje indicando si hay algún registro que cumple esta
        //condición o no

        System.out.println(" ------------ REGISTRO F ------------ ");
        boolean existeRegistros = registros.stream()
                //boolean anyMatch(Predicate<? super T> predicate) donde T es el tipo de entrada al predicado
                /**
                 * Donde, T es el tipo de entrada al predicado
                 * y la función devuelve verdadero si algún elemento de
                 * la secuencia coincide con el predicado proporcionado;
                 * de lo contrario, es falso.
                 */

                .anyMatch(registro -> registro.getTemperatura() > 30 && registro.getHumedad() > 90
                        && registro.getFechaHora().equals(LocalDateTime.now()));

                if (existeRegistros) {
                    System.out.println("Se encontraron registros que cumplen con la condición.");
                } else {
                    System.out.println("No se encontraron registros que cumplen con la condicion.");
                }

        System.out.println();

        // g. Muestra 10 registros saltándote los 5 primeros.

        System.out.println(" ------------ REGISTRO G ------------ ");
        registros.stream()
                .skip(5)  //Para saltar los 5 primeros registros
                .limit(10) //Limitar los registros generados a 10
                .forEach(System.out::println);

        System.out.println();

        // h) Muestra los registros ordenados por fecha (sorted(Comparator))

        System.out.println(" ------------ REGISTRO H ------------ ");
        registros.stream()
                .sorted(Comparator.comparing(Registro::getFechaHora))
                .forEach(System.out::println);


        // i) Cuenta los registros que tengan temperatura mayor a 35 grados (count())

        Long registroT = registros.stream()
                .filter(registro -> registro.getTemperatura() > 35)
                .count();


        // j) Calcular la temperatura promedio de todos los registros (transformarlo en Stream<Double>
        //y llamar a average())

        Double temperaturaPromedio = registros.stream()
                .mapToDouble(Registro::getTemperatura)
                .average()
                .getAsDouble();





    }





}
