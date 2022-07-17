package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.dto.answers.MascotaAswerDto;
import com.pets1.app.dto.entityData.MascotaDto;
import com.pets1.app.exeptions.AppPetsCareExeption;
import com.pets1.app.exeptions.ResourseNotFoudExeption;
import com.pets1.app.repository.IMascotaRepository;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IMascotaService;

@Service
@Transactional
public class MascotaServiceImpl implements IMascotaService{

	@Autowired
	private IMascotaRepository mascotaRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public MascotaDto guardarMascota(Long documentoUsuario, MascotaDto mascotaDto) {
		MascotaVo mascota = mapearEntidad(mascotaDto);
		UsuarioVo usuario = usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("Usuario", "documento", documentoUsuario));
		
		mascota.setDueniomascota(usuario);
		MascotaVo nuevaMascota = mascotaRepository.save(mascota);	
		
		return mapearDto(nuevaMascota);
	}

	@Override
	public List<MascotaAswerDto> obtenerMascotasDeUsuario(Long documentoUsuario) {
		usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("Usuario", "documento", documentoUsuario));
		List<MascotaVo> mascotas=mascotaRepository.findByDueniomascotaDocumentoUs(documentoUsuario);
		return mascotas.stream().map(mascota -> mapearAnswerDto(mascota)).collect(Collectors.toList());
		
	}

	@Override
	public MascotaDto obtenerMascotaId(Long documentoUsuario, Long codigoMascota) {
		UsuarioVo usuario = usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("Usuario", "documento", documentoUsuario));
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourseNotFoudExeption("Mascota", "codigo", codigoMascota));
		
		if(!mascota.getDueniomascota().getDocumentoUs().equals(usuario.getDocumentoUs())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la mascota no pertenese a este usuario");
			
		}
		
		return mapearDto(mascota);
	}

	@Override
	public MascotaDto actualizarMascota(Long documentoUsuario, Long codigoMascota, MascotaDto mascotaDto) {
		UsuarioVo usuario = usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("Usuario", "documento", documentoUsuario));
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourseNotFoudExeption("Mascota", "codigo", codigoMascota));
		
		if(!mascota.getDueniomascota().getDocumentoUs().equals(usuario.getDocumentoUs())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la mascota no pertenese a este usuario");
		}
		
		mascota.setNombre(mascotaDto.getNombre());
		mascota.setRaza(mascotaDto.getRaza());
		mascota.setColor(mascotaDto.getColor());
		mascota.setPeso(mascotaDto.getPeso());
		mascota.setDiscapacidad(mascotaDto.getDiscapacidad());
		mascota.setTipoAnimal(mascotaDto.getTipoAnimal());
		mascota.setImagenMascota(mascotaDto.getImagenMascota());
		
		MascotaVo mascotaActualizada = mascotaRepository.save(mascota);
		
		return mapearDto(mascotaActualizada);
	}

	@Override
	public void eliminarMascota(Long documentoUsuario, Long codigoMascota) {
		UsuarioVo usuario = usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("Usuario", "documento", documentoUsuario));
		MascotaVo mascota = mascotaRepository.findById(codigoMascota).orElseThrow(() -> new ResourseNotFoudExeption("Mascota", "codigo", codigoMascota));
		
		if(!mascota.getDueniomascota().getDocumentoUs().equals(usuario.getDocumentoUs())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la mascota no pertenese a este usuario");
		}
		
		mascotaRepository.delete(mascota);
		
	}
	
	private MascotaDto mapearDto(MascotaVo mascota) {
		MascotaDto mascotaDTO = modelMapper.map(mascota, MascotaDto.class);
		return mascotaDTO;
	}
	
	private MascotaAswerDto mapearAnswerDto(MascotaVo mascota) {
		MascotaAswerDto mascotaAswerDto = modelMapper.map(mascota, MascotaAswerDto.class);
		return mascotaAswerDto;
	}
	
	private MascotaVo mapearEntidad(MascotaDto mascotaDto) {
		MascotaVo mascota = modelMapper.map(mascotaDto, MascotaVo.class);
		return mascota;
	}
	

}
