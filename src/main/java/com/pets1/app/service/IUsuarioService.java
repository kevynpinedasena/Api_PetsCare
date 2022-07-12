package com.pets1.app.service;


import java.util.List;

import com.pets1.app.service.dto.entityData.UsuarioDto;

public interface IUsuarioService {

	UsuarioDto guardarUsuario(UsuarioDto usuarioDto);
	
	List<UsuarioDto> obtenerTodosLosUsuarios();
	
	UsuarioDto buscarUsuarioPorDocumento(Long documento);
	
	UsuarioDto actualizarUsuario(UsuarioDto usuarioDto, Long documento);
	
	void eliminarUsuario(Long documento);

}
