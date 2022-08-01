package com.pets1.app.dto.answers;

import com.pets1.app.dto.entityData.VeterinarioDto;

public class AgendaUsuarioAnswerDto {
	
private Long codigoA;
	
	private String fecha;
	
	private String hora;
	
	private VeterinarioDto documentovt;

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

	public VeterinarioDto getDocumentovt() {
		return documentovt;
	}

	public void setDocumentovt(VeterinarioDto documentovt) {
		this.documentovt = documentovt;
	}
	
}
