package com.servicioproyecto.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "proyectos")
public class Proyecto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3867389277749520835L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	@Column(name = "fecha_estimada_fin")
	private Date fechaEstimadaFin;
	private Double presupuesto;
	private String recursos;

//	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "proyecto_id")
//	private List<EmpleadoProyecto> empleadoProyectos;

}
