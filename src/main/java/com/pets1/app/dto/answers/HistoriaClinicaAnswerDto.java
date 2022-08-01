package com.pets1.app.dto.answers;

import com.pets1.app.dto.entityData.MascotaDto;

public class HistoriaClinicaAnswerDto {
	
	private Long codigo;
	
	private String fecha;
	
	private String motivoConsulta;
	
	private MascotaDto mascotaCod;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public MascotaDto getMascotaCod() {
		return mascotaCod;
	}

	public void setMascotaCod(MascotaDto mascotaCod) {
		this.mascotaCod = mascotaCod;
	}
	
}
