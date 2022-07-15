package com.pets1.app.service;

import java.util.List;

import com.pets1.app.dto.entityData.VeterinarioDto;

public interface IVeterinarioService {

	VeterinarioDto guardarVeterinarios(Long nitClinica, VeterinarioDto veterinarioDto);
	
	List<VeterinarioDto> listaDeVeterinariosPorClinica(Long nitClinica);
	
	VeterinarioDto buscarVeterinarioId(Long documentoVeterinario);
	
	VeterinarioDto actualizarVeterinario(Long documentoVeterinario, VeterinarioDto veterinarioDto);
	
	void eliminarVeterinario(Long documentoVeterinario);
}
