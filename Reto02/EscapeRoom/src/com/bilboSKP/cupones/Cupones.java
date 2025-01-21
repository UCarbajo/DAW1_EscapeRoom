package com.bilboSKP.cupones;

import java.time.LocalDate;

import com.bilboSKP.centroEscolar.centroEscolar;

public class Cupones {

	private LocalDate fechaActivacion, fechaCaducidad;
	private String estado;
	private String centroID;
	
	public Cupones(LocalDate fechaActivacion, LocalDate fechaCaducidad, String estado) {
		super();
		this.fechaActivacion = fechaActivacion;
		this.fechaCaducidad = fechaCaducidad;
		this.estado = estado;
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
	public void setCentroID(centroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	
	
}
