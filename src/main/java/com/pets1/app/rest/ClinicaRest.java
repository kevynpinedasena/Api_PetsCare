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

import com.pets1.app.dto.entityData.clinicaDto;
import com.pets1.app.service.IClinicaService;

@RestController
@RequestMapping("/api")
public class ClinicaRest {
	
	@Autowired
	private IClinicaService clinicaService;
	
	@GetMapping("/clinicas")
	public List<clinicaDto> listaClinica(){
		return clinicaService.consultarListaDeClinicas();
	}
	
	@GetMapping("/clinicas/{nit}")
	public ResponseEntity<clinicaDto> buscarClinicaID(@PathVariable Long nit){
		return ResponseEntity.ok(clinicaService.consultarClinicaPorId(nit));
	}
	
	@PostMapping("/clinicas")
	public ResponseEntity<clinicaDto> guardarClinica(@RequestBody clinicaDto clinicaDto){	
		return new ResponseEntity<>(clinicaService.crearClinica(clinicaDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/clinicas/{nit}")
	public ResponseEntity<clinicaDto> actualizarClinica(@PathVariable Long nit ,@RequestBody clinicaDto clinicaDto){
		clinicaDto clinica = clinicaService.actualizarClinica(nit, clinicaDto);
		return new ResponseEntity<>(clinica, HttpStatus.OK);
	}
	
	@DeleteMapping("/clinicas/{nit}")
	public ResponseEntity<String> eliminarClinica(@PathVariable Long nit){
		clinicaService.eliminarClinica(nit);
		return new ResponseEntity<>("se elimino la clinica con exito", HttpStatus.OK);
	}
	
}
