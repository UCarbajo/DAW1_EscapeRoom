package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.Insets;

public class EntradaJuego extends JFrame {

	private JPanel contentPane;

	public EntradaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon icon = new ImageIcon("entradaCole.jpeg");

		// Aplicar borde redondeado
		int borderRadius = 20; // Radio de las esquinas redondeadas
		
		JTextPane txtpnenEstaEscuela = new JTextPane();
		txtpnenEstaEscuela.setEditable(false);
		txtpnenEstaEscuela.setText("\"En esta escuela, un estudiante llamado Juan sufrió en silencio. Sus huellas aún están aquí, esperando que alguien escuche su historia. Sigue las pistas para entender lo que ocurrió y cómo evitar que se repita.\"");
		txtpnenEstaEscuela.setBounds(405, 363, 521, 142);
		contentPane.add(txtpnenEstaEscuela);
		
				// Fondo blanco con algo de opacidad (semitransparente)
				txtpnenEstaEscuela.setOpaque(true);
				txtpnenEstaEscuela.setBackground(new Color(255, 255, 255, 180)); // Blanco con opacidad (RGBA)
				txtpnenEstaEscuela.setForeground(Color.BLACK); // Color del texto
				txtpnenEstaEscuela.setFont(new Font("Arial", Font.PLAIN, 20));
				// Establecer un borde de color negro y grosor de 2px
				txtpnenEstaEscuela.setBorder(new LineBorder(Color.BLACK, 2) {
					@Override
					public Insets getBorderInsets(java.awt.Component c) {
						return new Insets(borderRadius, borderRadius, borderRadius, borderRadius); // Espaciado de borde
					}
				});

		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(new ImageIcon("imagenes/entradaCole.jpeg"));
		lblEntradaCole.setBounds(0, 0, 1280, 692);
		contentPane.add(lblEntradaCole);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);

		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
	}
}

