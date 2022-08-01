package com.pets1.app.dto.answers;

import com.pets1.app.dto.entityData.UsuarioDto;

public class AgendaVeterinarioAnswerDto {
	
private Long codigoA;
	
	private String fecha;
	
	private String hora;
	
	private UsuarioDto documentous;

	public Long getCodigoA() {
		return codigoA;
	}

	public void setCodigoA(Long codigoA) {
		this.codigoA = codigoA;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public UsuarioDto getDocumentous() {
		return documentous;
	}

	public void setDocumentous(UsuarioDto documentous) {
		this.documentous = documentous;
	}

}
