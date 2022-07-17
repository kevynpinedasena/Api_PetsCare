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

import com.pets1.app.dto.answers.HistoriaClinicaAnswerDto;
import com.pets1.app.dto.entityData.HistoriaClinicaDto;
import com.pets1.app.service.IHistoriaClinicaService;

@RestController
@RequestMapping("/api")
public class HistoriaClinicaRest {
	
	@Autowired
	private IHistoriaClinicaService historiaClinicaService;
	
	@GetMapping("/mascota/{codigom}/historia")
	public List<HistoriaClinicaAnswerDto> buscarHistoriaClinicaMascota(@PathVariable Long codigom){
		return historiaClinicaService.historiaClinicaDeMascota(codigom);
	}
	
	@GetMapping("/mascota/{codigom}/historia/{codigoh}")
	public ResponseEntity<HistoriaClinicaDto> buscarHistoriasClinicaID(@PathVariable Long codigom, @PathVariable Long codigoh){
		HistoriaClinicaDto historiaClinica = historiaClinicaService.buscarHistoriaClnicaMascotaId(codigom, codigoh);
		return new ResponseEntity<>(historiaClinica, HttpStatus.OK);
	}
	
	@PostMapping("/mascota/{codigom}/historia")
	public ResponseEntity<HistoriaClinicaDto> guardarHistoriaClinica(@PathVariable Long codigom, @RequestBody HistoriaClinicaDto historiasClinicaDto){			
		return new ResponseEntity<>(historiaClinicaService.guardarHistoria(codigom, historiasClinicaDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/mascota/{codigom}/historia/{codigoh}")
	public ResponseEntity<HistoriaClinicaDto> actualizarHistoriaClinica(@PathVariable Long codigom, @PathVariable Long codigoh, @RequestBody HistoriaClinicaDto historiaClinicaDto){		
		HistoriaClinicaDto historiaClinica = historiaClinicaService.actualizarHistoriaClinica(codigom, codigoh, historiaClinicaDto);
		return new ResponseEntity<> (historiaClinica, HttpStatus.OK);
	}
	
	@DeleteMapping("/mascota/{codigom}/historia/{codigoh}")
	public ResponseEntity<String> eliminarHistoriaClinica(@PathVariable Long codigom, @PathVariable Long codigoh){
		historiaClinicaService.eliminarHistoriaClinica(codigom, codigoh);
		return new ResponseEntity<>("historia clinica eliminada con exito", HttpStatus.OK);
	}
	
}
