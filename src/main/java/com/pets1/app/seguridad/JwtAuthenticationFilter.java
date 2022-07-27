package com.pets1.app.seguridad;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.repository.IClinicaRepository;
import com.pets1.app.repository.IUsuarioRepository;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Autowired 
	private IClinicaRepository clinicaRepository;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomClinicaDetailsService customClinicaDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		//token de la solicitud http
		String token = obtenerJwtDeSolicitud(request);
		
		//validacion del token
		if(StringUtils.hasText(token) && jwtTokenProvider.validarToken(token)) {
			
			//user name del usuario
			String userName = jwtTokenProvider.obtenerUserNameDelJwt(token);
			String tipoUsuario = validarCorreoUs(userName);
			
			if (tipoUsuario.equalsIgnoreCase("usuario")) {
				//se carga el usuario asociado al token 
				UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//establecemos la seguridad
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			else if (tipoUsuario.equalsIgnoreCase("clinica")) {
				//se carga el usuario asociado al token 
				UserDetails userDetails = customClinicaDetailsService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				//establecemos la seguridad
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
			
		}
		filterChain.doFilter(request, response);
	}
	
	//validar token de acceso
	private String obtenerJwtDeSolicitud(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if( StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer") ) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
	
	private String validarCorreoUs(String userName) {
		
		boolean usu = usuarioRepository.findByCorreoUs(userName).isPresent();
		boolean clinica = clinicaRepository.findByCorreoCv(userName).isPresent();
		
		String tipoUsuario = null;
		
		if (usu == true) {
			tipoUsuario = "usuario";
		}
		else if (clinica == true){
			tipoUsuario = "clinica";
		}
		System.out.println("valido");
		return tipoUsuario;
	}
	
}
