package com.bilboSKP.ranking;

import com.bilboSKP.centroEscolar.CentroEscolar;
import com.bilboSKP.centroEscolar.clase.Clase;

public class Ranking {

	private int iDRanking;
	private int puntuacion;
	private CentroEscolar centro;
	private Clase clase;
	
	
	
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
