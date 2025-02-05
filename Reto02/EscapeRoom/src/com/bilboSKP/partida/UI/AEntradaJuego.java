package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AEntradaJuego extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnenEstaEscuela;
	private JLabel lblIntroduccion;
	private ResourceBundle idioma;
	private Locale locale;
	private JButton btnFlechaArriba;
	private Font fontPersonal;

	public AEntradaJuego(Locale local) {
		
		cambiarIdioma(local);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/AppleGaramond.ttf"));
			fontPersonal = fontPersonal.deriveFont(30f);

			// TODO USAR EN ESTA PARTE DE CODIGO EN CASO DE QUE NO CARGUE EL FONT
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);
			
			
		} catch (FontFormatException | IOException e) {
			System.out.println("No ha cargado el font correctamente");
			e.printStackTrace();
		}

		JButton btnAdelante = new JButton("Adelante");
		btnAdelante.setBounds(560, 558, 150, 50);
		contentPane.add(btnAdelante);

		lblIntroduccion = new JLabel(idioma.getString("label.instruccionesPantallaInicio"));
		lblIntroduccion.setBounds(0, 0, 1264, 681);
		lblIntroduccion.setBorder(new EmptyBorder(350, 350, 350, 350));
		lblIntroduccion.setForeground(Color.BLACK);
		lblIntroduccion.setFont(fontPersonal);
		lblIntroduccion.setBackground(new Color(255, 255, 255, 200));
		lblIntroduccion.setOpaque(false);
		lblIntroduccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduccion.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIntroduccion);

		txtpnenEstaEscuela = new JTextPane();
		txtpnenEstaEscuela.setEditable(false);
		txtpnenEstaEscuela.setBounds(0, 0, 1264, 681);
		txtpnenEstaEscuela.setBackground(new Color(255, 255, 255, 180));
		txtpnenEstaEscuela.setOpaque(true);
		contentPane.add(txtpnenEstaEscuela);
		
		ImageIcon imgFlechaArriba = crearScaledImage("imagenes/FlechaArriba.png", 100, 100);
		btnFlechaArriba = new JButton("");
		btnFlechaArriba.setIcon(imgFlechaArriba);
		btnFlechaArriba.setOpaque(false);
		btnFlechaArriba.setContentAreaFilled(false);
		btnFlechaArriba.setBorder(null);
		btnFlechaArriba.setVisible(false);
		btnFlechaArriba.setBounds(610, 522, 100, 100);
		contentPane.add(btnFlechaArriba);
			
		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIntroduccion.setVisible(false);
				txtpnenEstaEscuela.setVisible(false);
				btnAdelante.setVisible(false);
				btnFlechaArriba.setVisible(true);
			}
		});
		
		btnFlechaArriba.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				APasilloFrame ventana = new APasilloFrame(local);
				ventana.setVisible(true);
				dispose();
			}
		});
		ImageIcon fondoEntrada = crearScaledImage("imagenes/entradaCole.jpeg", 1280, 720);
		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(fondoEntrada);
		lblEntradaCole.setBounds(0, 0, 1280, 692);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);
		contentPane.add(lblEntradaCole);
		
	}
	
	private ImageIcon crearScaledImage(String rutaImagen, int x, int y) {
		ImageIcon icono = new ImageIcon(rutaImagen);
		Image img = icono.getImage();
		Image img2 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(img2);
		return scaledImg;
	}

	private void cambiarIdioma(Locale local) {
        locale = local;  
        idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
    }
}
