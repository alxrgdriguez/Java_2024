package com.jaroso.appbd.repositories;

import com.jaroso.appbd.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
