package usodefechas;

import java.time.LocalDate;

public class EjemploLocalDate {

    public static void main(String[] args) {

        LocalDate f1 = LocalDate.of(2024, 2, 5);
        LocalDate f2 = LocalDate.now(); //Fecha de hoy
        LocalDate f3 = LocalDate.parse("2024-02-08"); //yyyy-MM-dd

        System.out.println(f1);
        System.out.println(f1.getDayOfYear());
        System.out.println(f1.getDayOfWeek());
        System.out.println(f1.getDayOfMonth());
        System.out.println(f1.getMonthValue());
        System.out.println(f1.getMonth());
        System.out.println(f1.getYear());

        //Comparación
        System.out.println(f1.isAfter(f3)); //Posterior
        System.out.println(f1.isBefore(f3)); //Anterior

        System.out.println(f1.minusDays(10));
        System.out.println(f1.minusYears(20).getDayOfWeek());
        System.out.println(f1.plusDays(25));

        System.out.println(f1.withMonth(5).minusDays(2).plusYears(1));
        System.out.println(f1.withYear(2025));



    }
}
