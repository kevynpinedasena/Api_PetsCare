package com.pets1.app.rest;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pets1.app.domain.RolVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.dto.entityData.LoginDto;
import com.pets1.app.dto.entityData.UsuarioDto;
import com.pets1.app.repository.IRolRepository;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.seguridad.JwtAuthResponceDto;
import com.pets1.app.seguridad.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthControlador {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IRolRepository rolRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
		
	@PostMapping("/iniciarSecion")
	public ResponseEntity<JwtAuthResponceDto> authenticateUser(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getNombreoCorreo(), loginDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//obtener el token de jwtProvider
		String token = tokenProvider.generarToken(authentication);
		
		return ResponseEntity.ok(new JwtAuthResponceDto(token));
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarUsuario(@RequestBody UsuarioDto usuarioDTO){
//		if(usuarioRepository.existsByNombreUs(usuarioDTO.getNombreUs())) {
//			return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
//		}
//		else if(usuarioRepository.existsByCorreoUs(usuarioDTO.getCorreoUs())) {
//			return new ResponseEntity<>("Ya existe un usuario con este email", HttpStatus.BAD_REQUEST);
//		}
		
//		UsuarioVo usuario = new UsuarioVo();
//		
//		usuario.setDocumentoUs(usuarioDTO.getDocumentoUs());
//		usuario.setNombreUs(usuarioDTO.getNombreUs());
//		usuario.setApellidoUs(usuarioDTO.getApellidoUs());
//		usuario.setSexoUs(usuarioDTO.getSexoUs());
//		usuario.setTelefonoUs(usuarioDTO.getTelefonoUs());
//		usuario.setCorreoUs(usuarioDTO.getCorreoUs());
//		usuario.setPasswordUs(passwordEncoder.encode(usuarioDTO.getPasswordUs()));
//		usuario.setImagenUsu(usuarioDTO.getImagenUsu());
//		
//		RolVo roles = rolRepository.findByNombre("ROLE_USER").get();
//		usuario.setRoles(Collections.singleton(roles));
//		
//		usuarioRepository.save(usuario);
		
		
		
		return new ResponseEntity<>("Usuario registrado con exito", HttpStatus.OK);
	}
	
}
