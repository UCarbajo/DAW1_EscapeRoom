package com.bilboSKP.cupones;

import java.sql.Date;
import java.time.LocalDate;

import com.bilboSKP.centroEscolar.CentroEscolar;

public class Cupones {

	private LocalDate fechaActivacion = LocalDate.now();
	private LocalDate fechaCaducidad = fechaActivacion.plusYears(1);
	private String estado = "disponible";
	private CentroEscolar centro;
	
	public Cupones(CentroEscolar centro) {
		super();
		this.centro = centro;
	}
	public LocalDate getFechaActivacion() {
		return fechaActivacion;
	}
	public Date getFechaActivacionToDate() {
		return Date.valueOf(fechaActivacion);
	}
	public void setFechaActivacion(LocalDate fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public Date getFechaCaducidadToDate() {
		return Date.valueOf(fechaCaducidad);
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
	public CentroEscolar getCentro() {
		return centro;
	}
	public void setCentro(CentroEscolar centro) {
		this.centro = centro;
	}
	
}
