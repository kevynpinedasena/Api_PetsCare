package com.pets1.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.HistoriaClinicaVo;

@Repository
public interface IHistoriaClinicaRepository extends JpaRepository<HistoriaClinicaVo, Long>{
	
	public List<HistoriaClinicaVo> findByMascotaCodCodigo(Long CodigoMascota);

}
