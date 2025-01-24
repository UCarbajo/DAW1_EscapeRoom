package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BSalaDeImpresoraFrame extends JFrame {

	private JPanel contentPane;
	
	public BSalaDeImpresoraFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("imagenes/SalaImpresora.jpeg");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		contentPane.setLayout(null);
		
		JButton btnAccesoPrueba = new JButton("");
		btnAccesoPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BSegundaPruebaFrame ventana = new BSegundaPruebaFrame();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnAccesoPrueba.setBounds(896, 434, 116, 138);
		btnAccesoPrueba.setBackground(null);
		btnAccesoPrueba.setFocusPainted(false);
		btnAccesoPrueba.setContentAreaFilled(false);
		btnAccesoPrueba.setBorder(null);
		contentPane.add(btnAccesoPrueba);
		
		JButton btnFlechaAbajo = new JButton("");
		btnFlechaAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BPasilloFrame ventana = new BPasilloFrame();
				ventana.setVisible(true);
				dispose();
			}
		});
		btnFlechaAbajo.setIcon(new ImageIcon("imagenes/FlechaAbajo.png"));
		btnFlechaAbajo.setBounds(551, 609, 183, 98);
		btnFlechaAbajo.setContentAreaFilled(false);
		btnFlechaAbajo.setFocusPainted(false);
		btnFlechaAbajo.setBorder(null);
		contentPane.add(btnFlechaAbajo);
		
		JLabel lblImagenFondon = new JLabel(scaledIcon);
		lblImagenFondon.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondon);
		
	}
}
