package com.pets1.app.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "veterinario")
public class VeterinarioVo {
	@Id
	@Column(name = "documento_vt", nullable=false)
	private Long documento ;

	@Column(name = "nombre_vt", nullable=false) 
	private String nombre ;

	@Column(name = "apellido_vt", nullable = false) 
	private String apellidos ;
	
	@Column(name = "sexo_vt", nullable = false)
	private String sexoVt;

	@Column(name = "telefono_vt", nullable = false) 
	private String telefono ;

	@Column(name = "correo_vt", nullable = false) 
	private String correo ;

	@Column(name = "especialidad_vt", nullable = false) 
	private String especialidad ;

	@Column(name = "password_vt", nullable = false) 
	private String password ;
	
	@Column(name = "foto_veterinario", nullable = false)
	private String imagenVete;
	
	public VeterinarioVo () {
		
	}

	public VeterinarioVo(long documento, String nombre, String apellidos, String sexoVt, String telefono, String correo,
			String especialidad, String password, String imagenVete) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexoVt = sexoVt;
		this.telefono = telefono;
		this.correo = correo;
		this.especialidad = especialidad;
		this.password = password;
		this.imagenVete = imagenVete;
	}

	public Long getDocumento() {
		return documento;
	}

	public void setDocumento(Long documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexoVt() {
		return sexoVt;
	}

	public void setSexoVt(String sexoVt) {
		this.sexoVt = sexoVt;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImagenVete() {
		return imagenVete;
	}

	public void setImagenVete(String imagenVete) {
		this.imagenVete = imagenVete;
	}

}
