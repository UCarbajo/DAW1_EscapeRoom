package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
=======
import java.util.Locale;
>>>>>>> 641ceb2eeaf9b7688264aba4b809e8be456e8d68
import java.awt.event.ActionEvent;

public class APrimeraPueba extends JPanel {

<<<<<<< HEAD
    private JPanel contentPane;
    private Font fontPersonal;
=======
	private ASopaDeLetras sopaLetras;
	
	public APrimeraPueba(AEntradaJuego aEntradaJuego, Locale local) {
		repaint();
		revalidate();
		
		setBounds(0, 0, 1280, 720);
		setLayout(null);
>>>>>>> 641ceb2eeaf9b7688264aba4b809e8be456e8d68

		ImageIcon icono = new ImageIcon("imagenes/imgJuego1.jpeg");
		Image img = icono.getImage();
		Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imgEscalado);

<<<<<<< HEAD
        ImageIcon icono = new ImageIcon("imagenes/imgJuego1.jpeg");
        Image img = icono.getImage();
        Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imgEscalado);
        
        JTextPane txtpizarra = new JTextPane();
        txtpizarra.setBackground(Color.WHITE);
        txtpizarra.setText("Las ____ ____ ___ de lo que ____.");
        txtpizarra.setEditable(false);
        txtpizarra.setBounds(206, 337, 207, 20);
        txtpizarra.setForeground(Color.WHITE); 
        contentPane.add(txtpizarra);
        
        txtpizarra.setOpaque(false);
        try {
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Marker_SD.ttf") );
			fontPersonal = fontPersonal.deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);

		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}


        JButton btnPizarra = new JButton("");
        btnPizarra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SopaDeLetras ventana = new SopaDeLetras();
                ventana.setVisible(true);
                dispose();                
            }
        });
        btnPizarra.setBounds(137, 278, 346, 137);
        contentPane.add(btnPizarra);
        btnPizarra.setOpaque(false);
        btnPizarra.setContentAreaFilled(false);
        btnPizarra.setBorder(null);
        btnPizarra.setFocusPainted(false);

        JLabel lblNewLabel = new JLabel(" ");
        lblNewLabel.setIcon(iconoEscalado);
        lblNewLabel.setBounds(0, 0, 1264, 681);
        contentPane.add(lblNewLabel);
    }
=======
		JTextPane txtpizarra = new JTextPane();
		txtpizarra.setText("Las palabras duelen más de lo que crees.");
		txtpizarra.setEditable(false);
		txtpizarra.setBounds(176, 327, 207, 20);
		add(txtpizarra);

		txtpizarra.setOpaque(false);

		JButton btnPizarra = new JButton("");
		btnPizarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				sopaLetras = new ASopaDeLetras(aEntradaJuego, local);
				aEntradaJuego.getNavegacionPane().add(sopaLetras, 0);
				aEntradaJuego.repaint();
				aEntradaJuego.revalidate();
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
>>>>>>> 641ceb2eeaf9b7688264aba4b809e8be456e8d68
}
