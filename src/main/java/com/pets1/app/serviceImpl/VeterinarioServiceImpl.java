package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.dto.entityData.VeterinarioDto;
import com.pets1.app.exeptions.ResourseNotFoudExeption;
import com.pets1.app.repository.IClinicaRepository;
import com.pets1.app.repository.IVeterinarioRepository;
import com.pets1.app.service.IVeterinarioService;

@Service
@Transactional
public class VeterinarioServiceImpl implements IVeterinarioService{

	@Autowired
	private IVeterinarioRepository veterinarioRepository;
	
	@Autowired
	private IClinicaRepository clinicaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public VeterinarioDto guardarVeterinarios(Long nitClinica, VeterinarioDto veterinarioDto) {
		ClinicaVo clinica = clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourseNotFoudExeption("clinica", "nit", nitClinica));
		VeterinarioVo veterinario = mapearEntidad(veterinarioDto);
		veterinario.setClinica(clinica);
		
		VeterinarioVo nuevoVeterinario = veterinarioRepository.save(veterinario);
		return mapearDto(nuevoVeterinario);
	}

	@Override
	public List<VeterinarioDto> listaDeVeterinariosPorClinica(Long nitClinica) {
		clinicaRepository.findById(nitClinica).orElseThrow(() -> new ResourseNotFoudExeption("clinica", "nit", nitClinica));
		List<VeterinarioVo> veterinarios = veterinarioRepository.findByclinicaNit(nitClinica);
		return veterinarios.stream().map(vaterinario -> mapearDto(vaterinario)).collect(Collectors.toList());
	}

	@Override
	public VeterinarioDto buscarVeterinarioId(Long documentoVeterinario) {
		VeterinarioVo veterinario = veterinarioRepository.findById(documentoVeterinario).orElseThrow(() -> new ResourseNotFoudExeption("Veterinario", "documento", documentoVeterinario));
		return mapearDto(veterinario);
	}
	
	@Override
	public VeterinarioDto actualizarVeterinario(Long documentoVeterinario, VeterinarioDto veterinarioDto) {
		VeterinarioVo veterinario = veterinarioRepository.findById(documentoVeterinario).orElseThrow(() -> new ResourseNotFoudExeption("Veterinario", "documento", documentoVeterinario));
		
		veterinario.setNombre(veterinarioDto.getNombre());
		veterinario.setApellidos(veterinarioDto.getApellidos());
		veterinario.setSexovt(veterinarioDto.getSexovt());
		veterinario.setTelefono(veterinarioDto.getTelefono());
		veterinario.setCorreo(veterinarioDto.getCorreo());
		veterinario.setEspecialidad(veterinarioDto.getEspecialidad());
		veterinario.setPassword(veterinarioDto.getPassword());
		veterinario.setImagenVete(veterinarioDto.getImagenVete());
		
		VeterinarioVo asctualizarVeterinario = veterinarioRepository.save(veterinario);
		
		return mapearDto(asctualizarVeterinario);
	}

	@Override
	public void eliminarVeterinario(Long documentoVeterinario) {
		VeterinarioVo veterinario = veterinarioRepository.findById(documentoVeterinario).orElseThrow(() -> new ResourseNotFoudExeption("Veterinario", "documento", documentoVeterinario));
		veterinarioRepository.delete(veterinario);
	}
	
	private VeterinarioDto mapearDto(VeterinarioVo veterinarioVo) {
		VeterinarioDto veterinarioDto = modelMapper.map(veterinarioVo, VeterinarioDto.class);
		return veterinarioDto;
	}
	
	private VeterinarioVo mapearEntidad(VeterinarioDto veterinarioDto) {
		VeterinarioVo veterinarioVo = modelMapper.map(veterinarioDto, VeterinarioVo.class);
		return veterinarioVo;
	}

}
