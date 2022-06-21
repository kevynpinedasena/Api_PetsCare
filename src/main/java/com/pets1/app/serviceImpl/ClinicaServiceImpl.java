package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.repository.IClinicaRepository;
import com.pets1.app.service.IClinicaService;

@Service
@Transactional
public class ClinicaServiceImpl implements IClinicaService{

	@Autowired
	private IClinicaRepository clinicaRepository;

	@Override
	public ClinicaVo guardar(ClinicaVo clinicaVo) {
		
		return clinicaRepository.save(clinicaVo);
	}

	@Override
	public List<ClinicaVo> listaClinica() {
		List<ClinicaVo> listaClinicas = clinicaRepository.findAll();
		return listaClinicas;
	}

	@Override
	public Optional<ClinicaVo> buscarId(Long nit) {
		Optional<ClinicaVo> buscarClinicaId = clinicaRepository.findById(nit);
		return buscarClinicaId;
	}

	@Override
	public void eliminarClinica(Long nit) {
		clinicaRepository.deleteById(nit);
	}
	
	
}
