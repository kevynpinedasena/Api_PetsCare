package com.pets1.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets1.app.dto.answers.AgendaAnswerDto;
import com.pets1.app.dto.answers.AgendaUsuarioAnswerDto;
import com.pets1.app.dto.answers.AgendaVeterinarioAnswerDto;
import com.pets1.app.dto.entityData.AgendaDto;
import com.pets1.app.service.IAgendaService;

@RestController
@RequestMapping("/api")
public class AgendaRest {
	
	@Autowired
	private IAgendaService agendaService;
	
	@GetMapping("/usuario/{documentoUsuario}/agendas")
	public List<AgendaUsuarioAnswerDto> buscarAgendaDeUsuario(@PathVariable Long documentoUsuario){
		return agendaService.listaAgendaUsuario(documentoUsuario);
	}
	
	@GetMapping("veterinario/{documentoVeterinario}/agendas")
	public List<AgendaVeterinarioAnswerDto> buscarAgendaDeVeterinario(@PathVariable Long documentoVeterinario){
		return agendaService.listaAgendaVeterinario(documentoVeterinario);
	}
	
	@GetMapping("/agendas/{codigo}")
	public ResponseEntity<AgendaAnswerDto> buscarAgendaId(@PathVariable Long codigo){
		AgendaAnswerDto agenda = agendaService.buscarAgendaId(codigo);
		return new ResponseEntity<>(agenda, HttpStatus.OK);
	}
	

	@PostMapping("/usuario/{documentoUsuario}/veterinario/{documentoVeterinario}/agendas")
	public ResponseEntity<AgendaDto> guardarAgenda(@PathVariable Long documentoUsuario, @PathVariable Long documentoVeterinario, @RequestBody AgendaDto agendaDto){			
		AgendaDto agenda = agendaService.CrearAgenda(documentoUsuario, documentoVeterinario, agendaDto);	
		return new ResponseEntity<> (agenda, HttpStatus.CREATED);
	}

	@PutMapping("/agendas/{codigo}")
	public ResponseEntity<AgendaDto> actualizarAgenda(@PathVariable Long codigo ,@RequestBody AgendaDto agendaDto){
		AgendaDto agenda= agendaService.actualizarAgenda(codigo, agendaDto);		
		return new ResponseEntity<>(agenda, HttpStatus.OK);
	}

	@DeleteMapping("/agendas/{codigo}")
	public ResponseEntity<String> eliminarAgenda(@PathVariable Long codigo){
		agendaService.eliminarAgenda(codigo);
		return new ResponseEntity<>("cita eliminada con exito", HttpStatus.OK);
	}
	
}
