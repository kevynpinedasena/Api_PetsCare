package com.pets1.app.service;

import java.util.List;

import com.pets1.app.dto.entityData.AgendaDto;

public interface IAgendaService {
	
	AgendaDto CrearAgenda(Long documentoUsuario, Long documentoVeterinario, AgendaDto agendaDto);
	
	List<AgendaDto> listaAgendaUsuario(Long documentoUsuario);
	
	List<AgendaDto> listaAgendaVeterinario(Long documentoVeterinario);
	
	AgendaDto buscarAgendaId(Long codigo);
	
	AgendaDto actualizarAgenda(Long codigo, AgendaDto agendaDto);
	
	void eliminarAgenda(Long codigo);

}
