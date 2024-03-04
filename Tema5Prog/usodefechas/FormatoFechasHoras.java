package usodefechas;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatoFechasHoras {

    public static void main(String[] args) {

        //DateTimeFormatter me permite crear un formato personalizado de fechas y horas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        //Tengo una fecha y la pinto en el formato personalizado
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.format(formatter));

        //Tengo una fecha como string en un formato, y la paso a fecha real
        LocalDateTime ldt2 = LocalDateTime.parse("06/03/2024 20:00:00", formatter);
        System.out.println(ldt2);


        //Te sirve para fechas, horas y fechashoras
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH.mm.ss");
        LocalTime lt = LocalTime.now();
        System.out.println(lt.format(formatter2));


        ZonedDateTime zonedDateTime = ldt2.atZone(ZoneId.of("Europe/Madrid"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.getMonth());
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("America/Argentina/Buenos_Aires")));
        System.out.println(zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo")));

    }
}
