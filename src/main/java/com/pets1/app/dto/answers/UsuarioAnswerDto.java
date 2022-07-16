package com.pets1.app.dto.answers;

import java.util.HashSet;
import java.util.Set;

public class UsuarioAnswerDto {
	
	private Long documentoUs;
	
	private String nombreUs;
	
	private String apellidoUs;
	
	private String sexoUs;
	
	private String telefonoUs;
	
	private String correoUs;
	
	private String passwordUs;
	
	private String imagenUsu;
	
	private Long rolUs;
	
	private Set<MascotaAswerDto> mascotas= new HashSet<>();
	
	private Set<AgendaAnswerDto> agendas= new HashSet<>();

	public Long getDocumentoUs() {
		return documentoUs;
	}

	public void setDocumentoUs(Long documentoUs) {
		this.documentoUs = documentoUs;
	}

	public String getNombreUs() {
		return nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getApellidoUs() {
		return apellidoUs;
	}

	public void setApellidoUs(String apellidoUs) {
		this.apellidoUs = apellidoUs;
	}

	public String getSexoUs() {
		return sexoUs;
	}

	public void setSexoUs(String sexoUs) {
		this.sexoUs = sexoUs;
	}

	public String getTelefonoUs() {
		return telefonoUs;
	}

	public void setTelefonoUs(String telefonoUs) {
		this.telefonoUs = telefonoUs;
	}

	public String getCorreoUs() {
		return correoUs;
	}

	public void setCorreoUs(String correoUs) {
		this.correoUs = correoUs;
	}

	public String getPasswordUs() {
		return passwordUs;
	}

	public void setPasswordUs(String passwordUs) {
		this.passwordUs = passwordUs;
	}

	public String getImagenUsu() {
		return imagenUsu;
	}

	public void setImagenUsu(String imagenUsu) {
		this.imagenUsu = imagenUsu;
	}

	public Long getRolUs() {
		return rolUs;
	}

	public void setRolUs(Long rolUs) {
		this.rolUs = rolUs;
	}

	public Set<MascotaAswerDto> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<MascotaAswerDto> mascotas) {
		this.mascotas = mascotas;
	}

	public Set<AgendaAnswerDto> getAgendas() {
		return agendas;
	}

	public void setAgendas(Set<AgendaAnswerDto> agendas) {
		this.agendas = agendas;
	}
	
}
