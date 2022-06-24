package com.pets1.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pets1.app.domain.MascotaVo;
import com.pets1.app.domain.UsuarioVo;
import com.pets1.app.repository.IMascotaRepository;
import com.pets1.app.repository.IUsuarioRepository;
import com.pets1.app.service.IUsuarioService;
import com.pets1.app.service.dto.DatosContraseñaCorreoDto;
import com.pets1.app.service.dto.DatosUsuariosMascotasDto;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IMascotaRepository mascotaRepository;

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public UsuarioVo guardar(UsuarioVo usuarioVo) {
		
		return usuarioRepository.save(usuarioVo);
	}

	@Override
	public List<UsuarioVo> listaUsuario() {
		List<UsuarioVo> listaUsuario = usuarioRepository.findAll();
		return listaUsuario;
	}

	@Override
	public Optional<UsuarioVo> buscarId(Long documento) {
		Optional<UsuarioVo> buscarUsuarioId = usuarioRepository.findById(documento);
		
		buscarUsuarioId.get().setListaMascotas(listaMascotas(documento));
		
		return buscarUsuarioId;
	}

	@Override
	public void eliminarUsuario(Long documento) {
		
		Query q = entityManager.createQuery("SELECT m.codigo FROM MascotaVo m WHERE m.documentoUs =:documento")
				.setParameter("documento", documento);
		
		List<Long> mascotas = q.getResultList();
		
		for (Long datos : mascotas) {
			Query m = entityManager.createQuery("DELETE FROM MascotaVo m WHERE m.codigo =:codigo")
					.setParameter("codigo", datos);
			m.executeUpdate();
		}
		
		usuarioRepository.deleteById(documento);
	}

	@Override
	@Transactional
	public DatosContraseñaCorreoDto usuarioPorNombre(String nombre) {
		
		DatosContraseñaCorreoDto miUsuarioDto = new DatosContraseñaCorreoDto();
		
		List<String[]> usuario = usuarioRepository.usuarioPorNombre(nombre);
		
		for (String[] datos : usuario) {
			miUsuarioDto.setCorreoUs(datos[0].toString());
			miUsuarioDto.setPasswordUs(datos[1].toString());
		}
		return miUsuarioDto;
	}

	@Override
	public DatosUsuariosMascotasDto usuarioMascota(Long documento) {
		
		DatosUsuariosMascotasDto mascotaUsuarioDto = new DatosUsuariosMascotasDto();
		
		List<String[]> masUsu = usuarioRepository.usuarioMascota(documento);
		
		for (String[] datos : masUsu) {
			mascotaUsuarioDto.setNombreUs(datos[0].toString());
			mascotaUsuarioDto.setCorreoUs(datos[1].toString());
			mascotaUsuarioDto.setTelefonoUs(datos[2].toString());
			mascotaUsuarioDto.setNombreMasc(datos[3].toString());
			mascotaUsuarioDto.setRazaMasc(datos[4].toString());
			mascotaUsuarioDto.setTipoMasc(datos[5].toString());
		}
		
		return mascotaUsuarioDto;
	}
	
	
	private List<MascotaVo> listaMascotas(Long documento){
		
		List<MascotaVo> listaMas = usuarioRepository.listaMascotas(documento);
				
		return listaMas;
	}
}
