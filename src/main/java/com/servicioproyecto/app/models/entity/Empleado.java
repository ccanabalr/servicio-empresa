package com.servicioproyecto.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9032435696090528565L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String nombre;
	private String apellido;
	private Double salario;
	private Date fechaIngreso;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id")
	private List<EmpleadoProyecto> empleadoProyectos;


}
