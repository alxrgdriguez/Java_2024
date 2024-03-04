package Tema5Prog.usodefechas;

import java.time.Duration;
import java.time.Instant;

public class TiempoCodigo {

    public static void main(String[] args) throws InterruptedException {

        Instant i1 = Instant.now();

        for(int i=0; i<1000; i++) {
            System.out.println("Hola");
        }

        Thread.sleep(2000);

        Instant i2 = Instant.now();

        System.out.println(Duration.between(i1,i2));
    }
}
