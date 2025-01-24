package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollBar;

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
		
		JTextPane txtpnenEstaEscuela = new JTextPane();
		txtpnenEstaEscuela.setEditable(false);
		txtpnenEstaEscuela.setBackground(SystemColor.controlHighlight);
		txtpnenEstaEscuela.setText("\"En esta escuela, un estudiante llamado Juan sufri\u00F3 en silencio. Sus huellas a\u00FAn est\u00E1n aqu\u00ED, esperando que alguien escuche su historia. Sigue las pistas para entender lo que ocurri\u00F3 y c\u00F3mo evitar que se repita.\"");
		txtpnenEstaEscuela.setBounds(424, 363, 477, 126);
		contentPane.add(txtpnenEstaEscuela);
		txtpnenEstaEscuela.setOpaque(false);
		txtpnenEstaEscuela.setBackground(new Color(0, 0, 0, 150));
		txtpnenEstaEscuela.setForeground(Color.WHITE);
		txtpnenEstaEscuela.getFont();
		txtpnenEstaEscuela.setFont(new Font("Arial", Font.PLAIN, 20));
		
		/*JLabel lblTransparente = new JLabel("Hola");
		lblTransparente.setBounds(423, 367, 478, 126);
		lblTransparente.setBackground(new Color(100, 100, 100, 150)); 
		lblTransparente.setOpaque(true);
		lblTransparente.setForeground(Color.BLACK);*/
		
		JLabel lblFondoTransparente = new JLabel("hola");
		lblFondoTransparente.setBounds(419, 363, 482, 126);
		contentPane.add(lblFondoTransparente);
		
		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(new ImageIcon("imagenes/entradaCole.jpeg"));
		lblEntradaCole.setBounds(0, 0, 1280, 692);
		contentPane.add(lblEntradaCole);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);
		

		Image img = icon.getImage();

		Image scaledImg = img.getScaledInstance(1280,720 , Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImg);
	}
}
