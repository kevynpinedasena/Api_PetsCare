package com.pets1.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "agenda_cita")
public class AgendaVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo_agen")
	private Long codigoA;

	@Column(name = "fecha_historiaclin", nullable = false)
	private String fecha;
	
	@Column(name = "hora_agen", nullable = false)
	private String hora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_us", nullable = false)
	private UsuarioVo documentous;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_vt", nullable = false)
	private VeterinarioVo documentovt;
	
	public AgendaVo () {
		
	}

	public AgendaVo(Long codigoA, String fecha, String hora, UsuarioVo agendaus, VeterinarioVo documentovt) {
		super();
		this.codigoA = codigoA;
		this.fecha = fecha;
		this.hora = hora;
		this.documentous = agendaus;
		this.documentovt = documentovt;
	}

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

	public UsuarioVo getDocumentous() {
		return documentous;
	}

	public void setDocumentous(UsuarioVo documentous) {
		this.documentous = documentous;
	}

	public VeterinarioVo getDocumentovt() {
		return documentovt;
	}

	public void setDocumentovt(VeterinarioVo documentovt) {
		this.documentovt = documentovt;
	}
}