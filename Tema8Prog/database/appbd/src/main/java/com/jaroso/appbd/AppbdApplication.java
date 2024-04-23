package com.jaroso.appbd;

import com.jaroso.appbd.entities.Empleado;
import com.jaroso.appbd.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootApplication
public class AppbdApplication implements CommandLineRunner {

    @Autowired
    EmpleadoRepository empleadoRepository;
    public static void main(String[] args) {
        SpringApplication.run(AppbdApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        empleadoRepository.deleteAll();
        Empleado emp1 = new Empleado("Pepito", "Gonzalez", 33, "pepito@gmail.com");
        Empleado emp2 = new Empleado("Manolito", "Gonzalez", 20, "manolito@gmail.com");
        Empleado emp3 = new Empleado("Daniel", "Gallardo", 60, "juan@hotmail.com");

        emp1.setNombre("Alex");
        emp2.setApellidos("Rodriguez");

        empleadoRepository.save(emp1);
        empleadoRepository.save(emp2);
        empleadoRepository.save(emp3);

        List<Empleado> empleados =  empleadoRepository.findAll();

            empleados.stream()
                    .forEach(System.out::println);

            try {
                Empleado empleado = empleadoRepository.findById(5L)
                        .orElseThrow();
            }catch (NoSuchElementException e){
                System.out.println("No se ha encontrado el empleado");
            }

        //empleadoRepository.deleteById(15L);
        empleadoRepository.findEmpleadoByEdadBeforeAndAndEmailContaining(61, "@gmail.com").forEach(System.out::println);
        empleadoRepository.updateEmpleadoByIdAndEdad(51L, 100);


    }

}
