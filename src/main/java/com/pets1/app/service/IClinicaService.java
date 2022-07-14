package com.pets1.app.service;

import java.util.List;

import com.pets1.app.dto.entityData.clinicaDto;

public interface IClinicaService {

	clinicaDto crearClinica(clinicaDto clinicaDto);
	
	List<clinicaDto> consultarListaDeClinicas();
	
	clinicaDto consultarClinicaPorId(Long nitClinica);
	
	clinicaDto actualizarClinica(Long nitClinica, clinicaDto clinicaDto);
	
	void eliminarClinica(Long nitClinica);
}
