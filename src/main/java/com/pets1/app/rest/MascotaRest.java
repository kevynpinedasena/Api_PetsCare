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

import com.pets1.app.dto.entityData.MascotaDto;
import com.pets1.app.service.IMascotaService;

@RestController
@RequestMapping("/api")
public class MascotaRest {
	
	@Autowired
	private IMascotaService mascotaService;
	
	@GetMapping("/usuario/{documento}/mascotas")
	public List<MascotaDto> listaDeMascotasUsuario(@PathVariable Long documento){
		return mascotaService.obtenerMascotasDeUsuario(documento);
	}
	
	@GetMapping("/usuario/{documento}/mascota/{codigo}")
	public ResponseEntity<MascotaDto> buscarMascotaID(@PathVariable Long documento, @PathVariable Long codigo){
		MascotaDto mascotaDto = mascotaService.obtenerMascotaId(documento, codigo);	
		return new ResponseEntity<>(mascotaDto, HttpStatus.OK);
	}	
	
	@PostMapping("/usuario/{documento}/mascotas")
	public ResponseEntity<MascotaDto> guardarMascota(@PathVariable Long documento ,@RequestBody MascotaDto mascotaDto){			
		return new ResponseEntity<>(mascotaService.guardarMascota(documento, mascotaDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/usuario/{documento}/mascota/{codigo}")
	public ResponseEntity<MascotaDto> actualizarMascota(@PathVariable Long documento , @PathVariable Long codigo, @RequestBody MascotaDto mascotaDto){
		MascotaDto mascotaActualizada=mascotaService.actualizarMascota(documento, codigo, mascotaDto);
		return new ResponseEntity<>(mascotaActualizada , HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{documento}/mascota/{codigo}")
	public ResponseEntity<String> eliminarMascota(@PathVariable Long documento, @PathVariable Long codigo){
		mascotaService.eliminarMascota(documento, codigo);
		return new ResponseEntity<>("mascota eliminada con exito", HttpStatus.OK);
	}
}
