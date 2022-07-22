package com.pets1.app.dto.entityData;

import javax.validation.constraints.NotEmpty;

public class clinicaDto {
	
	private Long nit;
	
	@NotEmpty(message = "el nombre no puede ser nulo ni vacio")
	private String nombre;
	
	@NotEmpty(message = "la direccion no puede ser nula ni vacia")
	private String direccion;
	
	@NotEmpty(message = "el correo no puede ser nulo ni vacio")
	private String correoCv;
	
	@NotEmpty
	private String horario_atencion;
	
	@NotEmpty
	private String dias_atencion;
	
	@NotEmpty(message = "la contraseña no puede ser nula ni vacia")
	private String password;
	
	private String imagenclinica;
	

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagenclinica() {
		return imagenclinica;
	}

	public void setImagenclinica(String imagenclinica) {
		this.imagenclinica = imagenclinica;
	}
		
}
