package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.exeptions.ResourseNotFoudExeption;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IUsuarioService;
import com.pets1.app.service.dto.entityData.UsuarioDto;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public UsuarioDto guardarUsuario(UsuarioDto usuarioDto) {
		System.out.println("***********\n*******************\n**************\n**************");
		UsuarioVo usuario = mapearEntidad(usuarioDto);
		UsuarioVo nuevoUsuario = usuarioRepository.save(usuario);
		UsuarioDto usuarioRespuesta = mapearDto(nuevoUsuario);
 		return usuarioRespuesta;
	}

	@Override
	public List<UsuarioDto> obtenerTodosLosUsuarios() {
		List<UsuarioVo> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(usuario -> mapearDto(usuario)).collect(Collectors.toList());
	}

	@Override
	public UsuarioDto buscarUsuarioPorDocumento(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourseNotFoudExeption("usuario", "documento", documento));
		return mapearDto(usuario);
	}

	@Override
	public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto, Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourseNotFoudExeption("usuario", "documento", documento));
		
//		usuario.setDocumentoUs(usuarioDto.getDocumentoUs());
		usuario.setNombreUs(usuarioDto.getNombreUs());
		usuario.setApellidoUs(usuarioDto.getApellidoUs());
		usuario.setSexoUs(usuarioDto.getSexoUs());
		usuario.setTelefonoUs(usuarioDto.getTelefonoUs());
		usuario.setCorreoUs(usuarioDto.getCorreoUs());
		usuario.setPasswordUs(usuarioDto.getPasswordUs());
		usuario.setImagenUsu(usuarioDto.getImagenUsu());
		usuario.setRolUs(usuarioDto.getRolUs());
		
		UsuarioVo usuarioActualizado = usuarioRepository.save(usuario);
		
		return mapearDto(usuarioActualizado);
	}

	@Override
	public void eliminarUsuario(Long documento) {
		UsuarioVo usuario = usuarioRepository.findById(documento).orElseThrow(() -> new ResourseNotFoudExeption("usuario", "documento", documento));
		usuarioRepository.delete(usuario);
	}

	private UsuarioDto mapearDto(UsuarioVo usuario) {
		UsuarioDto usuarioDTO = modelMapper.map(usuario, UsuarioDto.class);
		return usuarioDTO;
	}
	
	private UsuarioVo mapearEntidad(UsuarioDto usuarioDto) {
		UsuarioVo usuario = modelMapper.map(usuarioDto, UsuarioVo.class);
		return usuario;
	}
	
}
