package com.pets1.app.seguridad;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.RolVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.repository.IUsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsOrCorreoUs) throws UsernameNotFoundException {
		UsuarioVo usuario=usuarioRepository.findByNombreUsOrCorreoUs(nombreUsOrCorreoUs, nombreUsOrCorreoUs)
				.orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado con este nombre o correo:"+ nombreUsOrCorreoUs));
		
		return new User(usuario.getCorreoUs(), usuario.getPasswordUs(), mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<RolVo> roles){		
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}
	
	
}
