package com.bilboSKP.centroEscolar.clase;

import com.bilboSKP.centroEscolar.CentroEscolar;
import com.bilboSKP.partida.Partida;

public class Clase {

	private int idClase;
	private CentroEscolar centro;
	private Partida partida;
	
	public Clase(CentroEscolar centro, Partida partida) {
		super();
		this.centro = centro;
		this.partida = partida;
	}
	
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public CentroEscolar getCentro() {
		return centro;
	}
	public void setCentro(CentroEscolar centro) {
		this.centro = centro;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	
	
}
