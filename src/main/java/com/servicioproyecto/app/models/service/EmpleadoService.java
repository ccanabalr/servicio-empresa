package com.servicioproyecto.app.models.service;

import java.util.Date;
import java.util.List;

import com.servicioproyecto.app.models.entity.Empleado;
import com.servicioproyecto.app.models.entity.Proyecto;

public interface EmpleadoService {
	
	public List<Empleado> findAll();
	public Empleado findById(Long id);
	public Empleado save(Empleado empleado);
	public Empleado update(Empleado empleado);
	public void deleteById(Long id);
	public List<Proyecto> findByFechaInicio(String term);
	public Proyecto findProyectoById(Long id);
}
