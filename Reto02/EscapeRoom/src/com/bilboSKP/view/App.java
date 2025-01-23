package com.bilboSKP.view;

import com.bilboSKP.UI.ComprarCupones;
import com.bilboSKP.centroEscolar.CentroEscolar;

public class App {

	public static void main(String[] args) {

		CentroEscolar centro = new CentroEscolar("CIF12345", // CIF
				"Centro Educativo ABC", // Nombre del centro
				"usuario123", // Nombre de usuario
				"contraseña123", // Contraseña
				"Calle Principal 123", 987654321, // Dirección
				250 // Número de alumnos
		// Teléfono
		);
		ComprarCupones ventana = new ComprarCupones(centro);
		ventana.setVisible(true);
	}

}
