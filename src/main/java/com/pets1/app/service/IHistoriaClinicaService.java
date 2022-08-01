package com.pets1.app.service;

import java.util.List;

import com.pets1.app.dto.answers.HistoriaClinicaAnswerDto;
import com.pets1.app.dto.entityData.HistoriaClinicaDto;

public interface IHistoriaClinicaService {

	HistoriaClinicaDto guardarHistoria(Long codigoMascota, HistoriaClinicaDto historiaClinica);
	
//	List<HistoriaClinicaDto> historiaClinicaDeMascota(Long codigoMascota)

	List<HistoriaClinicaAnswerDto> historiaClinicaDeMascota(Long codigoMascota);
	
	HistoriaClinicaDto buscarHistoriaClnicaMascotaId(Long codigoMascota, Long codigoHistoria);
	
	HistoriaClinicaDto actualizarHistoriaClinica(Long codigoMascota, Long codigoHistoria, HistoriaClinicaDto historiaClinica);
	
	void eliminarHistoriaClinica(Long codigoMascota, Long codigoHistoria);
}
