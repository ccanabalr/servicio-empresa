package com.servicioproyecto.app.models.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servicioproyecto.app.models.entity.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

	@Query("select p from Proyecto p where p.recursos Like %?1%")
	public List<Proyecto> findByFechaIngreso(String term);
}
