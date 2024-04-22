package com.jaroso.appbd;

import com.jaroso.appbd.entities.Empleado;
import com.jaroso.appbd.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppbdApplication implements CommandLineRunner {

    @Autowired
    EmpleadoRepository empleadoRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppbdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Empleado emp1 = new Empleado();
        emp1.setNombre("Jose");
        emp1.setApellidos("Jaroso");
        emp1.setEdad(25);
        emp1.setEmail("jose@gmail.com");

        empleadoRepository.save(emp1);
    }
}
