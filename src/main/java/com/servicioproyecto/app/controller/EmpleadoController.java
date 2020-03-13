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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.servicioproyecto.app.models.entity.Empleado;
import com.servicioproyecto.app.models.entity.Proyecto;
import com.servicioproyecto.app.models.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	
	@GetMapping("/empleados")
	public List<Empleado> findAll(){
		return empleadoService.findAll();
	}
	
	@GetMapping("/empleados/{id}")
	public Empleado findById(@PathVariable Long id) {
		return empleadoService.findById(id);
	}
	
	
	@PostMapping("/empleados")
	public Empleado save(@RequestBody Empleado empleado) {
		return empleadoService.save(empleado);
	}
	
	@PutMapping("/empleados")
	public ResponseEntity<?> update(@RequestBody Empleado empleado) {
		Empleado empleadoActual = empleadoService.findById(empleado.getId());
		Empleado empleadoNuevo = null;
		
		Map<String, Object> respuesta = new HashMap<String, Object>();
		
		if(empleadoActual == null) {
			respuesta.put("mensaje", "Error: no se puedo editar, el Empleado ID: "
					.concat(empleado.getId().toString()).concat(" NO existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.NOT_FOUND);
		}
		
		
		try {
			empleadoActual.setNombre(empleado.getNombre());
			empleadoActual.setApellido(empleado.getApellido());
			empleadoActual.setSalario(empleado.getSalario());
			empleadoActual.setFechaIngreso(empleado.getFechaIngreso());
			
			empleadoNuevo = empleadoService.update(empleadoActual);
			
		} catch (DataAccessException e) {
			respuesta.put("mensaje", "Error al actualizar el cliente en la base de datos!");
			respuesta.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		respuesta.put("mensaje", "Empleado actualizado con exito!");
		respuesta.put("empleado", empleadoNuevo);
		return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.CREATED);
	
	}
	
	@DeleteMapping("/empleados/{id}")
	public void deleteById(@PathVariable Long id) {
		empleadoService.deleteById(id);
	}
	
	@GetMapping("empleados/cargar-proyectos/{term}")
	public  List<Proyecto> cargarProyectos(@PathVariable String term){
		return empleadoService.findByFechaInicio(term);
	}
	
	@GetMapping("empleados/buscar-proyecto/{id}")
	public Proyecto findProyectoById(@PathVariable Long id) {
		return empleadoService.findProyectoById(id);
	}
	
}
