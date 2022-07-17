package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.dto.answers.ClinicaAnswerDto;
import com.pets1.app.dto.entityData.clinicaDto;
import com.pets1.app.exeptions.ResourseNotFoudExeption;
import com.pets1.app.repository.IClinicaRepository;
import com.pets1.app.service.IClinicaService;

@Service
@Transactional
public class ClinicaServiceImpl implements IClinicaService{
	
	@Autowired
	private IClinicaRepository clinicaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public clinicaDto crearClinica(clinicaDto clinicaDto) {
		ClinicaVo clinica = mapearEntidad(clinicaDto);
		ClinicaVo nuevaClinica = clinicaRepository.save(clinica);
		return mapearDto(nuevaClinica);
	}

	@Override
	public List<ClinicaAnswerDto> consultarListaDeClinicas() {
		List<ClinicaVo> clinicas = clinicaRepository.findAll();
		return clinicas.stream().map(clinica -> mapearAnswerDto(clinica)).collect(Collectors.toList());
	}

	@Override
	public ClinicaAnswerDto consultarClinicaPorId(Long nitClinica) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourseNotFoudExeption("clinica", "nit", nitClinica));
		return mapearAnswerDto(clinica);
	}

	@Override
	public clinicaDto actualizarClinica(Long nitClinica, clinicaDto clinicaDto) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourseNotFoudExeption("clinica", "nit", nitClinica));
		
		clinica.setNombre(clinicaDto.getNombre());
		clinica.setDireccion(clinicaDto.getDireccion());
		clinica.setHorario_atencion(clinicaDto.getHorario_atencion());
		clinica.setDias_atencion(clinicaDto.getDias_atencion());
		clinica.setImagenclinica(clinicaDto.getImagenclinica());
		
		ClinicaVo clinicaActualizada = clinicaRepository.save(clinica);
		
		return mapearDto(clinicaActualizada);
	}

	@Override
	public void eliminarClinica(Long nitClinica) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourseNotFoudExeption("clinica", "nit", nitClinica));
		clinicaRepository.delete(clinica);
	}
	
	private clinicaDto mapearDto(ClinicaVo clinica) {
		clinicaDto clinicaDTO = modelMapper.map(clinica, clinicaDto.class);
		return clinicaDTO;
	}
	
	private ClinicaAnswerDto mapearAnswerDto(ClinicaVo clinica) {
		ClinicaAnswerDto clinicaAnswerDTO = modelMapper.map(clinica, ClinicaAnswerDto.class);
		return clinicaAnswerDTO;
	}
	
	private ClinicaVo mapearEntidad(clinicaDto clinicaDto) {
		ClinicaVo clinica = modelMapper.map(clinicaDto, ClinicaVo.class);
		return clinica;
	}

}
