package com.pets1.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.AgendaVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.domain.VeterinarioVo;
import com.pets1.app.dto.entityData.AgendaDto;
import com.pets1.app.exeptions.ResourseNotFoudExeption;
import com.pets1.app.repository.IAgendaRepository;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.repository.IVeterinarioRepository;
import com.pets1.app.service.IAgendaService;

@Service
@Transactional
public class AgendaServiceImpl implements IAgendaService{
	
	@Autowired 
	private IAgendaRepository agendaRepository;
	
	@Autowired 
	private IUsuarioRepository usuarioRepository;
	
	@Autowired
	private IVeterinarioRepository veterinarioRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AgendaDto CrearAgenda(Long documentoUsuario, Long documentoVeterinario, AgendaDto agendaDto) {
		UsuarioVo usuario = usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("usuario", "documento", documentoUsuario));
		VeterinarioVo veterinario = veterinarioRepository.findById(documentoVeterinario).orElseThrow(() -> new ResourseNotFoudExeption("Veterinario", "documento", documentoVeterinario));
		
		AgendaVo datosCita = mapearEntidad(agendaDto);
		
		datosCita.setDocumentous(usuario);
		datosCita.setDocumentovt(veterinario);	
		AgendaVo nuevaCita = agendaRepository.save(datosCita);
		
		return mapearDto(nuevaCita);
	}

	@Override
	public List<AgendaDto> listaAgendaUsuario(Long documentoUsuario) {
		usuarioRepository.findById(documentoUsuario).orElseThrow(() -> new ResourseNotFoudExeption("usuario", "documento", documentoUsuario));
		List<AgendaVo> agendaDeUsuario = agendaRepository.findByDocumentousDocumentoUs(documentoUsuario);
		return agendaDeUsuario.stream().map(agenda -> mapearDto(agenda)).collect(Collectors.toList());
	}

	@Override
	public List<AgendaDto> listaAgendaVeterinario(Long documentoVeterinario) {
		veterinarioRepository.findById(documentoVeterinario).orElseThrow(() -> new ResourseNotFoudExeption("Veterinario", "documento", documentoVeterinario));
		List<AgendaVo> agendaDeVeterinario = agendaRepository.findByDocumentovtDocumento(documentoVeterinario);
		return agendaDeVeterinario.stream().map(agenda -> mapearDto(agenda)).collect(Collectors.toList());
	}

	@Override
	public AgendaDto buscarAgendaId(Long codigo) {
		AgendaVo agenda = agendaRepository.findById(codigo).orElseThrow(() -> new ResourseNotFoudExeption("agenda", "codigo", codigo));
		return mapearDto(agenda);
	}

	@Override
	public AgendaDto actualizarAgenda(Long codigo, AgendaDto agendaDto) {
		AgendaVo agenda = agendaRepository.findById(codigo).orElseThrow(() -> new ResourseNotFoudExeption("agenda", "codigo", codigo));
		
		agenda.setFecha(agendaDto.getFecha());
		agenda.setHora(agendaDto.getHora());
		
		AgendaVo actualizarAgenda = agendaRepository.save(agenda);
		return mapearDto(actualizarAgenda);
	}

	@Override
	public void eliminarAgenda(Long codigo) {
		AgendaVo agenda = agendaRepository.findById(codigo).orElseThrow(() -> new ResourseNotFoudExeption("agenda", "codigo", codigo));
		agendaRepository.delete(agenda);
	}
	
	private AgendaDto mapearDto(AgendaVo agendaVo) {
		AgendaDto agendaDto = modelMapper.map(agendaVo, AgendaDto.class);
		return agendaDto;
	}
	
	private AgendaVo mapearEntidad(AgendaDto agendaDto) {
		AgendaVo agendaVo = modelMapper.map(agendaDto, AgendaVo.class);
		return agendaVo;
	}
	
}
