package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.HistoriaClinicaVo;

public interface IHistoriaClinicaService {

	HistoriaClinicaVo guardar(HistoriaClinicaVo historiaCli);
	
	List<HistoriaClinicaVo> listaHistoriaCli();
	
	Optional<HistoriaClinicaVo> buscarId(Long codigo);
	
	void eliminarHistoriaCli(Long codigo);
}
