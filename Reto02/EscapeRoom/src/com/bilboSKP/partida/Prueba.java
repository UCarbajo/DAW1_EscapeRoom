package com.bilboSKP.partida;

import java.util.ArrayList;

public class Prueba {

	private String idPrueba;
	private int puntuacion = 250;
	private String enunciado;
	private ArrayList<Pista> listaPistas;
	
	private ArrayList<Pista> getPistas(Prueba prueba) {
		ArrayList<Pista> listaPistas = new ArrayList<Pista>();
		// TODO Conectar BD, obtener las pistas y devuelve un array con pistas.
		
		return listaPistas;
	}

	public String getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(String idPrueba) {
		this.idPrueba = idPrueba;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public ArrayList<Pista> getListaPistas() {
		return listaPistas;
	}

	public void setListaPistas(ArrayList<Pista> listaPistas) {
		this.listaPistas = listaPistas;
	}
	
	
}
