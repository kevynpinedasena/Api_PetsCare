package com.pets1.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.VeterinarioVo;

@Repository
public interface IVeterinarioRepository extends JpaRepository<VeterinarioVo, Long>{
	
	public List<VeterinarioVo> findByclinicaNit(Long nitClinica);

	public Optional<VeterinarioVo> findByCorreo(String correo);
	
	public Optional<VeterinarioVo> findByNombreOrCorreo(String nombre, String correo);
	
	public Optional<VeterinarioVo> findByNombre(String nombre);
	
	public Boolean existsByNombre(String nombre);
	
	public Boolean existsByCorreo(String correo);
}