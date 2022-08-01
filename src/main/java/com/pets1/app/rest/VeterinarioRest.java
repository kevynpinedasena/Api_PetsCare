package com.pets1.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets1.app.dto.answers.VeterinarioAnswerDto;
import com.pets1.app.dto.entityData.VeterinarioDto;
import com.pets1.app.service.IVeterinarioService;

@RestController
@RequestMapping("/api")
public class VeterinarioRest {
	
	@Autowired
	private IVeterinarioService veterinarioService;
	
	@GetMapping("/clinica/{nitclinica}/veterinarios")
	public List<VeterinarioAnswerDto> listaVeterinario(@PathVariable Long nitclinica){
		return veterinarioService.listaDeVeterinariosPorClinica(nitclinica);
	}
	
	@GetMapping("/veterinarios/{documento}")
	public ResponseEntity<VeterinarioDto> buscarVeterinarioID(@PathVariable Long documento){
		VeterinarioDto veterinario = veterinarioService.buscarVeterinarioId(documento);
		return new ResponseEntity<>(veterinario, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLINICA')")
	@PostMapping("/veterinarios/{nitclinica}")
	public ResponseEntity<VeterinarioDto> guardarveterinario(@PathVariable Long nitclinica, @RequestBody VeterinarioDto veterinarioDto){		
		VeterinarioDto veterinario = veterinarioService.guardarVeterinarios(nitclinica, veterinarioDto);
		return new ResponseEntity<> (veterinario, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('VETERINARIO')")
	@PutMapping("/veterinarios/{documento}")
	public ResponseEntity<VeterinarioDto> actualizarVeterinario(@PathVariable Long documento ,@RequestBody VeterinarioDto veterinarioDto){
		VeterinarioDto veterinario = veterinarioService.actualizarVeterinario(documento, veterinarioDto);
		return new ResponseEntity<> (veterinario, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('CLINICA')")
	@DeleteMapping("/veterinarios/{documento}")
	public ResponseEntity<String> eliminarVeterinario(@PathVariable Long documento){
		veterinarioService.eliminarVeterinario(documento);
		return new ResponseEntity<>("eliminado con exito", HttpStatus.OK);
	}
}
