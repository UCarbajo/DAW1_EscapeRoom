package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class APasilloFrame extends JPanel {

	private APrimeraPueba primeraPrueba;
	private BSalaDeImpresoraFrame salaImpresora;
	private CAula7 aula7;
	private JButton btnFlechaArriba;
	private JButton btnFlechaDerecha;
	private JButton btnFlechaIzquierda;

	public APasilloFrame(AEntradaJuego aEntradaJuego, Locale local) {

		setBounds(0, 0, 1280, 720);
		setLayout(null);

		ImageIcon imgFondo = ImageRescaler.scaleImage("/imagenes/PasilloA.jpeg", 1280, 720);
		
		if(aEntradaJuego.getJuegosCompletados()[2]==false) {
		btnFlechaArriba = new JButton("");
		btnFlechaArriba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				aula7 = new CAula7(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(aula7, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
			}
		});
		btnFlechaArriba.setIcon(ImageRescaler.scaleImage("/imagenes/FlechaArriba.png", 23, 50));
		btnFlechaArriba.setFocusPainted(false);
		btnFlechaArriba.setContentAreaFilled(false);
		btnFlechaArriba.setBorderPainted(false);
		btnFlechaArriba.setBorder(null);
		btnFlechaArriba.setBounds(527, 259, 89, 199);
		add(btnFlechaArriba);
		}

		if(aEntradaJuego.getJuegosCompletados()[0]==false) {
		btnFlechaDerecha = new JButton("");
		btnFlechaDerecha.setIcon(ImageRescaler.scaleImage("/imagenes/FlechaDerecha.png", 50, 23));
		btnFlechaDerecha.setBounds(1051, 259, 89, 199);
		btnFlechaDerecha.setBorderPainted(false);
		btnFlechaDerecha.setBorder(null);
		btnFlechaDerecha.setFocusPainted(false);
		btnFlechaDerecha.setContentAreaFilled(false);
		btnFlechaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	
				primeraPrueba = new APrimeraPueba(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(primeraPrueba, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
			}
		});
		add(btnFlechaDerecha);

		}
		
		if(aEntradaJuego.getJuegosCompletados()[1]==false) {
		btnFlechaIzquierda = new JButton("");
		btnFlechaIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				salaImpresora = new BSalaDeImpresoraFrame(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(salaImpresora, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
			}
		});
		btnFlechaIzquierda.setIcon(ImageRescaler.scaleImage("/imagenes/FlechaIzquierda.png", 50, 23));
		btnFlechaIzquierda.setBounds(245, 210, 89, 199);
		btnFlechaIzquierda.setBorderPainted(false);
		btnFlechaIzquierda.setBorder(null);
		btnFlechaIzquierda.setFocusPainted(false);
		btnFlechaIzquierda.setContentAreaFilled(false);
		add(btnFlechaIzquierda);
		}
		JLabel lblImagenFondon = new JLabel(imgFondo);
		lblImagenFondon.setBounds(0, 0, 1280, 720);
		add(lblImagenFondon);

		
	}
}
