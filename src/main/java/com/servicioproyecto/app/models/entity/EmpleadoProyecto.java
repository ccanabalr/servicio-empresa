package com.servicioproyecto.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "empleado_proyecto")
public class EmpleadoProyecto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5547487627617773192L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "empleado_id")
//	private Empleado empleado;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proyecto_id")
	private Proyecto proyecto;
	
	

}
