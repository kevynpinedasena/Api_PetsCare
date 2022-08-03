package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "historial_agendas")
public class HistorialAgendaVo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_historial")
	private Long codigoH;

	@Column(name = "fecha_historial", nullable = false)
	private String fecha;
	
	@Column(name = "hora_historial", nullable = false)
	private String hora;
	
	@Column(name = "documento_usuario", nullable = false)
	private Long documentoUsu;
	
	@Column(name = "documento_veterinario", nullable = false)
	private Long documentoVete;

	public HistorialAgendaVo() {
		
	}

	public HistorialAgendaVo(Long codigoH, String fecha, String hora, Long documentoUsu,
			Long documentoVete) {
		super();
		this.codigoH = codigoH;
		this.fecha = fecha;
		this.hora = hora;
		this.documentoUsu = documentoUsu;
		this.documentoVete = documentoVete;
	}

	public Long getCodigoH() {
		return codigoH;
	}

	public void setCodigoH(Long codigoH) {
		this.codigoH = codigoH;
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

	public Long getDocumentoUsu() {
		return documentoUsu;
	}

	public void setDocumentoUsu(Long documentoUsu) {
		this.documentoUsu = documentoUsu;
	}

	public Long getDocumentoVete() {
		return documentoVete;
	}

	public void setDocumentoVete(Long documentoVete) {
		this.documentoVete = documentoVete;
	}
}