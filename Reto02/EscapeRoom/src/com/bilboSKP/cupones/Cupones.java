package com.bilboSKP.cupones;

import java.time.LocalDate;

import com.bilboSKP.centroEscolar.CentroEscolar;

public class Cupones {

	private LocalDate fechaActivacion = LocalDate.now();
	private LocalDate fechaCaducidad = fechaActivacion.plusYears(1);
	private String estado = "disponible";
	private String centroID;
	
	public Cupones(CentroEscolar centro) {
		super();
		this.centroID = centro.getCif();
	}
	
	public LocalDate getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(LocalDate fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCentroID() {
		return centroID;
	}
	public void setCentroID(CentroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	
	
}
