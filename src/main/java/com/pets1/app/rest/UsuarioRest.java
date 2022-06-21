package com.pets1.app.rest;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRest {

//	private static final String ENTITY_NAME="UsuarioVo";
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<UsuarioVo> listaUsuarios(){
		return usuarioService.listaUsuario();
	}
	
	@GetMapping("/usuarios/{codigo}")
	public ResponseEntity<Optional<UsuarioVo>> buscarUsuarioID(@PathVariable Long codigo){
		Optional<UsuarioVo> usuarioId = usuarioService.buscarId(codigo);
		
		return ResponseEntity.ok().body(usuarioId);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioVo usuarioVo)throws URISyntaxException{	
		Map<String,Object>response = new HashMap<>();
		if(usuarioVo.getDocumentoUs() == null) {
			response.put("error", "Tiene que mandar el documento del usuario");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		
		UsuarioVo miUsuario = usuarioService.guardar(usuarioVo);
		response.put("guardado con exito", miUsuario);
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{codigo}")
	public ResponseEntity<?> actualizarUsuario(@PathVariable Long codigo ,@RequestBody UsuarioVo usuarioVo)throws URISyntaxException{
		Optional<UsuarioVo> usuario = usuarioService.buscarId(codigo);
		Map<String,Object> response = new HashMap<>();
		
		if(usuario == null) {
			response.put("error", "el usuario no existe en la bd");
			return new ResponseEntity<Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		UsuarioVo miUsuarioVo = new UsuarioVo();
		miUsuarioVo.setDocumentoUs(usuarioVo.getDocumentoUs());
		miUsuarioVo.setNombreUs(usuarioVo.getNombreUs());
		miUsuarioVo.setApellidoUs(usuarioVo.getApellidoUs());
		miUsuarioVo.setTelefonoUs(usuarioVo.getTelefonoUs());
		miUsuarioVo.setCorreoUs(usuarioVo.getCorreoUs());
		miUsuarioVo.setPasswordUs(usuarioVo.getPasswordUs());
		miUsuarioVo.setRolUs(usuarioVo.getRolUs());
		
		miUsuarioVo = usuarioService.guardar(miUsuarioVo);
		response.put("actualizado con exito", miUsuarioVo);
		
		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/usuarios/{codigo}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable Long codigo){
		usuarioService.eliminarUsuario(codigo);
		return ResponseEntity.noContent().build();
	}
}
