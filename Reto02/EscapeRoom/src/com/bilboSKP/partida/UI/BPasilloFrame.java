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
import java.awt.event.ActionEvent;

public class BPasilloFrame extends JFrame {

	private JPanel contentPane;

	public BPasilloFrame() {
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

		JButton btnFlechaIzquierda = new JButton("");
		btnFlechaIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BSalaDeImpresoraFrame ventana = new BSalaDeImpresoraFrame();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnFlechaIzquierda.setIcon(new ImageIcon("imagenes/FlechaIzquierda.png"));
		btnFlechaIzquierda.setBounds(245, 210, 89, 199);
		btnFlechaIzquierda.setBorderPainted(false);
		btnFlechaIzquierda.setBorder(null);
		btnFlechaIzquierda.setFocusPainted(false);
		btnFlechaIzquierda.setContentAreaFilled(false);
		contentPane.add(btnFlechaIzquierda);

		JLabel lblImagenFondon = new JLabel(scaledIcon);
		lblImagenFondon.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondon);
	}
}
