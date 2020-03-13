package com.servicioproyecto.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.servicioproyecto.app.models.entity.Proyecto;
import com.servicioproyecto.app.models.service.ProyectoService;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/proyectos")
	public List<Proyecto> findAll(){
		return proyectoService.findAll();
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto findById(@PathVariable Long id) {
		return proyectoService.findById(id);
	}
	
	@PostMapping("/proyectos")
	public Proyecto save(@RequestBody Proyecto proyecto) {
		return proyectoService.save(proyecto);
	}
	
	@PutMapping("/proyectos")
	public ResponseEntity<?> update(@RequestBody Proyecto proyecto) {
		Proyecto proyectoActual = proyectoService.findById(proyecto.getId());
		Proyecto proyectoNuevo = null;
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		if(proyectoActual == null) {
			respuesta.put("mensaje", "Error: no se puedo editar, el proyecto ID: "
					.concat(proyecto.getId().toString()).concat(" NO existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		
		
		try {
			proyectoActual.setFechaInicio(proyecto.getFechaInicio());
			proyectoActual.setFechaEstimadaFin(proyecto.getFechaEstimadaFin());
			proyectoActual.setPresupuesto(proyecto.getPresupuesto());
			proyectoActual.setRecursos(proyecto.getRecursos());
			proyectoNuevo = proyectoService.update(proyectoActual);
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al actualizar el proyecto en la base de datos!");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "Proyecto actualizado con exito!");
		respuesta.put("empleado", proyectoNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void deleteById(@PathVariable Long id) {
		proyectoService.deleteById(id);
	}
}
