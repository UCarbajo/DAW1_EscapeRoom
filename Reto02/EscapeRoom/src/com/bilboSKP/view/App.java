package com.bilboSKP.view;

import com.bilboSKP.UI.ComprarCupones;
import com.bilboSKP.centroEscolar.CentroEscolar;

public class App {

	public static void main(String[] args) {

		CentroEscolar centro = new CentroEscolar("CIF12345", // CIF
				"Centro Educativo ABC", // Nombre del centro
				"usuario123", // Nombre de usuario
				"contrase�a123", // Contrase�a
				"Calle Principal 123", 987654321, // Direcci�n
				250 // N�mero de alumnos
		// Tel�fono
		);
		ComprarCupones ventana = new ComprarCupones(centro);
		ventana.setVisible(true);
	}

}
