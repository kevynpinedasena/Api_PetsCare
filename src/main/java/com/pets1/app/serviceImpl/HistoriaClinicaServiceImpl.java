package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.HistoriaClinicaVo;
import com.pets1.app.repository.IHistoriaClinicaRepository;
import com.pets1.app.service.IHistoriaClinicaService;

@Service
@Transactional
public class HistoriaClinicaServiceImpl implements IHistoriaClinicaService{

	@Autowired
	private IHistoriaClinicaRepository historiaRepository;
	
	@Override
	public HistoriaClinicaVo guardar(HistoriaClinicaVo historiaCli) {
		
		return historiaRepository.save(historiaCli);
	}

	@Override
	public List<HistoriaClinicaVo> listaHistoriaCli() {
		List<HistoriaClinicaVo> listaHistoriaCli = historiaRepository.findAll();
		return listaHistoriaCli;
	}

	@Override
	public Optional<HistoriaClinicaVo> buscarId(Long codigo) {
		Optional<HistoriaClinicaVo> buscarHistoriaId = historiaRepository.findById(codigo);
		return buscarHistoriaId;
	}

	@Override
	public void eliminarHistoriaCli(Long codigo) {
		historiaRepository.deleteById(codigo);
	}

}
