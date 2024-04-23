package com.jaroso.appbd.repositories;

import com.jaroso.appbd.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    List<Empleado> findEmpleadoByEdadBeforeAndAndEmailContaining(Integer edad, String email);

    @Modifying
    @Query ("update Empleado e set e.edad = :edad where e.id = :id")
    void updateEmpleadoByIdAndEdad(@Param(value = "id") Long id, @Param(value = "edad") Integer edad);
}
