package com.pets1.app.service;

import java.util.List;
import java.util.Optional;

import com.pets1.app.domain.AgendaVo;

public interface IAgendaService {
	
	AgendaVo guardar(AgendaVo agendaVo);
	
	List<AgendaVo> listaAgenda();
	
	Optional<AgendaVo> buscarId(Long codigo);
	
	void eliminarAgenda(Long codigo);

}
