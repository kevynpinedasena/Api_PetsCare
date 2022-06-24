package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.ClinicaVo;

public interface IClinicaService {

	ClinicaVo guardar(ClinicaVo clinicaVo);
	
	List<ClinicaVo> listaClinica();
	
	Optional<ClinicaVo> buscarId(Long nit);
	
	void eliminarClinica(Long nit);
	
	List<ClinicaVo> clinicaNombre(String nombre);
}
