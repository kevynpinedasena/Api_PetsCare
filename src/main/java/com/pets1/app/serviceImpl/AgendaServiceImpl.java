package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.AgendaVo;
import com.pets1.app.repository.IAgendaRepository;
import com.pets1.app.service.IAgendaService;

@Service
@Transactional
public class AgendaServiceImpl implements IAgendaService{
	
	@Autowired
	private IAgendaRepository agendaRepository;

	@Override
	public AgendaVo guardar(AgendaVo agendaVo) {
	
		return agendaRepository.save(agendaVo);
	}

	@Override
	public List<AgendaVo> listaAgenda() {
		List<AgendaVo> listaAgendas = agendaRepository.findAll();
		return listaAgendas;
	}

	@Override
	public Optional<AgendaVo> buscarId(Long codigo) {
		Optional<AgendaVo> buscarAgendaId = agendaRepository.findById(codigo);
		return buscarAgendaId;
	}

	@Override
	public void eliminarAgenda(Long codigo) {
		agendaRepository.deleteById(codigo);
	}
	
}
