package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.dto.answers.UsuarioAnswerDto;
import com.pets1.app.dto.entityData.UsuarioDto;
import com.pets1.app.exeptions.AppPetsCareExeption;
import com.pets1.app.exeptions.ResourceNotFoudExeption;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
		boolean usuarios = usuarioRepository.findById(usuarioDto.getDocumentoUs()).isPresent();
		
		System.out.println(usuarios);
		if(usuarios == true) {
			System.out.println("");
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "el usuario ya existe");
		}
		UsuarioVo usuario = mapearEntidad(usuarioDto);
		UsuarioVo nuevoUsuario = usuarioRepository.save(usuario);
		UsuarioDto usuarioRespuesta = mapearDto(nuevoUsuario);
 		return usuarioRespuesta;
	}

	@Override
	public List<UsuarioAnswerDto> obtenerTodosLosUsuarios() {
		List<UsuarioVo> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(usuario -> mapearAnswerDto(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDto buscarUsuarioPorDocumento(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		return mapearDto(usuario);
	}
	
	@Override
	public UsuarioAnswerDto buscarUsuarioConMascotas(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		return mapearAnswerDto(usuario);
	}

	@Override
	public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto, Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		
//		usuario.setDocumentoUs(usuarioDto.getDocumentoUs());
		usuario.setNombreUs(usuarioDto.getNombreUs());
		usuario.setApellidoUs(usuarioDto.getApellidoUs());
		usuario.setSexoUs(usuarioDto.getSexoUs());
		usuario.setTelefonoUs(usuarioDto.getTelefonoUs());
		usuario.setCorreoUs(usuarioDto.getCorreoUs());
		usuario.setPasswordUs(usuarioDto.getPasswordUs());
		usuario.setImagenUsu(usuarioDto.getImagenUsu());
//		usuario.setRolUs(usuarioDto.getRolUs());
		
		UsuarioVo usuarioActualizado = usuarioRepository.save(usuario);
		
		return mapearDto(usuarioActualizado);
	}

	@Override
	public void eliminarUsuario(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		usuarioRepository.delete(usuario);
	}

	private UsuarioDto mapearDto(UsuarioVo usuario) {
		UsuarioDto usuarioDTO = modelMapper.map(usuario, UsuarioDto.class);
		return usuarioDTO;
	}
	
	private UsuarioAnswerDto mapearAnswerDto(UsuarioVo usuario) {
		UsuarioAnswerDto usuarioAnswerDto = modelMapper.map(usuario, UsuarioAnswerDto.class);
		return usuarioAnswerDto;
	}
	
	private UsuarioVo mapearEntidad(UsuarioDto usuarioDto) {
		UsuarioVo usuario = modelMapper.map(usuarioDto, UsuarioVo.class);
		return usuario;
	}
	
}
