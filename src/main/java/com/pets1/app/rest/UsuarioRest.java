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

import com.pets1.app.dto.answers.UsuarioAnswerDto;
import com.pets1.app.dto.entityData.UsuarioDto;
import com.pets1.app.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRest {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public List<UsuarioAnswerDto> listaDeUsuarios(){
		return usuarioService.obtenerTodosLosUsuarios();
	}

	@GetMapping("/usuarios/{documento}")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorDocumento(@PathVariable Long documento){
		return ResponseEntity.ok(usuarioService.buscarUsuarioPorDocumento(documento));
	}
	
	@GetMapping("/usuarios/{documento}/mascotas")
	public ResponseEntity<UsuarioAnswerDto> buuscarUsuarioConMascotas(@PathVariable Long documento){
		return new ResponseEntity<>(usuarioService.buscarUsuarioConMascotas(documento), HttpStatus.OK);
	}

	@PostMapping("/usuarios")	
	public ResponseEntity<UsuarioDto> guardarUsuario(@RequestBody UsuarioDto usuarioDto){	
		return new ResponseEntity<>(usuarioService.guardarUsuario(usuarioDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{documento}")
	public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable Long documento ,@RequestBody UsuarioDto usuarioDto){
		UsuarioDto respuestaActualizacion = usuarioService.actualizarUsuario(usuarioDto, documento);
		return new ResponseEntity<>(respuestaActualizacion, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios/{documento}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable Long documento){
		usuarioService.eliminarUsuario(documento);
		return new ResponseEntity<String>("Usuario eliminado con exito", HttpStatus.OK);
	}
	
}
