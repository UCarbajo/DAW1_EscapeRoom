package com.bilboSKP.suscripcion;

import java.time.LocalDate;

import com.bilboSKP.centroEscolar.centroEscolar;

public class Suscripcion {

	private int iDSuscripcion;
	private boolean estado = false;
	private LocalDate fechaActivacion;
	private String centroID;
	
	public Suscripcion(int iDSuscripcion, boolean estado, LocalDate fechaActivacion) {
		super();
		this.iDSuscripcion = iDSuscripcion;
		this.estado = estado;
		this.fechaActivacion = fechaActivacion;
	}
	public int getiDSuscripcion() {
		return iDSuscripcion;
	}
	public void setiDSuscripcion(int iDSuscripcion) {
		this.iDSuscripcion = iDSuscripcion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public LocalDate getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(LocalDate fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getCentroID() {
		return centroID;
	}
	public void setCentroID(centroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	
}
