package com.pets1.app.dto.entityData;

import javax.validation.constraints.NotEmpty;

public class UsuarioDto {
	
	private Long documentoUs;
	
	@NotEmpty
	private String nombreUs;
	
	@NotEmpty
	private String apellidoUs;
	
	@NotEmpty
	private String sexoUs;
	
	@NotEmpty
	private String telefonoUs;
	
	@NotEmpty
	private String correoUs;
	
	@NotEmpty
	private String passwordUs;
	
	@NotEmpty
	private String imagenUsu;
	
	private Long rolUs;

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

}
