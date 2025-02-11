package com.bilboSKP.partida.UI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ZDiarioFrame extends JPanel{

	private JLabel lblImagenFondo;
	private JButton btnCerrar;
	private Font fontNumeros;
	private Font fontTexto;
	private final int tamanoNumeroAnchoLargo = 200;
	private int[][] numerosPorHoja = { { 2, 6, 9, 11, 7, 5 }, { 8, 14, 15, 23, 7, 9 }, { 12, 8, 15, 17, 3, 9 } };
	private int[][] posicionNumeros = { { 100, 30 }, { 355, 30 }, { 100, 240 }, { 355, 240 }, { 100, 450 },
			{ 355, 450 } };
	private JLabel lbltextoPrimeraPagina;
	private JLabel lbltextoSegundaPagina;
	private JLabel lbltextoTerceraPagina;
	private ArrayList<JLabel> listaNumerosPrimeraPagina = new ArrayList<>();
	private ArrayList<JLabel> listaNumerosSegundaPagina = new ArrayList<>();
	private ArrayList<JLabel> listaNumerosTerceraPagina = new ArrayList<>();
	private ResourceBundle idioma;
	private Locale locale;
	private int paginaCuarderno = 0;
	private Font fontTextoNumeros;

	public ZDiarioFrame(Locale local) {
		
		cambiarIdioma(local);
		setBounds(0, 0,1280, 720);
		setLayout(null);
		
		try {
			fontNumeros = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Marker_SD_Italic.ttf"));
			fontNumeros = fontNumeros.deriveFont(170f);
			fontTexto = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Faraco_Hand.ttf"));
			fontTexto = fontTexto.deriveFont(30f);
			fontTextoNumeros = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Faraco_Hand.ttf"));
			fontTextoNumeros = fontTextoNumeros.deriveFont(53f);

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontNumeros);
			ge.registerFont(fontTexto);
			ge.registerFont(fontTextoNumeros);

		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}
		
		crearNumeros();
		
		ImageIcon imgAnterior = ImageRescaler.scaleImage("/imagenes/paginaIzquierda.png", 50, 50);
		ImageIcon imgSiguiente = ImageRescaler.scaleImage("/imagenes/paginaDerecha.png", 50, 50);
		
		JButton btnPaginaSiguiente = new JButton(idioma.getString("label.siguientePagina"));
		btnPaginaSiguiente.setBounds(981, 626, 210, 44);
		btnPaginaSiguiente.setBorderPainted(false);
		btnPaginaSiguiente.setContentAreaFilled(false);
		btnPaginaSiguiente.setOpaque(false);
		btnPaginaSiguiente.setIcon(imgSiguiente);
		btnPaginaSiguiente.setFocusPainted(false);
		btnPaginaSiguiente.setHorizontalTextPosition(SwingConstants.LEFT);
		add(btnPaginaSiguiente);

		JButton btnPaginaAnterior = new JButton(idioma.getString("label.anteriorPagina"));
		btnPaginaAnterior.setBounds(60, 626, 210, 44);
		btnPaginaAnterior.setBorderPainted(false);
		btnPaginaAnterior.setContentAreaFilled(false);
		btnPaginaAnterior.setOpaque(false);
		btnPaginaAnterior.setFocusPainted(false);
		btnPaginaAnterior.setIcon(imgAnterior);
		btnPaginaAnterior.setHorizontalTextPosition(SwingConstants.RIGHT);
		add(btnPaginaAnterior);

		lbltextoPrimeraPagina = new JLabel();
		lbltextoPrimeraPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoPrimeraPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoPrimeraPagina.setBounds(688, 63, 494, 553);
		lbltextoPrimeraPagina.setText(idioma.getString("label.primeraPagina"));
		lbltextoPrimeraPagina.setFont(fontTexto);
		lbltextoPrimeraPagina.setVisible(false);
		add(lbltextoPrimeraPagina);

		lbltextoSegundaPagina = new JLabel();
		lbltextoSegundaPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoSegundaPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoSegundaPagina.setBounds(688, 63, 494, 553);
		lbltextoSegundaPagina.setText(idioma.getString("label.segundaPagina"));
		lbltextoSegundaPagina.setFont(fontTexto);
		lbltextoSegundaPagina.setVisible(false);
		add(lbltextoSegundaPagina);

		lbltextoTerceraPagina = new JLabel();
		lbltextoTerceraPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoTerceraPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoTerceraPagina.setBounds(688, 63, 494, 553);
		lbltextoTerceraPagina.setText(idioma.getString("label.terceraPagina"));
		lbltextoTerceraPagina.setFont(fontTextoNumeros);
		lbltextoTerceraPagina.setVisible(false);
		add(lbltextoTerceraPagina);

		btnPaginaSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaCuarderno < 2) {
					paginaCuarderno = paginaCuarderno + 1;
					mostrarPagina(paginaCuarderno);
				}
			}
		});

		btnPaginaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaCuarderno > 0) {
					paginaCuarderno = paginaCuarderno - 1;
					mostrarPagina(paginaCuarderno);
				}
			}
		});

		ImageIcon imgFondo = ImageRescaler.scaleImage("/imagenes/diario.png", 1280, 720);

		lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(imgFondo);
		add(lblImagenFondo);

		mostrarPagina(paginaCuarderno);
	}

	private void cambiarIdioma(Locale local) {
		locale = local;
		idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
	}

	private void crearNumeros() {
		for (int i = 0; i < numerosPorHoja.length; i++) {
			for (int j = 0; j < posicionNumeros.length; j++) {
				JLabel lblPosicionNumeros = new JLabel();
				lblPosicionNumeros.setBounds(posicionNumeros[j][0], posicionNumeros[j][1], tamanoNumeroAnchoLargo,
						tamanoNumeroAnchoLargo);
				lblPosicionNumeros.setText(String.valueOf(numerosPorHoja[i][j]));
				lblPosicionNumeros.setFont(fontNumeros);
				lblPosicionNumeros.setHorizontalAlignment(SwingConstants.CENTER);
				lblPosicionNumeros.setVerticalAlignment(SwingConstants.CENTER);
				lblPosicionNumeros.setVisible(false);
				add(lblPosicionNumeros);
				if (i == 0) {
					listaNumerosPrimeraPagina.add(lblPosicionNumeros);
				}
				if (i == 1) {
					listaNumerosSegundaPagina.add(lblPosicionNumeros);
				}
				if (i == 2) {
					listaNumerosTerceraPagina.add(lblPosicionNumeros);
				}
			}
		}
	}

	public void mostrarPagina(int numeroPagina) {
		if (numeroPagina == 0) {
			for (JLabel label : listaNumerosPrimeraPagina) {
				label.setVisible(true);
				lbltextoPrimeraPagina.setVisible(true);
			}
			for (JLabel label : listaNumerosSegundaPagina) {
				label.setVisible(false);
				lbltextoSegundaPagina.setVisible(false);
			}
			for (JLabel label : listaNumerosTerceraPagina) {
				label.setVisible(false);
				lbltextoTerceraPagina.setVisible(false);
			}
		}
		if (numeroPagina == 1) {
			for (JLabel label : listaNumerosPrimeraPagina) {
				label.setVisible(false);
				lbltextoPrimeraPagina.setVisible(false);
			}
			for (JLabel label : listaNumerosSegundaPagina) {
				label.setVisible(true);
				lbltextoSegundaPagina.setVisible(true);
			}
			for (JLabel label : listaNumerosTerceraPagina) {
				label.setVisible(false);
				lbltextoTerceraPagina.setVisible(false);
			}
		}
		if (numeroPagina == 2) {
			for (JLabel label : listaNumerosPrimeraPagina) {
				label.setVisible(false);
				lbltextoPrimeraPagina.setVisible(false);
			}
			for (JLabel label : listaNumerosSegundaPagina) {
				label.setVisible(false);
				lbltextoSegundaPagina.setVisible(false);
			}
			for (JLabel label : listaNumerosTerceraPagina) {
				label.setVisible(true);
				lbltextoTerceraPagina.setVisible(true);
			}
		}
	}

	public void ocultarDiario() {
		this.setVisible(false);
	}
}
