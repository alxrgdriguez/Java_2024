package usodefechas;

import java.time.LocalTime;

public class EjemploLocalTime {

    public static void main(String[] args) {

        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.of(20, 17, 1);
        LocalTime lt3 = LocalTime.parse("20:17:20");

        System.out.println(lt3);
        System.out.println(lt1.getHour());
        System.out.println(lt1.getMinute());
        System.out.println(lt1.getSecond());

        System.out.println(lt1.isAfter(lt3));
        System.out.println(lt1.isBefore(lt3));

        System.out.println(lt1.minusHours(4).plusSeconds(4).withMinute(4));
        System.out.println(lt1.getNano());


    }

}
