package com.pets1.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pets1.app.domain.VeterinarioVo;

@Repository
public interface IVeterinarioRepository extends JpaRepository<VeterinarioVo, Long>{
	
	public List<VeterinarioVo> findByclinicaNit(Long nitClinica);
}
