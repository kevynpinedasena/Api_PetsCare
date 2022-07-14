package com.pets1.app.service;

import java.util.List;

import com.pets1.app.dto.entityData.MascotaDto;

public interface IMascotaService {

	MascotaDto guardarMascota(Long documento, MascotaDto mascotaDto);
	
	List<MascotaDto> obtenerMascotasDeUsuario(Long documentoUsuario);
	
	MascotaDto obtenerMascotaId(Long documentoUsuario, Long codigoMascota);
	
	MascotaDto actualizarMascota(Long documentoUsuario, Long codigoMascota, MascotaDto mascotaDto);
	
	void eliminarMascota(Long documentoUsuario, Long codigoMascota);
	
}
