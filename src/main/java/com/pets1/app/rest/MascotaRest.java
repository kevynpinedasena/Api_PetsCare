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

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.service.IMascotaService;

@RestController
@RequestMapping("/api")
public class MascotaRest {

//	private static final String ENTITY_NAME="MascotaVo";
	
	@Autowired
	private IMascotaService mascotaService;
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/mascotas")
	public List<MascotaVo> listaMascotas(){
		return mascotaService.listaMascotas();
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/mascotas/{codigo}")
	public ResponseEntity<Optional<MascotaVo>> buscarMascotaID(@PathVariable Long codigo){
		Optional<MascotaVo> mascotaId = mascotaService.buscarId(codigo);
		
		return ResponseEntity.ok().body(mascotaId);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PostMapping("/mascotas")
	public ResponseEntity<?> guardarMascota(@RequestBody MascotaVo mascotaVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(mascotaVo.getCodigo() != null) {
			response.put("error", "ya existe esta mascota con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		MascotaVo miMascota = mascotaService.guardar(mascotaVo);
		response.put("guardado con exito", miMascota);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PutMapping("/mascotas/{codigo}")
	public ResponseEntity<?> actualizarMascota(@PathVariable Long codigo ,@RequestBody MascotaVo mascotaVo)throws URISyntaxException{
		Optional<MascotaVo> mascota = mascotaService.buscarId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(mascota == null) {
			response.put("error", "la mascota no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		MascotaVo miMascotaVo = new MascotaVo();
		miMascotaVo.setCodigo(mascotaVo.getCodigo());
		miMascotaVo.setNombre(mascotaVo.getNombre());
		miMascotaVo.setRaza(mascotaVo.getRaza());
		miMascotaVo.setColor(mascotaVo.getColor());
		miMascotaVo.setPeso(mascotaVo.getPeso());
		miMascotaVo.setDiscapacidad(mascotaVo.getDiscapacidad());
		miMascotaVo.setTipoAnimal(mascotaVo.getTipoAnimal());
		miMascotaVo.setImagenMascota(mascotaVo.getImagenMascota());
//		miMascotaVo.setDuenioMasCo(mascotaVo.getDuenioMasCo());
		miMascotaVo.setDueniomascota(mascotaVo.getDueniomascota());
		
		miMascotaVo = mascotaService.guardar(miMascotaVo);
		response.put("actualizado con exito", miMascotaVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@DeleteMapping("/mascotas/{codigo}")
	public ResponseEntity<Void> eliminarMascota(@PathVariable Long codigo){
		mascotaService.eliminarMascota(codigo);
		return ResponseEntity.noContent().build();
	}
}
