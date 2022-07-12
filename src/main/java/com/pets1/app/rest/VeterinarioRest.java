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

import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.service.IVeterinarioService;

@RestController
@RequestMapping("/api")
public class VeterinarioRest {

//	private static final String ENTITY_NAME="VeterinarioVo";
	
	@Autowired
	private IVeterinarioService veterinarioService;
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/veterinarios")
	public List<VeterinarioVo> listaVeterinario(){
		return veterinarioService.listaVeterinarios();
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@GetMapping("/veterinarios/{codigo}")
	public ResponseEntity<Optional<VeterinarioVo>> buscarVeterinarioID(@PathVariable Long codigo){
		Optional<VeterinarioVo> veterinarioId = veterinarioService.buscarId(codigo);
		
		return ResponseEntity.ok().body(veterinarioId);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PostMapping("/veterinarios")
	public ResponseEntity<?> guardarveterinario(@RequestBody VeterinarioVo veterinarioVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(veterinarioVo.getDocumento() == null) {
			response.put("error", "ya existe el veterinario con este id");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		VeterinarioVo miVeterinario = veterinarioService.guardar(veterinarioVo);
		response.put("guardado con exito", miVeterinario);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@PutMapping("/veterinarios/{codigo}")
	public ResponseEntity<?> actualizarVeterinario(@PathVariable Long codigo ,@RequestBody VeterinarioVo veterinarioVo)throws URISyntaxException{
		Optional<VeterinarioVo> veterinario = veterinarioService.buscarId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(veterinario == null) {
			response.put("error", "el veterinario no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		VeterinarioVo miVeterinarioVo = new VeterinarioVo();
		miVeterinarioVo.setDocumento(veterinarioVo.getDocumento());
		miVeterinarioVo.setNombre(veterinarioVo.getNombre());
		miVeterinarioVo.setApellidos(veterinarioVo.getApellidos());
		miVeterinarioVo.setSexovt(veterinarioVo.getSexovt());
		miVeterinarioVo.setTelefono(veterinarioVo.getTelefono());
		miVeterinarioVo.setCorreo(veterinarioVo.getCorreo());
		miVeterinarioVo.setEspecialidad(veterinarioVo.getEspecialidad());
		miVeterinarioVo.setPassword(veterinarioVo.getPassword());
		miVeterinarioVo.setImagenVete(veterinarioVo.getImagenVete());
		miVeterinarioVo.setClinica_nit(veterinarioVo.getClinica_nit());
		
		miVeterinarioVo = veterinarioService.guardar(miVeterinarioVo);
		response.put("actualizado con exito", miVeterinarioVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@CrossOrigin(origins = {"http://localhost:8080","null"})
	@DeleteMapping("/veterinarios/{codigo}")
	public ResponseEntity<Void> eliminarVeterinario(@PathVariable Long codigo){
		veterinarioService.eliminarVeterinario(codigo);
		return ResponseEntity.noContent().build();
	}
}
