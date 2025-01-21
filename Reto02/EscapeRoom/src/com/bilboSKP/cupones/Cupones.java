package com.bilboSKP.cupones;

import java.time.LocalDate;

import com.bilboSKP.centroEscolar.centroEscolar;

public class Cupones {

	private LocalDate fechaActivacion = LocalDate.now();
	private LocalDate fechaCaducidad = fechaActivacion.plusYears(1);
	private String estado = "disponible";
	private String centroID;
	
	public Cupones(centroEscolar centro) {
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
	public void setCentroID(centroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	
	
}
