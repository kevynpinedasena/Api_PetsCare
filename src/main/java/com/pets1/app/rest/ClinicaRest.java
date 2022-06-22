package com.pets1.app.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.service.IClinicaService;

@RestController
@RequestMapping("/api")
public class ClinicaRest {

//	private static final String ENTITY_NAME="ClinicaVo";
	
	@Autowired
	private IClinicaService clinicaService;
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/clinicas")
	public List<ClinicaVo> listaClinica(){
		return clinicaService.listaClinica();
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/clinicas/{codigo}")
	public ResponseEntity<Optional<ClinicaVo>> buscarClinicaID(@PathVariable Long codigo){
		Optional<ClinicaVo> clinicaId = clinicaService.buscarId(codigo);
		
		return ResponseEntity.ok().body(clinicaId);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PostMapping("/clinicas")
	public ResponseEntity<?> guardarClinica(@RequestBody ClinicaVo clinicaVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(clinicaVo.getNit() == null) {
			response.put("error", "ya existe esta clinica con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		ClinicaVo miClinica=clinicaService.guardar(clinicaVo);
		response.put("guardado con exito", miClinica);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PutMapping("/clinicas/{codigo}")
	public ResponseEntity<?> actualizarClinica(@PathVariable Long codigo ,@RequestBody ClinicaVo clinicaVo)throws URISyntaxException{
		Optional<ClinicaVo> clinica = clinicaService.buscarId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(clinica == null) {
			response.put("error", "la clinica no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		ClinicaVo miClinicaVo = new ClinicaVo();
		miClinicaVo.setNit(clinicaVo.getNit());
		miClinicaVo.setNombre(clinicaVo.getNombre());
		miClinicaVo.setDireccion(clinicaVo.getDireccion());
		miClinicaVo.setHorario_atencion(clinicaVo.getHorario_atencion());
		miClinicaVo.setDiasAtencion(clinicaVo.getDiasAtencion());
		miClinicaVo.setRol(clinicaVo.getRol());
		miClinicaVo.setImagenClinica(clinicaVo.getImagenClinica());
		miClinicaVo.setVeterinarioCod(clinicaVo.getVeterinarioCod());
		
		miClinicaVo = clinicaService.guardar(miClinicaVo);
		response.put("actualizado con exito", miClinicaVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@DeleteMapping("/clinicas/{codigo}")
	public ResponseEntity<Void> eliminarClinica(@PathVariable Long codigo){
		clinicaService.eliminarClinica(codigo);
		return ResponseEntity.noContent().build();
	}
}
