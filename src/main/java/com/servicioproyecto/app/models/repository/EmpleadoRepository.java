package com.servicioproyecto.app.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servicioproyecto.app.models.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
