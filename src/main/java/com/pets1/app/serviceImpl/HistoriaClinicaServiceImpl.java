package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.HistoriaClinicaVo;
import com.pets1.app.domain.MascotaVo;
import com.pets1.app.dto.answers.HistoriaClinicaAnswerDto;
import com.pets1.app.dto.entityData.HistoriaClinicaDto;
import com.pets1.app.exeptions.AppPetsCareExeption;
import com.pets1.app.exeptions.ResourceNotFoudExeption;
import com.pets1.app.repository.IHistoriaClinicaRepository;
import com.pets1.app.repository.IMascotaRepository;
import com.pets1.app.service.IHistoriaClinicaService;

@Service
@Transactional
public class HistoriaClinicaServiceImpl implements IHistoriaClinicaService{
	
	@Autowired
	private IHistoriaClinicaRepository historiaClinicaRepository;
	
	@Autowired
	private IMascotaRepository mascotaRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public HistoriaClinicaDto guardarHistoria(Long codigoMascota, HistoriaClinicaDto historiaClinica) {
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourceNotFoudExeption("Mascota", "codigo", codigoMascota));
		HistoriaClinicaVo historiaClinicaMascota = mapearEntidad(historiaClinica);
		
		historiaClinicaMascota.setMascotaCod(mascota);
		HistoriaClinicaVo nuevaHistoriaClinica = historiaClinicaRepository.save(historiaClinicaMascota);
		
		return mapearDto(nuevaHistoriaClinica);
	}

	@Override
	public List<HistoriaClinicaAnswerDto> historiaClinicaDeMascota(Long codigoMascota) {
		mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourceNotFoudExeption("Mascota", "codigo", codigoMascota));
		List<HistoriaClinicaVo> historiaClinicaMascota = historiaClinicaRepository.findByMascotaCodCodigo(codigoMascota);
		return historiaClinicaMascota.stream().map(historiaClinica -> mapearAswersDto(historiaClinica)).collect(Collectors.toList());
	}

	@Override
	public HistoriaClinicaDto buscarHistoriaClnicaMascotaId(Long codigoMascota, Long codigoHistoria) {
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourceNotFoudExeption("Mascota", "codigo", codigoMascota));
		HistoriaClinicaVo historiaClinca = historiaClinicaRepository.findById(codigoHistoria).orElseThrow(() -> new ResourceNotFoudExeption("Historia clinica", "codigo", codigoMascota));
		if(!historiaClinca.getMascotaCod().getCodigo().equals(mascota.getCodigo())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la historia no pertenese a esta mascota");
		}
		
		return mapearDto(historiaClinca);
	}

	@Override
	public HistoriaClinicaDto actualizarHistoriaClinica(Long codigoMascota, Long codigoHistoria, HistoriaClinicaDto historiaClinica) {
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourceNotFoudExeption("Mascota", "codigo", codigoMascota));
		HistoriaClinicaVo historiaClinca = historiaClinicaRepository.findById(codigoHistoria).orElseThrow(() -> new ResourceNotFoudExeption("Historia clinica", "codigo", codigoHistoria));
		if(!historiaClinca.getMascotaCod().getCodigo().equals(mascota.getCodigo())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la historia no pertenese a esta mascota");
		}
		
		historiaClinca.setFecha(historiaClinica.getFecha());
		historiaClinca.setMotivoConsulta(historiaClinica.getMotivoConsulta());
		
		HistoriaClinicaVo histotiaClinicaActualizada = historiaClinicaRepository.save(historiaClinca);
		
		return mapearDto(histotiaClinicaActualizada);
	}

	@Override
	public void eliminarHistoriaClinica(Long codigoMascota, Long codigoHistoria) {
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourceNotFoudExeption("Mascota", "codigo", codigoMascota));
		HistoriaClinicaVo historiaClinca = historiaClinicaRepository.findById(codigoHistoria).orElseThrow(() -> new ResourceNotFoudExeption("Historia clinica", "codigo", codigoMascota));
		if(!historiaClinca.getMascotaCod().getCodigo().equals(mascota.getCodigo())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la historia no pertenese a esta mascota");
		}
		
		historiaClinicaRepository.delete(historiaClinca);
		
	}

	private HistoriaClinicaDto mapearDto(HistoriaClinicaVo historiaClinicaVo) {
		HistoriaClinicaDto historiaDto = modelMapper.map(historiaClinicaVo, HistoriaClinicaDto.class);
		return historiaDto;
	}
	
	private HistoriaClinicaAnswerDto mapearAswersDto(HistoriaClinicaVo historiaClinicaVo) {
		HistoriaClinicaAnswerDto historiaAnwerDto = modelMapper.map(historiaClinicaVo, HistoriaClinicaAnswerDto.class);
		return historiaAnwerDto;
	}
	
	private HistoriaClinicaVo mapearEntidad(HistoriaClinicaDto historiaClinicaDto) {
		HistoriaClinicaVo historiaVo = modelMapper.map(historiaClinicaDto, HistoriaClinicaVo.class);
		return historiaVo;
	}

}
