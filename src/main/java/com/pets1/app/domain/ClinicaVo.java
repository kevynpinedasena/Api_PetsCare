package com.pets1.app.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
	@Column(name = "correo_cv", nullable = false)
	private String correoCv;
	
	@Column(name = "horario_atencio_cv", nullable = false)
	private String horario_atencion;
	
	@Column(name = "dias_atencion", nullable = false)
	private String dias_atencion;
	
	@Column(name = "password_cv", nullable = false)
	private String passwordCv;
	
	@Column(name = "foto_clinica", nullable = false)
	private String imagenclinica;
	
	@JsonBackReference
	@OneToMany(mappedBy = "clinica", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<VeterinarioVo> veterinarios = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "rol_clinica", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RolVo rol;
	
	public ClinicaVo () {
		
	}

	public ClinicaVo(Long nit, String nombre, String direccion, String correoCv, String horario_atencion,
			String dias_atencion, String passwordCv, String imagenclinica, Set<VeterinarioVo> veterinarios, RolVo rol) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correoCv = correoCv;
		this.horario_atencion = horario_atencion;
		this.dias_atencion = dias_atencion;
		this.passwordCv = passwordCv;
		this.imagenclinica = imagenclinica;
		this.veterinarios = veterinarios;
		this.rol = rol;
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

	public String getCorreoCv() {
		return correoCv;
	}

	public void setCorreoCv(String correoCv) {
		this.correoCv = correoCv;
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

	public String getPasswordCv() {
		return passwordCv;
	}

	public void setPasswordCv(String passwordCv) {
		this.passwordCv = passwordCv;
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

	public RolVo getRol() {
		return rol;
	}

	public void setRol(RolVo rol) {
		this.rol = rol;
	}
	
}
