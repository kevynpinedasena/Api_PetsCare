package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.MascotaVo;

public interface IMascotaService {

	MascotaVo guardar(MascotaVo mascotaVo);
	
	List<MascotaVo> listaMascotas();
	
	Optional<MascotaVo> buscarId(Long codigo);
	
	void eliminarMascota(Long codigo);
}
