package com.pets1.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.MascotaVo;

@Repository
public interface IMascotaRepository extends JpaRepository<MascotaVo, Long>{
	
	public List<MascotaVo> findByDueniomascotaDocumentoUs(Long usuarioDocumento);

}