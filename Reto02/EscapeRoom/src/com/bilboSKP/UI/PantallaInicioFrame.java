package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicioFrame extends JFrame {

	private JPanel contentPane;
	private ImageIcon originalIcon;

	public PantallaInicioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon("imagenes/ImagenINICIO.jpeg"); 
        Image img = icon.getImage();
        
        Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		JButton btnIniciarSesión = new JButton("IniciarSesi\u00F3n");
		btnIniciarSesión.setBounds(895, 134, 335, 56);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(895, 217, 335, 56);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.setBounds(892, 466, 335, 100);
		
		contentPane.setLayout(null);
		contentPane.add(btnIniciarSesión);
		contentPane.add(btnJugar);
		contentPane.add(btnRegistrarse);
		JLabel lblImagenFondo = new JLabel(scaledIcon);
		lblImagenFondo.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondo);
		
	}
}
