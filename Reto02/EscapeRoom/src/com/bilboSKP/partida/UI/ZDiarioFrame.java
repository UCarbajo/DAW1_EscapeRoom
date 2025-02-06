package com.bilboSKP.partida.UI;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ZDiarioFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblImagenFondo;
	private JButton btnCerrar;
	private Font fontNumeros;
	private Font fontTexto;
	private final int tamanoNumeroAnchoLargo = 200;
	private int[][] numerosCuaderno = { { 2, 6, 9, 11, 7, 5 }, { 8, 14, 15, 23, 7, 9 }, { 12, 4, 13, 9, 1, 5 } };
	private int[][] posicionNumeros = { { 100, 30 }, { 355, 30 }, { 100, 240 }, { 355, 240 }, { 100, 450 },
			{ 355, 450 } };
	private JLabel lbltextoPrimeraPagina;
	private JLabel lbltextoSegundaPagina;
	private JLabel lbltextoTerceraPagina;
	private ArrayList<JLabel> listaNumerosPrimeraPagina = new ArrayList<>();
	private ArrayList<JLabel> listaNumerosSegundaPagina = new ArrayList<>();
	private ArrayList<JLabel> listaNumerosTerceraPagina = new ArrayList<>();
	private int paginaCuarderno = 0;

	public ZDiarioFrame() {
		

		try {
			fontNumeros = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Marker_SD_Italic.ttf"));
			fontNumeros = fontNumeros.deriveFont(170f);
			fontTexto = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Faraco_Hand.ttf"));
			fontTexto = fontTexto.deriveFont(35f);

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontNumeros);
			ge.registerFont(fontTexto);

		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		crearNumeros();

		JButton btnPaginaAnterior = new JButton("P\u00E1gina Anterior");
		btnPaginaAnterior.setBounds(1044, 626, 138, 44);
		contentPane.add(btnPaginaAnterior);

		JButton btnPaginaSiguiente = new JButton("P\u00E1gina Anterior");
		btnPaginaSiguiente.setBounds(60, 626, 138, 44);
		contentPane.add(btnPaginaSiguiente);

		lbltextoPrimeraPagina = new JLabel();
		lbltextoPrimeraPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoPrimeraPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoPrimeraPagina.setBounds(688, 63, 494, 477);
		lbltextoPrimeraPagina.setText("<html><p>Entrada del Diario:</p><br>"
				+ "<p>Hoy escuch\u00E9 algunas <strong>palabras</strong> que fing\u00ED no o\u00EDr. Pero se quedaron ah\u00ED, dando vueltas en mi cabeza.</p><br>"
				+ "<p>Dicen que no <strong>duelen</strong>, que no importan, pero s\u00ED lo hacen. <strong>Crees</strong> que no es nada, pero pesa <strong>m\u00E1s</strong> de lo que parece.</p><html>");
		lbltextoPrimeraPagina.setFont(fontTexto);
		lbltextoPrimeraPagina.setVisible(false);
		contentPane.add(lbltextoPrimeraPagina);

		lbltextoSegundaPagina = new JLabel();
		lbltextoSegundaPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoSegundaPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoSegundaPagina.setBounds(688, 63, 494, 477);
		lbltextoSegundaPagina.setText("<html><p>Entrada del Diario:</p><br>"
				+ "<p>Hoy me di cuenta de que han roto mis p\u00E1ginas. Mis pensamientos est\u00E1n dispersos. No puedo dejar que sigan haciéndolo.</p><br>"
				+ "<p>He creado un <strong>c\u00F3digo secreto:</strong> \"Cuando los pares miran al cielo y los impares al suelo, la uni\u00F3n se encontrar\u00E1 en el centro.\"</p><br>"
				+ "<p>Así, aunque intenten callarme, mis palabras seguir\u00E1n protegidas, esperando ser descubiertas por quien busque.</p><html>");
		lbltextoSegundaPagina.setFont(fontTexto);
		lbltextoSegundaPagina.setVisible(false);
		contentPane.add(lbltextoSegundaPagina);

		lbltextoTerceraPagina = new JLabel();
		lbltextoTerceraPagina.setVerticalAlignment(SwingConstants.TOP);
		lbltextoTerceraPagina.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoTerceraPagina.setBounds(688, 63, 494, 477);
		lbltextoTerceraPagina.setText("<html><p>Entrada del Diario:</p><br>"
				+ "<p>Hoy escuch\u00E9 algunas <strong>palabras</strong> que fing\u00ED no o\u00EDr. Pero se quedaron ah\u00ED, dando vueltas en mi cabeza.</p><br>"
				+ "<p>Dicen que no <strong>duelen</strong>, que no importan, pero s\u00ED lo hacen. <strong>Crees</strong> que no es nada, pero pesa <strong>m\u00E1s</strong> de lo que parece.</p><html>");
		lbltextoTerceraPagina.setFont(fontTexto);
		lbltextoTerceraPagina.setVisible(false);
		contentPane.add(lbltextoTerceraPagina);

		btnPaginaAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaCuarderno < 2) {
					paginaCuarderno = paginaCuarderno + 1;
					mostrarPagina(paginaCuarderno);
				}
			}
		});

		btnPaginaSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (paginaCuarderno > 0) {
					paginaCuarderno = paginaCuarderno - 1;
					mostrarPagina(paginaCuarderno);
				}
			}
		});

		ImageIcon imgCerrar = crearScaledImage("imagenes/simboloCerrar.png", 50, 50);
		ImageIcon imgCerrarRojo = crearScaledImage("imagenes/simboloCerrarRojo.png", 50, 50);

		btnCerrar = new JButton();
		btnCerrar.setIcon(imgCerrar);
		btnCerrar.setBackground(null);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setBounds(1119, 30, 50, 50);
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setIcon(imgCerrarRojo);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setIcon(imgCerrar);
			}
		});
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnCerrar);

		ImageIcon imgFondo = crearScaledImage("imagenes/diario.png", 1280, 720);

		lblImagenFondo = new JLabel();
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(imgFondo);
		contentPane.add(lblImagenFondo);

		mostrarPagina(paginaCuarderno);
	}

	private ImageIcon crearScaledImage(String rutaImagen, int x, int y) {
		ImageIcon icono = new ImageIcon(rutaImagen);
		Image img = icono.getImage();
		Image img2 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(img2);
		return scaledImg;
	}

	private void crearNumeros() {
		for (int i = 0; i < numerosCuaderno.length; i++) {
			for (int j = 0; j < posicionNumeros.length; j++) {
				JLabel lblPosicionNumeros = new JLabel();
				lblPosicionNumeros.setBounds(posicionNumeros[j][0], posicionNumeros[j][1], tamanoNumeroAnchoLargo,
						tamanoNumeroAnchoLargo);
				lblPosicionNumeros.setText(String.valueOf(numerosCuaderno[i][j]));
				lblPosicionNumeros.setFont(fontNumeros);
				lblPosicionNumeros.setHorizontalAlignment(SwingConstants.CENTER);
				lblPosicionNumeros.setVerticalAlignment(SwingConstants.CENTER);
				lblPosicionNumeros.setVisible(false);
				contentPane.add(lblPosicionNumeros);
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

	public static void main(String[] args) {

		ZDiarioFrame ventana = new ZDiarioFrame();
		ventana.setVisible(true);

	}
}
