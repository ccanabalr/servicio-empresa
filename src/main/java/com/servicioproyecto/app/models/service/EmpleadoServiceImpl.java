package com.servicioproyecto.app.models.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicioproyecto.app.models.entity.Empleado;
import com.servicioproyecto.app.models.entity.Proyecto;
import com.servicioproyecto.app.models.repository.EmpleadoRepository;
import com.servicioproyecto.app.models.repository.ProyectoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id).orElse(null);
	}

	@Override
	public Empleado save(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public Empleado update(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);

	}

	@Override
	public List<Proyecto> findByFechaInicio(String term) {
		// TODO Auto-generated method stub
		return proyectoRepository.findByFechaIngreso(term);
	}

	@Override
	public Proyecto findProyectoById(Long id) {
		// TODO Auto-generated method stub
		return proyectoRepository.findById(id).orElse(null);
	}

}
