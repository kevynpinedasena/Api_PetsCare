package com.pets1.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "clinica_veterinaria")
public class ClinicaVo {
	
	@Id
	@Column(name = "nit_cv", nullable = false)
	private Long nit;
	
	@Column(name = "nombre_cv", nullable = false)
	private String nombre;
	
	@Column(name = "direccion_cv", nullable = false)
	private String direccion; 
	
	@Column(name = "horario_atencio_cv", nullable = false)
	private String horario_atencion;
	
	@Column(name = "dias_atencion", nullable = false)
	private String dias_atencion;
	
	@Column(name = "rol_cv", nullable = false)
	private long rol;
	
	@Column(name = "foto_clinica", nullable = false)
	private String imagenclinica;
	
	@JsonBackReference
	@OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VeterinarioVo> veterinarios = new HashSet<>();
	
	public ClinicaVo () {
		
	}

	public ClinicaVo(Long nit, String nombre, String direccion, String horario_atencion, String dias_atencion, long rol,
			String imagenclinica, Set<VeterinarioVo> veterinarios) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horario_atencion = horario_atencion;
		this.dias_atencion = dias_atencion;
		this.rol = rol;
		this.imagenclinica = imagenclinica;
		this.veterinarios = veterinarios;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario_atencion() {
		return horario_atencion;
	}

	public void setHorario_atencion(String horario_atencion) {
		this.horario_atencion = horario_atencion;
	}

	public String getDias_atencion() {
		return dias_atencion;
	}

	public void setDias_atencion(String dias_atencion) {
		this.dias_atencion = dias_atencion;
	}

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

	public String getImagenclinica() {
		return imagenclinica;
	}

	public void setImagenclinica(String imagenclinica) {
		this.imagenclinica = imagenclinica;
	}

	public Set<VeterinarioVo> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(Set<VeterinarioVo> veterinarios) {
		this.veterinarios = veterinarios;
	}

}
