package com.bilboSKP.centroEscolar;

import java.util.ArrayList;

import com.bilboSKP.cupones.Cupones;
import com.bilboSKP.suscripcion.Suscripcion;

public class centroEscolar {

	private String cif, userName, passWord, nombre, direccion;
	private int tlf, numAlumnos;
	private Suscripcion suscripcion;
	private ArrayList<Cupones> listaCupones;
	
	public centroEscolar(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	public centroEscolar(String cif, String userName, String passWord, String nombre, String direccion, int tlf,
			int numAlumnos, Suscripcion suscripcion, ArrayList<Cupones> listaCupones) {
		super();
		this.cif = cif;
		this.userName = userName;
		this.passWord = passWord;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tlf = tlf;
		this.numAlumnos = numAlumnos;
		this.suscripcion = suscripcion;
		this.listaCupones = listaCupones;
	}


	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTlf() {
		return tlf;
	}
	public void setTlf(int tlf) {
		this.tlf = tlf;
	}
	public int getNumAlumnos() {
		return numAlumnos;
	}
	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}
	public Suscripcion getSuscripcion() {
		return suscripcion;
	}
	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}
	public ArrayList<Cupones> getListaCupones() {
		return listaCupones;
	}
	public void setListaCupones(ArrayList<Cupones> listaCupones) {
		this.listaCupones = listaCupones;
	}
	
	
}
