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


import com.pets1.app.domain.HistoriaClinicaVo;
import com.pets1.app.service.IHistoriaClinicaService;

@RestController
@RequestMapping("/api")
public class HistoriaClinicaRest {

//	private static final String ENTITY_NAME="HistoriaClinicaVo";
	
	@Autowired
	private IHistoriaClinicaService historiaService;
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/historias")
	public List<HistoriaClinicaVo> listaHistorias(){
		return historiaService.listaHistoriaCli();
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/historias/{codigo}")
	public ResponseEntity<Optional<HistoriaClinicaVo>> buscarHistoriasID(@PathVariable Long codigo){
		Optional<HistoriaClinicaVo> historiasId = historiaService.buscarId(codigo);
		
		return ResponseEntity.ok().body(historiasId);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PostMapping("/historias")
	public ResponseEntity<?> guardarHistorias(@RequestBody HistoriaClinicaVo historiasVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(historiasVo.getCodigo() != null) {
			response.put("error", "ya existe esta la historia clinica con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		HistoriaClinicaVo miHistoria = historiaService.guardar(historiasVo);
		response.put("guardado con exito", miHistoria);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PutMapping("/historias/{codigo}")
	public ResponseEntity<?> actualizarHistoria(@PathVariable Long codigo ,@RequestBody HistoriaClinicaVo historiaVo)throws URISyntaxException{
		Optional<HistoriaClinicaVo> historia = historiaService.buscarId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(historia == null) {
			response.put("error", "la historia clinica no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		HistoriaClinicaVo miHistoriaVo = new HistoriaClinicaVo();
		miHistoriaVo.setCodigo(historiaVo.getCodigo());
		miHistoriaVo.setFecha(historiaVo.getFecha());
		miHistoriaVo.setMotivoConsulta(historiaVo.getMotivoConsulta());
		miHistoriaVo.setMascotaCod(historiaVo.getMascotaCod());
//		miHistoriaVo.setVeterinarioHisCli(historiaVo.getVeterinarioHisCli());
//		miHistoriaVo.setUsuarioDoc(historiaVo.getUsuarioDoc());
		
		miHistoriaVo = historiaService.guardar(miHistoriaVo);
		response.put("actualizado con exito", miHistoriaVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@DeleteMapping("/historias/{codigo}")
	public ResponseEntity<Void> eliminarHistoria(@PathVariable Long codigo){
		historiaService.eliminarHistoriaCli(codigo);
		return ResponseEntity.noContent().build();
	}
	
	
}
