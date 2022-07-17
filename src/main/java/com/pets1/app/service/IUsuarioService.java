package com.pets1.app.service;


import java.util.List;

import com.pets1.app.dto.answers.UsuarioAnswerDto;
import com.pets1.app.dto.entityData.UsuarioDto;

public interface IUsuarioService {

	UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
	
//	List<UsuarioDto> obtenerTodosLosUsuarios();
	
	List<UsuarioAnswerDto> obtenerTodosLosUsuarios();
	
	UsuarioDto buscarUsuarioPorDocumento(Long documento);
	
	UsuarioAnswerDto buscarUsuarioConMascotas(Long documento);
	
	UsuarioDto actualizarUsuario(UsuarioDto usuarioDto, Long documento);
	
	void eliminarUsuario(Long documento);

}
