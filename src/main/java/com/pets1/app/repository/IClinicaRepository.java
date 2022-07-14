package com.pets1.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.ClinicaVo;

@Repository
public interface IClinicaRepository extends JpaRepository<ClinicaVo, Long>{
	
//	@Query(value = "SELECT * FROM clinica_veterinaria WHERE nombre_cv=:nombre", nativeQuery = true )
//	List<ClinicaVo> clinicaNombre(@Param("nombre") String nombre );
	
}
