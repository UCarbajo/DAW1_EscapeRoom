package com.bilboSKP.partida.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import herramientas.ImageRescaler;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class ASopaDeLetras extends JPanel {

	private Font fontPersonal;
	private JTextArea palabraSeleccionada;
	private Map<String, Integer> palabrasCorrectas = new HashMap<>();
	private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
	private ArrayList<Point> posicionesSeleccionadas = new ArrayList<>();
	private String[][] sopa = { { "P", "A", "L", "A", "B", "R", "A", "S" }, { "D", "A", "D", "X", "E", "N", "Á", "U" },
			{ "M", "C", "U", "X", "X", "Á", "M", "E" }, { "C", "R", "E", "A", "S", "Á", "X", "L" },
			{ "X", "R", "L", "E", "S", "X", "X", "E" }, { "C", "X", "E", "X", "S", "R", "X", "N" },
			{ "X", "X", "N", "X", "S", "X", "A", "X" }, { "C", "R", "E", "E", "S", "X", "X", "S" } };

	private JLabel[] fraseHuecos;
	private JButton[][] botones;
	private Map<String, ArrayList<Point>> palabrasYPosiciones = new HashMap<>();
	private JPanel enunciadoPane;
	private JLabel lblEnunciado;
	private JLabel lblFondoEnunciado;
	private JButton btnEnunciado;
	private JButton btnPistas;
	private JButton btnPrimeraPista;
	private JButton btnSegundaPista;
	private JButton btnTerceraPista;
	private JButton btnCerrar;
	private JPanel panelCentral;
	private JLabel lblFondo;
	private JPanel panelFrase;
	private Container panelInferior;
	private APasilloFrame pasilloFrame;
	private ResourceBundle idioma;

	// NUEVO: Panel final que se mostrará cuando se complete la sopa de letras
	private JPanel finalMessagePanel;
	private JLabel finalMessageText;
	private JButton btnAvanzar;
	private Font fontEnunciado;
	private Font fontTiza;
	private JLabel lblImgFondo;
	private boolean[] estadoPista = new boolean[3];
	private JLabel lblPrimeraPista;
	private JLabel lblSegundaPista;
	private JLabel lblTerceraPista;
	private Font fontPista;

	public ASopaDeLetras(AEntradaJuego aEntradaJuego, Locale local) {

		cambiarIdiome(local);

		try {
			fontEnunciado = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Marker_SD.ttf"));
			fontEnunciado = fontEnunciado.deriveFont(50f);
			fontPista = fontEnunciado.deriveFont(40f);
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/fonts/Chalk Brush.ttf"));
			fontPersonal = fontPersonal.deriveFont(17f);
			fontTiza = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Tizza.otf"));
			fontTiza = fontTiza.deriveFont(50f);

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);
			ge.registerFont(fontEnunciado);
			ge.registerFont(fontTiza);
		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}

		setBounds(0, 0, 1400, 720);
		setLayout(null);

		ImageIcon fondoEnunciado = ImageRescaler.scaleImage("/imagenes/fondoEnunciado.png", 1400, 720);

		btnEnunciado = new JButton();
		btnEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibilidadEnunciadoPane(true, false);
			}
		});
		btnEnunciado.setOpaque(true);
		btnEnunciado.setBackground(null);
		btnEnunciado.setContentAreaFilled(false);
		btnEnunciado.setFocusable(false);
		btnEnunciado.setBorder(null);
		btnEnunciado.setIcon(ImageRescaler.scaleImage("/imagenes/iconoEnunciado.png", 100, 80));
		btnEnunciado.setBounds((aEntradaJuego.getIconoPanel().getWidth() - 100) / 2, 150, 100, 80);
		aEntradaJuego.getIconoPanel().add(btnEnunciado);

		btnPistas = new JButton();
		btnPistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibilidadEnunciadoPane(false, true);
			}
		});
		btnPistas.setOpaque(true);
		btnPistas.setIcon(ImageRescaler.scaleImage("/imagenes/iconoPista.png", 100, 80));
		btnPistas.setBackground(null);
		btnPistas.setContentAreaFilled(false);
		btnPistas.setFocusable(false);
		btnPistas.setBorder(null);
		btnPistas.setBounds((aEntradaJuego.getIconoPanel().getWidth() - 100) / 2, 250, 100, 80);
		aEntradaJuego.getIconoPanel().add(btnPistas);

		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, 1400, 720);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		add(enunciadoPane);

		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1280, 699);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(fontEnunciado);
		lblEnunciado.setText(idioma.getString("label.descripcionEnunciadoPrimeraPrueba"));
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);

		btnPrimeraPista = new JButton(idioma.getString("label.primeraPista"));
		btnPrimeraPista.setBounds(200, 40, 877, 200);
		btnPrimeraPista.setFont(aEntradaJuego.getFontPista());
		btnPrimeraPista.setVisible(false);
		btnPrimeraPista.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				btnPrimeraPista.setVisible(false);
				estadoPista[0] = true;
				lblPrimeraPista = new JLabel(idioma.getString("label.sopaPrimeraPista"));
				lblPrimeraPista.setBounds(btnPrimeraPista.getLocation().x ,btnPrimeraPista.getLocation().y, btnPrimeraPista.getWidth(), btnPrimeraPista.getHeight());
				lblPrimeraPista.setHorizontalAlignment(SwingConstants.CENTER);
				lblPrimeraPista.setVerticalAlignment(SwingConstants.CENTER);
				lblPrimeraPista.setFont(fontPista);
				enunciadoPane.add(lblPrimeraPista, 0);
				enunciadoPane.repaint();
				enunciadoPane.revalidate();
			}
		});
		enunciadoPane.add(btnPrimeraPista);

		btnSegundaPista = new JButton(idioma.getString("label.segundaPista"));
		btnSegundaPista.setBounds(200, 260, 877, 200);
		btnSegundaPista.setFont(aEntradaJuego.getFontPista());
		btnSegundaPista.setVisible(false);
		btnSegundaPista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSegundaPista.setVisible(false);
				estadoPista[1] = true;
				lblSegundaPista = new JLabel(idioma.getString("label.sopaSegundaPista"));
				lblSegundaPista.setBounds(btnSegundaPista.getLocation().x ,btnSegundaPista.getLocation().y, btnSegundaPista.getWidth(), btnSegundaPista.getHeight());
				lblSegundaPista.setHorizontalAlignment(SwingConstants.CENTER);
				lblSegundaPista.setVerticalAlignment(SwingConstants.CENTER);
				lblSegundaPista.setFont(fontPista);
				enunciadoPane.add(lblSegundaPista, 0);
				enunciadoPane.repaint();
				enunciadoPane.revalidate();
			}
		});
		enunciadoPane.add(btnSegundaPista);

		btnTerceraPista = new JButton(idioma.getString("label.terceraPista"));
		btnTerceraPista.setBounds(200, 485, 877, 200);
		btnTerceraPista.setFont(aEntradaJuego.getFontPista());
		btnTerceraPista.setVisible(false);
		btnTerceraPista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTerceraPista.setVisible(false);
				estadoPista[2] = true;
				lblTerceraPista = new JLabel(idioma.getString("label.sopaTerceraPista"));
				lblTerceraPista.setBounds(btnTerceraPista.getLocation().x ,btnTerceraPista.getLocation().y, btnTerceraPista.getWidth(), btnTerceraPista.getHeight());
				lblTerceraPista.setHorizontalAlignment(SwingConstants.CENTER);
				lblTerceraPista.setVerticalAlignment(SwingConstants.CENTER);
				lblTerceraPista.setFont(fontPista);
				enunciadoPane.add(lblTerceraPista, 0);
				enunciadoPane.repaint();
				enunciadoPane.revalidate();
			}
		});
		enunciadoPane.add(btnTerceraPista);

		ImageIcon imgCerrar = ImageRescaler.scaleImage("/imagenes/simboloCerrar.png", 100, 100);
		ImageIcon imgCerrarRojo = ImageRescaler.scaleImage("/imagenes/simboloCerrarRojo.png", 100, 100);

		btnCerrar = new JButton();
		btnCerrar.setBounds(1120, 30, 100, 100);
		btnCerrar.setBackground(null);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setIcon(imgCerrar);
		enunciadoPane.add(btnCerrar);

		lblFondoEnunciado = new JLabel();
		lblFondoEnunciado.setBounds(10, 10, 1280, 700);
		lblFondoEnunciado.setIcon(fondoEnunciado);
		enunciadoPane.add(lblFondoEnunciado);

		lblFondo = new JLabel();
		lblFondo.setBounds(0, 0, 1280, 720);
		lblFondo.setVisible(false);
		add(lblFondo);

		panelFrase = new JPanel();
		panelFrase.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panelFrase.setBounds(200, 150, 800, 50);
		panelFrase.setOpaque(false);
		panelFrase.setFont(fontPersonal);
		panelFrase.setVisible(true);
		add(panelFrase);

		String[] frasePartes = { "LAS", "_____", "_____", "_____", "DE LO QUE", "_____" };
		fraseHuecos = new JLabel[frasePartes.length];

		palabrasCorrectas.put("PALABRAS", 1);
		palabrasCorrectas.put("DUELEN", 2);
		palabrasCorrectas.put("MÁS", 3);
		palabrasCorrectas.put("CREES", 5);

		for (int i = 0; i < frasePartes.length; i++) {
			JLabel lblParte = new JLabel(frasePartes[i]);
			lblParte.setFont(fontPersonal);
			lblParte.setForeground(Color.white);
			if (frasePartes[i].equals("_____")) {
				lblParte.setPreferredSize(new Dimension(150, 30));
				lblParte.setHorizontalAlignment(SwingConstants.CENTER);
				// Solo se asigna a la posición si es "_____"
				fraseHuecos[i] = lblParte;
			}
			panelFrase.add(lblParte);
		}

		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(sopa.length, sopa[0].length));
		panelCentral.setBounds(410, 225, 400, 200);
		lblFondo.add(panelCentral);

		botones = new JButton[sopa.length][sopa[0].length];

		for (int i = 0; i < sopa.length; i++) {
			for (int j = 0; j < sopa[i].length; j++) {
				JButton boton = new JButton(sopa[i][j]);
				boton.setFont(new Font("Arial", Font.BOLD, 16));
				panelCentral.add(boton);
				botones[i][j] = boton;

				final int row = i;
				final int col = j;

				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!botonesSeleccionados.contains(boton)) {
							botonesSeleccionados.add(boton);
							boton.setBackground(Color.YELLOW);
							posicionesSeleccionadas.add(new Point(row, col));
							actualizarPalabraSeleccionada();
						} else {
							botonesSeleccionados.remove(boton);
							boton.setBackground(null);
							removerPosicionSeleccionada(row, col);
							actualizarPalabraSeleccionada();
						}
					}
				});
			}
		}

		panelInferior = new JPanel();
		panelInferior.setLayout(new BorderLayout(10, 10));
		panelInferior.setBounds(410, 450, 400, 50);
		lblFondo.add(panelInferior);

		palabraSeleccionada = new JTextArea(1, 20);
		palabraSeleccionada.setFont(new Font("Arial", Font.PLAIN, 18));
		palabraSeleccionada.setEditable(false);
		panelInferior.add(palabraSeleccionada, BorderLayout.CENTER);

		JButton btnComprobar = new JButton(idioma.getString("label.comprobar"));
		btnComprobar.setFont(new Font("Arial", Font.BOLD, 16));
		panelInferior.add(btnComprobar, BorderLayout.EAST);

		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarPalabra(aEntradaJuego, local);
			}
		});

		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				lblFondo.setVisible(true);
				repaint();
				revalidate();
			}
		});
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
		lblImgFondo = new JLabel();
		lblImgFondo.setBounds(0, 0, 1280, 720);
		lblImgFondo.setIcon(ImageRescaler.scaleImage("/imagenes/PzrrA.jpeg", 1280, 720));
		add(lblImgFondo);

		inicializarPalabras();
	}

	private void cambiarIdiome(Locale local) {
		try {
			Locale locale = local;
			idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void actualizarPalabraSeleccionada() {
		StringBuilder sb = new StringBuilder();
		for (JButton boton : botonesSeleccionados) {
			sb.append(boton.getText());
		}
		palabraSeleccionada.setText(sb.toString());
	}

	private void removerPosicionSeleccionada(int row, int col) {
		posicionesSeleccionadas.removeIf(p -> p.x == row && p.y == col);
	}

	private void verificarPalabra(AEntradaJuego aEntradaJuego, Locale local) {
		String palabra = palabraSeleccionada.getText().toUpperCase();

		if (palabrasYPosiciones.containsKey(palabra)) {
			ArrayList<Point> posicionesPalabra = palabrasYPosiciones.get(palabra);
			if (compararPosiciones(posicionesPalabra, posicionesSeleccionadas)) {
				colocarPalabraEnFrase(palabra);
				for (JButton boton : botonesSeleccionados) {
					boton.setEnabled(false);
					boton.setBackground(new Color(76, 153, 0));
				}
				botonesSeleccionados.clear();
				posicionesSeleccionadas.clear();
				palabraSeleccionada.setText("");

				// Si se han completado todos los huecos de la frase, mostramos el panel final
				if (todasLasPalabrasCompletadas()) {
					aEntradaJuego.getJuegosCompletados()[0] = true;
					lblFondo.setEnabled(false);
					remove(enunciadoPane);
					remove(lblFondo);
					repaint();
					revalidate();
					aEntradaJuego.getIconoPanel().remove(btnEnunciado);
					aEntradaJuego.getIconoPanel().remove(btnPistas);
					aEntradaJuego.repaint();
					aEntradaJuego.revalidate();
					showFinalPanel(aEntradaJuego, local);
				}
			} else {
				JOptionPane.showMessageDialog(this, idioma.getString("label.letrasIncorrectas"),
						idioma.getString("label.posicionIncorrecta"), JOptionPane.ERROR_MESSAGE);
				restablecerSeleccion();
			}
		} else {
			JOptionPane.showMessageDialog(this, idioma.getString("label.palabraIncorrecta"),
					idioma.getString("label.error"), JOptionPane.ERROR_MESSAGE);
			restablecerSeleccion();
		}
	}

	private boolean compararPosiciones(ArrayList<Point> posicionesPalabra, ArrayList<Point> posicionesUsuario) {
		if (posicionesPalabra.size() != posicionesUsuario.size()) {
			return false;
		}

		Comparator<Point> comparator = new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if (p1.x != p2.x) {
					return Integer.compare(p1.x, p2.x);
				} else {
					return Integer.compare(p1.y, p2.y);
				}
			}
		};

		Collections.sort(posicionesPalabra, comparator);
		Collections.sort(posicionesUsuario, comparator);

		for (int i = 0; i < posicionesPalabra.size(); i++) {
			Point p1 = posicionesPalabra.get(i);
			Point p2 = posicionesUsuario.get(i);
			if (!p1.equals(p2)) {
				return false;
			}
		}
		return true;
	}

	private void colocarPalabraEnFrase(String palabra) {
		int index = palabrasCorrectas.get(palabra);
		JLabel hueco = fraseHuecos[index];

		if (hueco != null && hueco.getText().equals("_____")) {
			hueco.setText(palabra);
			hueco.setForeground(Color.white);
		}
	}

	private void restablecerSeleccion() {
		for (JButton boton : botonesSeleccionados) {
			boton.setBackground(null);
		}
		botonesSeleccionados.clear();
		posicionesSeleccionadas.clear();
		palabraSeleccionada.setText("");
	}

	private void inicializarPalabras() {
		ArrayList<Point> posicionesPalabras = new ArrayList<>();
		for (int col = 0; col <= 7; col++) {
			posicionesPalabras.add(new Point(0, col));
		}
		palabrasYPosiciones.put("PALABRAS", posicionesPalabras);

		ArrayList<Point> posicionesDuelen = new ArrayList<>();
		posicionesDuelen.add(new Point(1, 2));
		posicionesDuelen.add(new Point(2, 2));
		posicionesDuelen.add(new Point(3, 2));
		posicionesDuelen.add(new Point(4, 2));
		posicionesDuelen.add(new Point(5, 2));
		posicionesDuelen.add(new Point(6, 2));
		palabrasYPosiciones.put("DUELEN", posicionesDuelen);

		ArrayList<Point> posicionesMas = new ArrayList<>();
		posicionesMas.add(new Point(2, 6));
		posicionesMas.add(new Point(3, 5));
		posicionesMas.add(new Point(4, 4));
		palabrasYPosiciones.put("MÁS", posicionesMas);

		ArrayList<Point> posicionesCrees = new ArrayList<>();
		for (int col = 0; col <= 4; col++) {
			posicionesCrees.add(new Point(7, col));
		}
		palabrasYPosiciones.put("CREES", posicionesCrees);
	}

	// Verifica si todos los huecos de la frase están completados (es decir, que ya
	// no muestran "_____")
	private boolean todasLasPalabrasCompletadas() {
		for (JLabel hueco : fraseHuecos) {
			if (hueco != null && hueco.getText().equals("_____")) {
				return false;
			}
		}
		return true;
	}

	// Muestra el panel final con el mensaje y el botón para redirigir a
	// APasilloFrame
	private void showFinalPanel(AEntradaJuego aEntradaJuego, Locale local) {

		finalMessagePanel = new JPanel();
		finalMessagePanel.setLayout(null);
		finalMessagePanel.setBounds(300, 300, 800, 200);
		finalMessagePanel.setOpaque(true);
		finalMessagePanel.setVisible(true);
		add(finalMessagePanel, 0);

		finalMessageText = new JLabel(idioma.getString("label.mensajeFinal"));
		finalMessageText.setFont(new Font("Arial", Font.BOLD, 25));
		finalMessageText.setOpaque(false);
		finalMessageText.setHorizontalAlignment(SwingConstants.CENTER);
		finalMessageText.setBounds(0, 0, 800, 100);
		finalMessagePanel.add(finalMessageText);

		btnAvanzar = new JButton(idioma.getString("label.avanzar"));
		btnAvanzar.setFont(new Font("Arial", Font.BOLD, 16));
		btnAvanzar.setBounds(300, 130, 200, 60);
		finalMessagePanel.add(btnAvanzar);
		btnAvanzar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!aEntradaJuego.comprobarPruebasCompletadas()) {
					removeAll();
					pasilloFrame = new APasilloFrame(aEntradaJuego, local);
					aEntradaJuego.getNavegacionPane().add(pasilloFrame, 0);
					aEntradaJuego.repaint();
					aEntradaJuego.revalidate();
				} else {
					aEntradaJuego.mostrarPantallaFinal();
				}
			}
		});

		repaint();
		revalidate();
	}

	private void visibilidadEnunciadoPane(boolean visibilidadEnunciado, boolean visibilidadPista) {
		enunciadoPane.setVisible(true);
		lblEnunciado.setVisible(visibilidadEnunciado);
		if (estadoPista[0]==false) {
			btnPrimeraPista.setVisible(visibilidadPista);
		}else {
			lblPrimeraPista.setVisible(visibilidadPista);
		}
		if (estadoPista[1]==false) {
			btnSegundaPista.setVisible(visibilidadPista);
		}else {
			lblSegundaPista.setVisible(visibilidadPista);
		}
		if (estadoPista[2]==false) {
			btnTerceraPista.setVisible(visibilidadPista);
		}else {
			lblTerceraPista.setVisible(visibilidadPista);
		}
		repaint();
		revalidate();
	}
}
