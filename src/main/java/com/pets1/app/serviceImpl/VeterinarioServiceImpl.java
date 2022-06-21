package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.repository.IVeterinarioRepository;
import com.pets1.app.service.IVeterinarioService;

@Service
@Transactional
public class VeterinarioServiceImpl implements IVeterinarioService{

	@Autowired
	private IVeterinarioRepository veterinarioRepository;
	
	@Override
	public VeterinarioVo guardar(VeterinarioVo veterinarioVo) {
		
		return veterinarioRepository.save(veterinarioVo);
	}

	@Override
	public List<VeterinarioVo> listaVeterinarios() {
		List<VeterinarioVo> listaVeterinarios = veterinarioRepository.findAll();
		return listaVeterinarios;
	}

	@Override
	public Optional<VeterinarioVo> buscarId(Long documento) {
		Optional<VeterinarioVo> buscarVeterinarioId = veterinarioRepository.findById(documento);
		return buscarVeterinarioId;
	}

	@Override
	public void eliminarVeterinario(Long documento) {
		veterinarioRepository.deleteById(documento);
	}

}
