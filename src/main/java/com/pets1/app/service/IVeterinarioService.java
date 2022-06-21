package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.VeterinarioVo;

public interface IVeterinarioService {

	VeterinarioVo guardar(VeterinarioVo veterinarioVo);
	
	List<VeterinarioVo> listaVeterinarios();
	
	Optional<VeterinarioVo> buscarId(Long documento);
	
	void eliminarVeterinario(Long documento);
}
