package com.servicioproyecto.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servicioproyecto.app.models.entity.Proyecto;

import com.servicioproyecto.app.models.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return proyectoRepository.findAll();
	}

	@Override
	public Proyecto findById(Long id) {
		// TODO Auto-generated method stub
		return proyectoRepository.findById(id).orElse(null);
	}

	@Override
	public Proyecto save(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyectoRepository.save(proyecto);
	}

	@Override
	public Proyecto update(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return proyectoRepository.save(proyecto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		proyectoRepository.deleteById(id);
	}

}
