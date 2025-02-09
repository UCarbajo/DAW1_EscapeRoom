package com.bilboSKP.partida.UI;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

public class BSalaDeImpresoraFrame extends JPanel {

	private final int tamanoFrameX = 1280;
	private final int tamanoFrameY = 720;
	private BSegundaPruebaFrame segundaPrueba;
	private APasilloFrame pasilloFrame;
	private JButton btnFlechaAbajo;
	private JButton btnAccesoPrueba;
	
	public BSalaDeImpresoraFrame(AEntradaJuego aEntradaJuego, Locale local) {
		
		setBounds(0, 0, tamanoFrameX, tamanoFrameY);
		setLayout(null);
		
		ImageIcon imgFondo = ImageRescaler.scaleImage("/imagenes/SalaImpresora.jpeg", tamanoFrameX, tamanoFrameY);
		
		
		btnAccesoPrueba = new JButton("");
		btnAccesoPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				segundaPrueba = new BSegundaPruebaFrame(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(segundaPrueba, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
			}
		});
		btnAccesoPrueba.setBounds(896, 434, 116, 138);
		btnAccesoPrueba.setBackground(null);
		btnAccesoPrueba.setFocusPainted(false);
		btnAccesoPrueba.setContentAreaFilled(false);
		btnAccesoPrueba.setBorder(null);
		add(btnAccesoPrueba);
		
		btnFlechaAbajo = new JButton("");
		btnFlechaAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				pasilloFrame = new APasilloFrame(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(pasilloFrame, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
			}
		});
		btnFlechaAbajo.setIcon(ImageRescaler.scaleImage("/imagenes/FlechaAbajo.png", 183, 98));
		btnFlechaAbajo.setBounds(551, 609, 183, 98);
		btnFlechaAbajo.setContentAreaFilled(false);
		btnFlechaAbajo.setFocusPainted(false);
		btnFlechaAbajo.setBorder(null);
		add(btnFlechaAbajo);
		
		JLabel lblImagenFondon = new JLabel(imgFondo);
		lblImagenFondon.setBounds(0, 0, tamanoFrameX, tamanoFrameY);
		add(lblImagenFondon);
		
	}
}
