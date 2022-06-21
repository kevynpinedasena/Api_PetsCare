package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.repository.IMascotaRepository;
import com.pets1.app.service.IMascotaService;

@Service
@Transactional
public class MascotaServiceImpl implements IMascotaService{

	@Autowired
	private IMascotaRepository mascotaRepository;
	
	@Override
	public MascotaVo guardar(MascotaVo mascotaVo) {
		
		return mascotaRepository.save(mascotaVo);
	}

	@Override
	public List<MascotaVo> listaMascotas() {
		List<MascotaVo> listaMascotas = mascotaRepository.findAll();
		return listaMascotas;
	}

	@Override
	public Optional<MascotaVo> buscarId(Long codigo) {
		Optional<MascotaVo> buscarMascotaId = mascotaRepository.findById(codigo);
		return buscarMascotaId;
	}

	@Override
	public void eliminarMascota(Long codigo) {
		mascotaRepository.deleteById(codigo);
	}

}
