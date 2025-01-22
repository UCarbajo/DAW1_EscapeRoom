package com.bilboSKP.ranking;

import com.bilboSKP.centroEscolar.CentroEscolar;
import com.bilboSKP.centroEscolar.clase.Clase;

public class Ranking {

	private int iDRanking;
	private int puntuacion;
	private CentroEscolar centro;
	private Clase clase;
	private String nombreClase;
	
	
	public Ranking(int puntuacion, String nombreClase) {
		super();
		this.puntuacion = puntuacion;
		this.nombreClase = nombreClase;
	}

	public int getiDRanking() {
		return iDRanking;
	}
	public void setiDRanking(int iDRanking) {
		this.iDRanking = iDRanking;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public CentroEscolar getCentro() {
		return centro;
	}

	public void setCentro(CentroEscolar centro) {
		this.centro = centro;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	
	
}
