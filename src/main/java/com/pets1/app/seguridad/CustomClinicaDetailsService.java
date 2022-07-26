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
import com.pets1.app.domain.ClinicaVo;
import com.pets1.app.repository.IClinicaRepository;

@Service
public class CustomClinicaDetailsService implements UserDetailsService{
	
	@Autowired
	private IClinicaRepository clinicaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(Set<RolVo> roles){		
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}


}
