package com.pets1.app.dto.answers;

public class AgendaAnswerDto {
	
	private Long codigoA;
	
	private String fecha;
	
	private String hora;
	
	private UsuarioAnswerDto documentous;
	
	private VeterinarioAnswerDto documentovt;

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

	public UsuarioAnswerDto getDocumentous() {
		return documentous;
	}

	public void setDocumentous(UsuarioAnswerDto documentous) {
		this.documentous = documentous;
	}

	public VeterinarioAnswerDto getDocumentovt() {
		return documentovt;
	}

	public void setDocumentovt(VeterinarioAnswerDto documentovt) {
		this.documentovt = documentovt;
	}
	
}
