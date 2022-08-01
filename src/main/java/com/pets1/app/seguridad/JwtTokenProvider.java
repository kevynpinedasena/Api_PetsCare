package com.pets1.app.seguridad;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.pets1.app.exeptions.AppPetsCareExeption;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

//aqui se genera el token se generan los clains y se valida el token
@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt-secret}")
	private String jwtSecret;
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;
	
	public String generarToken(Authentication authentication) {
		String userName = authentication.getName();
		Date fechaActual = new Date();
		Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);
		
		String token = Jwts.builder().setSubject(userName).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		
		return token;
	}
	
	public String obtenerUserNameDelJwt(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();		
	}
	
	public boolean validarToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} 
		catch (SignatureException ex) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "la firma del jwt no es valida");
		}
		catch (MalformedJwtException ex) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "token jwt no valido");
		}
		catch (ExpiredJwtException ex) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "el token jwt a caducado");
		}
		catch (UnsupportedJwtException ex) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "el token jwt no es valido");
		}
		catch (IllegalArgumentException ex) {
			throw new AppPetsCareExeption(HttpStatus.BAD_REQUEST, "las cadena claims estan vacias");
		}
	}
}