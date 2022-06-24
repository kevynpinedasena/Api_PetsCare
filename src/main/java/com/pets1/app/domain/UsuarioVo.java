package com.pets1.app.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "usuarios")
public class UsuarioVo {
	
	@Id
	@Column(name = "documento_usu", nullable = false)
	private Long documentoUs;

	@Column(name = "nombre_usu", nullable = false)
	private String nombreUs;

	@Column(name = "apellido_usu", nullable = false)
	private String apellidoUs;
	
	@Column(name = "sexo_usu", nullable = false)
	private String sexoUs;

	@Column(name = "telefono_usu", nullable = false)
	private String telefonoUs;
	
	@Column(name = "correo_usu", nullable = false)
	private String correoUs;

	@Column(name = "password_usu", nullable = false)
	private String passwordUs;
	
	@Column(name = "foto_usu", nullable = false)
	private String imagenUsu;

	@Column(name = "rol_usu", nullable = false)
	private int rolUs;
	
	@Transient
	private List<MascotaVo> listaMascotas;
	
	public UsuarioVo() {
		
	}

	public UsuarioVo(Long documentoUs, String nombreUs, String apellidoUs, String sexoUs, String telefonoUs, String correoUs,
			String passwordUs, String imagenUsu, int rolUs) {
		super();
		this.documentoUs = documentoUs;
		this.nombreUs = nombreUs;
		this.apellidoUs = apellidoUs;
		this.telefonoUs = telefonoUs;
		this.sexoUs = sexoUs;
		this.correoUs = correoUs;
		this.passwordUs = passwordUs;
		this.imagenUsu = imagenUsu;
		this.rolUs = rolUs;
	}

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

	public int getRolUs() {
		return rolUs;
	}

	public void setRolUs(int rolUs) {
		this.rolUs = rolUs;
	}

	public List<MascotaVo> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<MascotaVo> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
}
