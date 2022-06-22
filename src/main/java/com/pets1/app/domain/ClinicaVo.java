package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String diasAtencion;
	
	@Column(name = "rol_cv", nullable = false)
	private int rol;
	
	@Column(name = "foto_clinica", nullable = false)
	private String imagenClinica;
	
	@ManyToOne
	@JoinColumn(name = "documento_vt", referencedColumnName = "documento_vt")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private VeterinarioVo veterinarioCod;
	
	
	
	public ClinicaVo () {
		
	}

	public ClinicaVo(Long nit, String nombre, String direccion, String horario_atencion, String diasAtencion, int rol, String imagenClinica,
			VeterinarioVo veterinarioCod) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.horario_atencion = horario_atencion;
		this.diasAtencion = diasAtencion;
		this.rol = rol;
		this.imagenClinica = imagenClinica;
		this.veterinarioCod = veterinarioCod;
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

	public String getDiasAtencion() {
		return diasAtencion;
	}

	public void setDiasAtencion(String diasAtencion) {
		this.diasAtencion = diasAtencion;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getImagenClinica() {
		return imagenClinica;
	}

	public void setImagenClinica(String imagenClinica) {
		this.imagenClinica = imagenClinica;
	}

	public VeterinarioVo getVeterinarioCod() {
		return veterinarioCod;
	}

	public void setVeterinarioCod(VeterinarioVo veterinarioCod) {
		this.veterinarioCod = veterinarioCod;
	}

}
