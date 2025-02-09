package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class APrimeraPueba extends JPanel {

	public APrimeraPueba(AEntradaJuego aEntradaJuego, Locale local) {
		repaint();
		revalidate();
		
		setBounds(0, 0, 1280, 720);
		setLayout(null);

		ImageIcon icono = new ImageIcon("imagenes/imgJuego1.jpeg");
		Image img = icono.getImage();
		Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imgEscalado);

		JTextPane txtpizarra = new JTextPane();
		txtpizarra.setText("Las palabras duelen más de lo que crees.");
		txtpizarra.setEditable(false);
		txtpizarra.setBounds(176, 327, 207, 20);
		add(txtpizarra);

		txtpizarra.setOpaque(false);

		JButton btnPizarra = new JButton("");
		btnPizarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SopaDeLetras ventana = new SopaDeLetras();
				ventana.setVisible(true);
			}
		});
		btnPizarra.setBounds(137, 278, 346, 137);
		add(btnPizarra);
		btnPizarra.setOpaque(false);
		btnPizarra.setContentAreaFilled(false);
		btnPizarra.setBorder(null);
		btnPizarra.setFocusPainted(false);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(iconoEscalado);
		lblNewLabel.setBounds(0, 0, 1280, 720);
		add(lblNewLabel);
		
		repaint();
		revalidate();

	}
}
