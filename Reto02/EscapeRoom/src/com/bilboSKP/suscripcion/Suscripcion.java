<<<<<<< HEAD
package com.bilboSKP.suscripcion;

import java.time.LocalDate;
import com.bilboSKP.centroEscolar.centroEscolar;

public class Suscripcion {

	private int iDSuscripcion;
	private boolean estado = false;
	private LocalDate fechaActivacion = LocalDate.now();
	private String centroID;
	
	public Suscripcion(centroEscolar centro) {
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
	public void setCentroID(centroEscolar centroID) {
		this.centroID = centroID.getCif();
	}
	public void setCentroID(String centroID) {
		this.centroID = centroID;
	}
	
}
=======
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
>>>>>>> aa7fccbd6005ef566e0da8d9027c460837b8e2c6
