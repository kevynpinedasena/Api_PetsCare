package com.pets1.app.config;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.pets1.app.seguridad.CustomClinicaDetailsService;
//import com.pets1.app.seguridad.JwtAutenticationEntryPoint;
////import com.pets1.app.seguridad.JwtAuthenticationClinicaFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityClinicaConfig extends WebSecurityConfigurerAdapter{

//	@Autowired
//	private CustomClinicaDetailsService clinicaDetailsService;
//	
//	@Autowired
//	private JwtAutenticationEntryPoint autenticationEntryPoint;
//	
//	@Bean
//	public JwtAuthenticationClinicaFilter authenticationClinicaFilter() {
//		return new JwtAuthenticationClinicaFilter();
//	}
//	
//	@Bean("passwordEncoder2")
//	PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//		.exceptionHandling()
//		.authenticationEntryPoint(autenticationEntryPoint)
//		.and()
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").permitAll()
////		.antMatchers("/api/auth/**").permitAll()
////		.antMatchers(HttpMethod.POST ,"/api/usuarios/**").permitAll()
//		.anyRequest()
//		.authenticated();
//		http.addFilterBefore(authenticationClinicaFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(clinicaDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//	@Override
//	@Bean("authenticationManager2")
//	protected AuthenticationManager authenticationManager() throws Exception {
//		return super.authenticationManager();
//	}
//}
