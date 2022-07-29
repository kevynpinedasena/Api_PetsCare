package com.pets1.app.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.domain.RolVo;
import com.pets1.app.dto.answers.ClinicaAnswerDto;
import com.pets1.app.dto.entityData.clinicaDto;
import com.pets1.app.exeptions.AppPetsCareExeption;
import com.pets1.app.exeptions.ResourceNotFoudExeption;
import com.pets1.app.repository.IClinicaRepository;
import com.pets1.app.repository.IRolRepository;
import com.pets1.app.service.IClinicaService;

@Service
@Transactional
public class ClinicaServiceImpl implements IClinicaService{
	
	@Autowired
	private IClinicaRepository clinicaRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IRolRepository rolRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void crearClinica(clinicaDto clinicaDto) {
		boolean clinica = clinicaRepository.findById(clinicaDto.getNit()).isPresent();
		
		if(clinica == true) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "ya existe una clinica con este nit");
		}
		
		else if(clinicaRepository.existsByCorreoCv(clinicaDto.getCorreoCv())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "Ya existe un clinica con este email" );
		}
		
		ClinicaVo clinicaDatos = mapearEntidad(clinicaDto);
		clinicaDatos.setPasswordCv(passwordEncoder.encode(clinicaDto.getPassword()));
		
		RolVo rol = rolRepository.findByNombre("ROLE_CLINICA").get();
		clinicaDatos.setRoles(Collections.singleton(rol));
		
		clinicaRepository.save(clinicaDatos);
	}

	@Override
	public List<ClinicaAnswerDto> consultarListaDeClinicas() {
		List<ClinicaVo> clinicas = clinicaRepository.findAll();
		return clinicas.stream().map(clinica -> mapearAnswerDto(clinica)).collect(Collectors.toList());
	}

	@Override
	public ClinicaAnswerDto consultarClinicaPorId(Long nitClinica) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourceNotFoudExeption("clinica", "nit", nitClinica));
		return mapearAnswerDto(clinica);
	}

	@Override
	public clinicaDto actualizarClinica(Long nitClinica, clinicaDto clinicaDto) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourceNotFoudExeption("clinica", "nit", nitClinica));
		
		clinica.setNombre(clinicaDto.getNombre());
		clinica.setDireccion(clinicaDto.getDireccion());
		clinica.setTelefono(clinicaDto.getTelefono());
		clinica.setCorreoCv(clinicaDto.getCorreoCv());
		clinica.setHorario_atencion(clinicaDto.getHorario_atencion());
		clinica.setDias_atencion(clinicaDto.getDias_atencion());
		clinica.setPasswordCv(passwordEncoder.encode(clinicaDto.getPassword()));
		clinica.setImagenclinica(clinicaDto.getImagenclinica());
		
		ClinicaVo clinicaActualizada = clinicaRepository.save(clinica);
		
		return mapearDto(clinicaActualizada);
	}

	@Override
	public void eliminarClinica(Long nitClinica) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourceNotFoudExeption("clinica", "nit", nitClinica));
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