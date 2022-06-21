package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.UsuarioVo;

public interface IUsuarioService {

	UsuarioVo guardar(UsuarioVo usuarioVo);
	
	List<UsuarioVo> listaUsuario();
	
	Optional<UsuarioVo> buscarId(Long documento);
	
	void eliminarUsuario(Long documento);
}
