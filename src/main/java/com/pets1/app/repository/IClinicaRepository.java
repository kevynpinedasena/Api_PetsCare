package com.pets1.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.ClinicaVo;

@Repository
public interface IClinicaRepository extends JpaRepository<ClinicaVo, Long>{
	
	@Query(value = "SELECT * FROM clinica_veterinaria WHERE nombre_cv=:nombre", nativeQuery = true )
	List<ClinicaVo> clinicaNombre(@Param("nombre") String nombre );
	
}
