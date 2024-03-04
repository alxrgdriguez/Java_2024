package usodefechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class EjemploLocalDateTime {

    public static void main(String[] args) {

        LocalDateTime ldt1 = LocalDateTime.of(2024, 02, 5, 21, 30);
        LocalDateTime ldt2 = LocalDateTime.now();
        LocalDateTime ldt3 = LocalDateTime.parse("2024-02-05T21:00:05"); //yyyy-MM-ddTHH:mm:ss

        System.out.println(ldt3);

        System.out.println(ldt1.with(LocalTime.now()));
        System.out.println(ldt2.getDayOfMonth());
        System.out.println(ldt2.getHour());
        System.out.println(ldt3.minusDays(1).plusSeconds(4).withMinute(3).plusYears(2));

        System.out.println(ldt1.isAfter(ldt2));
        System.out.println(ldt1.isBefore(ldt2));

        LocalDate ld1 = LocalDate.now();
        LocalTime lt1 = LocalTime.now();
        System.out.println(ld1.atTime(lt1));
        System.out.println(lt1.atDate(ld1));





    }
}
