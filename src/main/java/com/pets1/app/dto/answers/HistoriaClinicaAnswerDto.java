package com.pets1.app.dto.answers;


public class HistoriaClinicaAnswerDto {
	
	private Long codigo;
	
	private String fecha;
	
	private String motivoConsulta;
	
	private MascotaAswerDto mascotaCod;

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

	public MascotaAswerDto getMascotaCod() {
		return mascotaCod;
	}

	public void setMascotaCod(MascotaAswerDto mascotaCod) {
		this.mascotaCod = mascotaCod;
	}
	
}
