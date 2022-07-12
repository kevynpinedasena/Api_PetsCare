package com.pets1.app.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pets1.app.repository.IClinicaRepository;


@Service
@Transactional
public class ClinicaServiceImpl {

	@Autowired
	private IClinicaRepository clinicaRepository;


}
