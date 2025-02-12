package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

public class BSegundaPruebaFrame extends JPanel {

	private final int tamanoFrameX = 1400;
	private final int tamanoFrameY = 720;
	private JPanel enunciadoPane;
	private JLabel lblEnunciado;
	private JLabel lblFondoEnunciado;
	private JButton btnEnunciado;
	private JButton btnPistas;
	private final int[][] coordenadasIniciales = { { 30, 50 }, { 230, 450 }, { 30, 450 }, { 230, 50 }, { 30, 250 },
			{ 230, 250 } };
	private final int[][] coordenadasCorrectas = { { 500, 50 }, { 500, 250 }, { 500, 450 }, { 700, 50 }, { 700, 250 },
			{ 700, 450 } };
	private Font fontNumeros;
	private Font fontTexto;
	private JButton btnPrimeraPista;
	private JButton btnSegundaPista;
	private JButton btnTerceraPista;
	private JButton btnCerrar;
	private JLabel lblErrorMsg;
	private APasilloFrame pasilloFrame;
	private ResourceBundle idioma;
	private boolean[] estadoPista = new boolean[3];
	private JLabel lblPrimeraPista;
	private JLabel lblSegundaPista;
	private JLabel lblTerceraPista;
	private Font fontPista;

	public BSegundaPruebaFrame(AEntradaJuego aEntradaJuego, Locale local) {

		cambiarIdioma(local);
		setBounds(0, 0, tamanoFrameX, tamanoFrameY);
		setLayout(null);

		ArrayList<JLabel> listaPosicionesCorrectas = new ArrayList<JLabel>();
		ArrayList<JLabel> listaTrozosPapel = new ArrayList<JLabel>();

		try {
			fontNumeros = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Marker_SD.ttf"));
			fontNumeros = fontNumeros.deriveFont(50f);
			fontPista = fontNumeros.deriveFont(40f);
			fontTexto = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/AppleGaramond.ttf"));
			fontTexto = fontTexto.deriveFont(25f);

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontNumeros);
			ge.registerFont(fontTexto);
		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}

		// TODO REVISAR ESTA PARTE DEL CODIGO.
		ImageIcon fondoEnunciado = ImageRescaler.scaleImage("/imagenes/fondoEnunciado.png", tamanoFrameX, tamanoFrameY);

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
		btnEnunciado.setBounds((aEntradaJuego.getIconoPanel().getWidth()-100)/2, 150, 100, 80);
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
		btnPistas.setBounds((aEntradaJuego.getIconoPanel().getWidth()-100)/2, 250, 100, 80);
		aEntradaJuego.getIconoPanel().add(btnPistas);
		
		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, tamanoFrameX, tamanoFrameY);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		add(enunciadoPane);

		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1280, 699);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(fontNumeros);
		lblEnunciado.setText(idioma.getString("label.descripcionEnunciadoSegundaPrueba"));
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

		lblErrorMsg = new JLabel(idioma.getString("label.mensajeErrorSegundaPrueba"));
		lblErrorMsg.setForeground(Color.red);
		lblErrorMsg.setBounds(1030, 478, 173, 39);
		lblErrorMsg.setVisible(false);
		add(lblErrorMsg);

		// Crear los JLabel con la funcionalidad de arrastre
		crearTrozosPapel(listaPosicionesCorrectas, listaTrozosPapel);
		// Creamos las zonas correctas
		crearPosicionCorrecta(listaPosicionesCorrectas, coordenadasCorrectas);

		ImageIcon fondoPantalla = ImageRescaler.scaleImage("/imagenes/FondoSegundaPruebaPupitre.png", 1280, 720);

		JButton btnListo = new JButton("LISTO");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean todoCorrecto = true;

				if (!comprobarResultado(listaPosicionesCorrectas, listaTrozosPapel)) {
					todoCorrecto = false;
				}
				if (todoCorrecto) {
					JLabel menuCorrectoPane = new JLabel();

					int tamanoMenuCorrectoX = 700;
					int tamanoMenuCorrectoY = 200;
					menuCorrectoPane.setBounds((getWidth() - tamanoMenuCorrectoX) / 2,
							(getHeight() - tamanoMenuCorrectoY) / 2, tamanoMenuCorrectoX, tamanoMenuCorrectoY);
					menuCorrectoPane.setBackground(Color.white);
					menuCorrectoPane.setBorder(BorderFactory.createLineBorder(Color.black, 5));
					menuCorrectoPane.setOpaque(true);
					menuCorrectoPane.setVisible(true);

					JLabel textoMenu = new JLabel(idioma.getString("label.mensajeCorrectoDescripcion"));			
					int tamanoTextMenuX = 300;
					int tamanoTextoMenuY = 100;
					textoMenu.setBounds(0, 10, tamanoMenuCorrectoX, tamanoTextoMenuY);
					textoMenu.setFont(fontTexto);
					textoMenu.setHorizontalAlignment(SwingConstants.CENTER);
					textoMenu.setVerticalAlignment(SwingConstants.CENTER);
					menuCorrectoPane.add(textoMenu);

					JButton btnContinuar = new JButton(idioma.getString("label.mensajeCorrectoContinuar"));
					int tamanoContinuarX = 150;
					int tamanoContinuarY = 50;
					btnContinuar.setBounds((menuCorrectoPane.getWidth() - tamanoContinuarX) / 2,
							(tamanoMenuCorrectoY / 2), tamanoContinuarX, tamanoContinuarY);
					btnContinuar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							aEntradaJuego.getJuegosCompletados()[1]=true;
							if(!aEntradaJuego.comprobarPruebasCompletadas()) {
							removeAll();
							aEntradaJuego.getIconoPanel().remove(btnEnunciado);
							aEntradaJuego.getIconoPanel().remove(btnPistas);
							pasilloFrame = new APasilloFrame(aEntradaJuego, local);
							aEntradaJuego.getNavegacionPane().add(pasilloFrame, 0);
							aEntradaJuego.repaint();
							aEntradaJuego.revalidate();
							}else {
								aEntradaJuego.mostrarPantallaFinal();
							}
						}
					});
					menuCorrectoPane.add(btnContinuar);

					removeAll();
					add(menuCorrectoPane, 0);
					menuCorrectoPane.repaint();
					menuCorrectoPane.revalidate();
				} else {
					lblErrorMsg.setVisible(true);
					for (int i = 0; i < listaTrozosPapel.size(); i++) {
						JLabel label = listaTrozosPapel.get(i);
						label.setLocation(coordenadasIniciales[i][0], coordenadasIniciales[i][1]);
					}
				}
			}

		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListo.setBounds(1028, 531, 182, 100);
		btnListo.setOpaque(false);
		add(btnListo);

		btnCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
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

		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(fondoPantalla);
		add(lblImagenFondo);

		aEntradaJuego.repaint();
		aEntradaJuego.revalidate();
	}

	private void cambiarIdioma(Locale locale) {
		idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
		
	}

	private void crearPosicionCorrecta(ArrayList<JLabel> listaPosicionesCorrectas, int[][] posicionesCorrectas) {
		for (int i = 0; i < posicionesCorrectas.length; i++) {
			JLabel posicionCorrecta = crearPosicionCorrecta(posicionesCorrectas[i][0], posicionesCorrectas[i][1]);
			listaPosicionesCorrectas.add(posicionCorrecta);
			add(posicionCorrecta);
		}
	}

	private void crearTrozosPapel(ArrayList<JLabel> listaPosicionesCorrectas, ArrayList<JLabel> listaTrozosPapel) {
		for (int i = 0; i < coordenadasIniciales.length; i++) {
			JLabel trozoPapel = crearLabel(coordenadasIniciales[i][0], coordenadasIniciales[i][1], i);
			listaTrozosPapel.add(trozoPapel);
			add(trozoPapel);

			trozoPapel.addMouseListener(trozoPapelMouseRelease(listaPosicionesCorrectas, trozoPapel, i));
			trozoPapel.addMouseMotionListener(trozoPapelMouseDragged(trozoPapel));
		}
	}

	private MouseListener trozoPapelMouseRelease(ArrayList<JLabel> listaPosicionesCorrectas, JLabel trozoPapel, int i) {
		MouseListener soltarRaton = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent raton) {
				// Verificar si el JLabel está dentro de una de las zonas correctas
				for (JLabel zona : listaPosicionesCorrectas) {
					if (zona.getBounds().contains(trozoPapel.getBounds())) {
						// Fijar el JLabel en la posición de la zona correcta
						trozoPapel.setLocation(zona.getX() + zona.getWidth() / 14, zona.getY() + zona.getHeight() / 14);
						return; // Salir del bucle, ya que hemos encontrado la zona
					}
				}
				// Reiniciamos la posicion del trozo de papel al lugar de origen
				trozoPapel.setLocation(coordenadasIniciales[i][0], coordenadasIniciales[i][1]);
			}
		};
		return soltarRaton;
	}

	private MouseMotionListener trozoPapelMouseDragged(JLabel trozoPapel) {
		MouseMotionListener moverRaton = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent raton) {
				lblErrorMsg.setVisible(false);
				// Actualizar la posición mientras se arrastra
				trozoPapel.setLocation(
						Math.max(0,
								Math.min(raton.getXOnScreen() - getLocationOnScreen().x - trozoPapel.getWidth() / 2,
										getWidth() - trozoPapel.getWidth())),
						Math.max(0,
								Math.min(raton.getYOnScreen() - getLocationOnScreen().y - trozoPapel.getHeight() / 2,
										getHeight() - trozoPapel.getHeight())));
			}
		};
		return moverRaton;
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

	// METODO Creacion label
	private JLabel crearLabel(int x, int y, int i) {
		ImageIcon icon = ImageRescaler.scaleImage(obtenerPosicionImagen(i), 175, 175);

		JLabel etiqueta = new JLabel("Trozo");
		etiqueta.setForeground(Color.RED);
		etiqueta.setBackground(Color.RED);
		etiqueta.setOpaque(true);
		etiqueta.setIcon(icon);
		etiqueta.setBounds(x, y, 175, 175);
		etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		return etiqueta;
	}

	// METODO Obtener una imagen
	private String obtenerPosicionImagen(int num) {
		String[] posicion = { "/imagenes/SegundaPrueba/Numero3.png", "/imagenes/SegundaPrueba/Numero8.png",
				"/imagenes/SegundaPrueba/Numero9.png", "/imagenes/SegundaPrueba/Numero12.png",
				"/imagenes/SegundaPrueba/Numero15.png", "/imagenes/SegundaPrueba/Numero17.png" };
		return posicion[num];
	}

	// METODO Crear las posiciones donde se colocan los label
	private JLabel crearPosicionCorrecta(int posicionesCorrectasX, int posicionesCorrectasY) {
		int tamanoCorrectaX = 200;
		int tamanoCorrectaY = 200;
		JLabel lblPosicionCorrecta = new JLabel("");
		lblPosicionCorrecta.setBackground(Color.white);
		lblPosicionCorrecta.setOpaque(false);
		lblPosicionCorrecta.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		lblPosicionCorrecta.setBounds(posicionesCorrectasX, posicionesCorrectasY, tamanoCorrectaX, tamanoCorrectaY);
		return lblPosicionCorrecta;
	}

	private boolean comprobarResultado(ArrayList<JLabel> listaPosicionesCorrectas, ArrayList<JLabel> listaTrozosPapel) {
		return (listaPosicionesCorrectas.get(0).getBounds().contains(listaTrozosPapel.get(3).getBounds())
				&& listaPosicionesCorrectas.get(1).getBounds().contains(listaTrozosPapel.get(4).getBounds())
				&& listaPosicionesCorrectas.get(2).getBounds().contains(listaTrozosPapel.get(0).getBounds())
				&& listaPosicionesCorrectas.get(3).getBounds().contains(listaTrozosPapel.get(1).getBounds())
				&& listaPosicionesCorrectas.get(4).getBounds().contains(listaTrozosPapel.get(5).getBounds())
				&& listaPosicionesCorrectas.get(5).getBounds().contains(listaTrozosPapel.get(2).getBounds()))
				|| (listaPosicionesCorrectas.get(0).getBounds().contains(listaTrozosPapel.get(1).getBounds())
						&& listaPosicionesCorrectas.get(1).getBounds().contains(listaTrozosPapel.get(5).getBounds())
						&& listaPosicionesCorrectas.get(2).getBounds().contains(listaTrozosPapel.get(2).getBounds())
						&& listaPosicionesCorrectas.get(3).getBounds().contains(listaTrozosPapel.get(3).getBounds())
						&& listaPosicionesCorrectas.get(4).getBounds().contains(listaTrozosPapel.get(4).getBounds())
						&& listaPosicionesCorrectas.get(5).getBounds().contains(listaTrozosPapel.get(0).getBounds()));
	}
}
