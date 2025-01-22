<<<<<<< HEAD
package com.bilboSKP.partida;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.bilboSKP.centroEscolar.centroEscolar;
import com.bilboSKP.partida.pruebas.Prueba;

public class Partida {

	Random rand = new Random();
	
	private String idPartida;
	private int puntuacion = 0;
	private int monedas = 5;
	private int codAcceso = rand.nextInt(500);
	private Date fechaActivacion;
	private String centroID;
	private ArrayList<Prueba> listaPruebas = getPruebas();
	
	public Partida(Date fechaActivacion, centroEscolar centro) {
		super();
		this.fechaActivacion = fechaActivacion;
		this.centroID = centro.getCif();
	}
	
	public void Jugar() {
		// TODO En esta parte del codigo tiene que estar el codigo de jugar una
		// partida. Es decir, abrir la ventana de la primera prueba.
		
		// Empieza un temporizador de 60minutos.
		try {
			Thread.sleep(1000 * 60 * 60);
			// your code here...
		} catch (InterruptedException ie) {

		}
	}
	
	private ArrayList<Prueba> getPruebas() {
		ArrayList<Prueba> listaPruebas = new ArrayList<Prueba>();
		// TODO Conexion a la BD, obtenemos las pruebas y creamos una lista.
		
		// Devolvemos el arraylist.
		return listaPruebas ;
	}
	
	public String getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	public int getCodAcceso() {
		return codAcceso;
	}
	public void setCodAcceso(int codAcceso) {
		this.codAcceso = codAcceso;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getCentroID() {
		return centroID;
	}
	public void setCentroID(String centroID) {
		this.centroID = centroID;
	}

	public ArrayList<Prueba> getListaPruebas() {
		return listaPruebas;
	}

	public void setListaPruebas(ArrayList<Prueba> listaPruebas) {
		this.listaPruebas = listaPruebas;
	}

	
	
	
=======
package com.bilboSKP.partida;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.bilboSKP.centroEscolar.CentroEscolar;

public class Partida {

	Random rand = new Random();
	
	private String idPartida;
	private int puntuacion = 0;
	private int monedas = 5;
	private int codAcceso = rand.nextInt(500);
	private Date fechaActivacion;
	private boolean fechaDesactivacion = fechaActivacion.after(fechaActivacion);
	private String centroID;
	private ArrayList<Prueba> listaPruebas = getPruebas();
	
	public Partida(Date fechaActivacion, CentroEscolar centro) {
		super();
		this.fechaActivacion = fechaActivacion;
		this.centroID = centro.getCif();
	}
	
	public void Jugar() {
		// TODO En esta parte del codigo tiene que estar el codigo de jugar una
		// partida. Es decir, abrir la ventana de la primera prueba.
		
		// Empieza un temporizador de 60minutos.
		try {
			Thread.sleep(1000 * 60 * 60);
			// your code here...
		} catch (InterruptedException ie) {

		}
	}
	
	private ArrayList<Prueba> getPruebas() {
		ArrayList<Prueba> listaPruebas = new ArrayList<Prueba>();
		// TODO Conexion a la BD, obtenemos las pruebas y creamos una lista.
		
		// Devolvemos el arraylist.
		return listaPruebas ;
	}
	
	public String getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(String idPartida) {
		this.idPartida = idPartida;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public int getMonedas() {
		return monedas;
	}
	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}
	public int getCodAcceso() {
		return codAcceso;
	}
	public void setCodAcceso(int codAcceso) {
		this.codAcceso = codAcceso;
	}
	public Date getFechaActivacion() {
		return fechaActivacion;
	}
	public void setFechaActivacion(Date fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public String getCentroID() {
		return centroID;
	}
	public void setCentroID(String centroID) {
		this.centroID = centroID;
	}

	
	
	
>>>>>>> aa7fccbd6005ef566e0da8d9027c460837b8e2c6
}