package com.pets1.app.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.ClinicaVo;

@Repository
public interface IClinicaRepository extends JpaRepository<ClinicaVo, Long>{
	
//	@Query(value = "SELECT * FROM clinica_veterinaria WHERE nombre_cv=:nombre", nativeQuery = true )
//	List<ClinicaVo> clinicaNombre(@Param("nombre") String nombre );
	
	public Optional<ClinicaVo> findByCorreoCv(String correoCv);
	
	public Optional<ClinicaVo> findByNombreOrCorreoCv(String nombre, String correoCv);
	
	public Optional<ClinicaVo> findByNombre(String nombre);
	
	public Boolean existsByNombre(String nombre);
	
	public Boolean existsByCorreoCv(String correoCv);
	
}
