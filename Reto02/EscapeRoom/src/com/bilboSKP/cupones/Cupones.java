package com.bilboSKP.cupones;

import java.time.LocalDate;

import com.bilboSKP.centroEscolar.centroEscolar;

public class Cupones {

	private LocalDate fechaActivacion = new LocalDate();
	private LocalDate fechaCaducidad;
	private String estado;
	private String centroID;
	
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
	public void setCentroID(centroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	
	
}
