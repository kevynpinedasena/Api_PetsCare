package com.pets1.app.dto.answers;

import java.util.HashSet;
import java.util.Set;

import com.pets1.app.dto.entityData.VeterinarioDto;

public class ClinicaAnswerDto {
	
	private Long nit;
	
	private String nombre;
	
	private String direccion; 
	
	private String correo_cv;
	
	private String horario_atencion;
	
	private String dias_atencion;
	
	private String contrasena;
	
	private String imagenclinica;
	
	private Set<VeterinarioDto> veterinarios = new HashSet<>();

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

	public String getCorreo_cv() {
		return correo_cv;
	}

	public void setCorreo_cv(String correo_cv) {
		this.correo_cv = correo_cv;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getImagenclinica() {
		return imagenclinica;
	}

	public void setImagenclinica(String imagenclinica) {
		this.imagenclinica = imagenclinica;
	}

	public Set<VeterinarioDto> getVeterinarios() {
		return veterinarios;
	}

	public void setVeterinarios(Set<VeterinarioDto> veterinarios) {
		this.veterinarios = veterinarios;
	}
	
}
