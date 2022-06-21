package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IUsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public UsuarioVo guardar(UsuarioVo usuarioVo) {
		
		return usuarioRepository.save(usuarioVo);
	}

	@Override
	public List<UsuarioVo> listaUsuario() {
		List<UsuarioVo> listaUsuario = usuarioRepository.findAll();
		return listaUsuario;
	}

	@Override
	public Optional<UsuarioVo> buscarId(Long documento) {
		Optional<UsuarioVo> buscarUsuarioId = usuarioRepository.findById(documento);
		return buscarUsuarioId;
	}

	@Override
	public void eliminarUsuario(Long documento) {
		usuarioRepository.deleteById(documento);
	}
	
}
