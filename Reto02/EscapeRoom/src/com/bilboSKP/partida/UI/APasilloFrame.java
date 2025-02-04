package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class APasilloFrame extends JFrame {

	private JPanel contentPane;

	public APasilloFrame(Locale local) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon = new ImageIcon("imagenes/PasilloA.jpeg");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		JButton btnFlechaDerecha = new JButton("");
		btnFlechaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				APrimeraPueba ventana = new APrimeraPueba();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnFlechaDerecha.setIcon(new ImageIcon("imagenes/FlechaDerecha.png"));
		btnFlechaDerecha.setBounds(1051, 259, 89, 199);
		btnFlechaDerecha.setBorderPainted(false);
		btnFlechaDerecha.setBorder(null);
		btnFlechaDerecha.setFocusPainted(false);
		btnFlechaDerecha.setContentAreaFilled(false);
		contentPane.add(btnFlechaDerecha);

		JLabel lblImagenFondon = new JLabel(scaledIcon);
		lblImagenFondon.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondon);
	}
}
