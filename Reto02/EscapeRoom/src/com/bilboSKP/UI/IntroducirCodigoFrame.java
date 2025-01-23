package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroducirCodigoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;

	public IntroducirCodigoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon = new ImageIcon("imagenes/ImagenPizzarra.png");
		Image img = icon.getImage();

		Image scaledImg = img.getScaledInstance(1400, 720, Image.SCALE_SMOOTH);

		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		try {
			// Cargar la fuente desde el archivo
			Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Chalktastic.ttf"));
			fuentePersonalizada = fuentePersonalizada.deriveFont(48f); // Tamaño de la fuente
			
			textCodigo = new JTextField();
			textCodigo.setForeground(new Color(255, 255, 255));
			textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			textCodigo.setBounds(346, 333, 582, 75);
			textCodigo.setFont(fuentePersonalizada);
			contentPane.add(textCodigo);
			textCodigo.setColumns(10);
			textCodigo.setOpaque(false);
			textCodigo.setBorder(null);
			
			JButton btnJugar = new JButton("JUGAR");
			btnJugar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnJugar.setForeground(Color.pink);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnJugar.setForeground(Color.white);
				}
			});
			
			btnJugar.setBounds(477, 486, 300, 53);
			btnJugar.setFont(fuentePersonalizada);
			btnJugar.setForeground(new Color(255, 255, 255));
			btnJugar.setContentAreaFilled(false);
			btnJugar.setBorder(null);
			
			contentPane.add(btnJugar);
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la fuente.");
		}
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0, 1264, 681);
		contentPane.add(lblNewLabel);

	}
}
