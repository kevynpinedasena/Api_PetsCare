package com.pets1.app.dto.entityData;

import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.pets1.app.domain.VeterinarioVo;

public class clinicaDto {
	
	private Long nit;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String direccion;
	
	@NotEmpty
	private String horario_atencion;
	
	@NotEmpty
	private String dias_atencion;
	
	private long rol;
	
	private String imagenclinica;
	
	private Set<VeterinarioVo> veterinarios;

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
