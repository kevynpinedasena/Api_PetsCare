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

import com.pets1.app.domain.RolVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.dto.answers.UsuarioAnswerDto;
import com.pets1.app.dto.entityData.UsuarioDto;
import com.pets1.app.exeptions.AppPetsCareExeption;
import com.pets1.app.exeptions.ResourceNotFoudExeption;
import com.pets1.app.repository.IRolRepository;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IRolRepository rolRepository;
	
	private int ACTIVO = 1;
	private int INACTIVO = 2;
	
	
	@Override
	public void guardarUsuario(UsuarioDto usuarioDto) {	
		boolean usuarios = usuarioRepository.findById(usuarioDto.getDocumentoUs()).isPresent();
		
		if(usuarios == true) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "el usuario ya existe con este documento");
		}

		else if(usuarioRepository.existsByCorreoUs(usuarioDto.getCorreoUs())) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "Ya existe un usuario con este email" );
		}
		
		UsuarioVo usuario = mapearEntidad(usuarioDto);
		usuario.setPasswordUs(passwordEncoder.encode(usuarioDto.getPasswordUs()));
		
		if (usuario.getEstadoUs() != ACTIVO && usuario.getEstadoUs() != INACTIVO) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "El estado no puede ser mayor a 2 y menor de 1");
		}

		RolVo roles = rolRepository.findByNombre("ROLE_USER").get();
		usuario.setRoles(Collections.singleton(roles));
		
		usuarioRepository.save(usuario);
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
		
		usuario.setNombreUs(usuarioDto.getNombreUs());
		usuario.setApellidoUs(usuarioDto.getApellidoUs());
		usuario.setSexoUs(usuarioDto.getSexoUs());
		usuario.setTelefonoUs(usuarioDto.getTelefonoUs());
		usuario.setCorreoUs(usuarioDto.getCorreoUs());
		usuario.setPasswordUs(passwordEncoder.encode(usuarioDto.getPasswordUs()));
		usuario.setImagenUsu(usuarioDto.getImagenUsu());
		
		UsuarioVo usuarioActualizado = usuarioRepository.save(usuario);
		
		return mapearDto(usuarioActualizado);
	}

	@Override
	public void eliminarUsuario(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		usuarioRepository.delete(usuario);
	}

	@Override
	public void deshabilitarEstadoUsuario(int estado, Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourceNotFoudExeption("usuario", "documento", documento));
		
		if(estado != ACTIVO && estado != INACTIVO) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "El estado no puede ser mayor a 2 y menor de 1");
		}
		
		usuario.setEstadoUs(estado);
		usuarioRepository.save(usuario);
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