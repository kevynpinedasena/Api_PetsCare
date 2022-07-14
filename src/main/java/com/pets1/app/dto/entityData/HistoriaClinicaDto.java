package com.pets1.app.dto.entityData;

import javax.validation.constraints.NotEmpty;

public class HistoriaClinicaDto {
	
	private Long codigo;
	
	@NotEmpty
	private String fecha;
	
	@NotEmpty
	private String motivoConsulta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	
}
