package com.bilboSKP.suscripcion;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bilboSKP.centroEscolar.CentroEscolar;
import com.bilboSKP.partida.Prueba;

public class Suscripcion {

	private int iDSuscripcion;
	private boolean estado = false;
	private LocalDate fechaActivacion = LocalDate.now();
	private String centroID;
	
	public Suscripcion(CentroEscolar centro) {
		super();
		this.centroID = centro.getCif();
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
	public void setCentroID(CentroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	public void setCentroID(String centroID) {
		this.centroID = centroID;
	}
	
}
