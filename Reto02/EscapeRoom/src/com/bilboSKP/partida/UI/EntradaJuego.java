package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class EntradaJuego extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnenEstaEscuela;
	private JTextArea txtIntroduccion;
	
	public EntradaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIntroduccion = new JTextArea();
		txtIntroduccion.setText("En esta escuela, un estudiante llamado Juan sufrió en silencio. Sus huellas aún están aquí, esperando que alguien escuche su historia. Sigue las pistas para entender lo que ocurrió y cómo evitar que se repita.\"");
		txtIntroduccion.setBounds(373, 149, 393, 389);
		txtIntroduccion.setForeground(Color.BLACK);
		txtIntroduccion.setBackground(new Color(0, 0, 0, 0));
		txtIntroduccion.setOpaque(true);
		contentPane.add(txtIntroduccion);
		
		txtpnenEstaEscuela = new JTextPane();
		txtpnenEstaEscuela.setEditable(false);
		txtpnenEstaEscuela.setBounds(0, 0, 1264, 681);
		txtpnenEstaEscuela.setBackground(new Color(255, 255, 255, 180)); // Blanco con opacidad (RGBA)
		txtpnenEstaEscuela.setOpaque(true);
		contentPane.add(txtpnenEstaEscuela);

		ImageIcon icon = new ImageIcon("imagenes/entradaCole.jpeg");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(scaledIcon);
		lblEntradaCole.setBounds(0, 0, 1280, 692);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);
		contentPane.add(lblEntradaCole);
	}
}
