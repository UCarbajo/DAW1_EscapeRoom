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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BSegundaPruebaFrame extends JFrame {

	private JPanel contentPane;
	private JPanel enunciadoPane;
	private JLabel lblEnunciado;
	private JLabel lblFondoEnunciado;
	private JButton btnEnunciado;
	private JButton btnPistas;
	private final int[][] coordenadasIniciales = { { 30, 35 }, { 230, 435 }, { 30, 435 }, { 230, 35 }, { 30, 235 },
			{ 230, 235 } };
	private final int[][] coordenadasCorrectas = { { 500, 25 }, { 500, 225 }, { 500, 425 }, { 700, 25 }, { 700, 225 },
			{ 700, 425 } };
	private Font fontPersonal;
	private JButton btnPrimeraPista;
	private JButton btnSegundaPista;
	private JButton btnTerceraPista;
	private JButton btnCerrar;
	private JButton btnDiario;

	public BSegundaPruebaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ArrayList<JLabel> listaPosicionesCorrectas = new ArrayList<JLabel>();
		ArrayList<JLabel> listaTrozosPapel = new ArrayList<JLabel>();

		try {
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Marker_SD.ttf"));
			fontPersonal = fontPersonal.deriveFont(50f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);

		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}

		// TODO REVISAR ESTA PARTE DEL CODIGO.
		ImageIcon fondoEnunciado = crearScaledImage("imagenes/fondoEnunciado.png", 1266, 683);

		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, 1266, 683);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		contentPane.add(enunciadoPane);

		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1246, 663);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(fontPersonal);
		lblEnunciado.setText(
				"<html><center><p>PRUEBA 02</p><br><p>Mientras examinas el lugar, notas varios trozos de papel rotos esparcidos por el suelo. Intentas leerlos, pero no les encuentras sentido.</p><br><p>Al darles la vuelta, descubres que cada fragmento tiene un n\u00FAmero escrito.</p><br><p>Descubre c\u00F3mo deben estar ordenados.</p></center></html>");
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);

		btnPrimeraPista = new JButton("<html><center><p>DESBLOQUEAR PRIMERA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnPrimeraPista.setBounds(265, 180, 740, 100);
		btnPrimeraPista.setVisible(false);
		enunciadoPane.add(btnPrimeraPista);

		btnSegundaPista = new JButton("<html><center><p>DESBLOQUEAR SEGUNDA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnSegundaPista.setBounds(265, 290, 740, 100);
		btnSegundaPista.setVisible(false);
		enunciadoPane.add(btnSegundaPista);

		btnTerceraPista = new JButton("<html></center><p>DESBLOQUEAR TERCERA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnTerceraPista.setBounds(265, 400, 740, 100);
		btnTerceraPista.setVisible(false);
		enunciadoPane.add(btnTerceraPista);

		ImageIcon imgCerrar = crearScaledImage("imagenes/simboloCerrar.png", 100, 100);
		ImageIcon imgCerrarRojo = crearScaledImage("imagenes/simboloCerrarRojo.png", 100, 100);
	
		btnCerrar = new JButton();
		btnCerrar.setBounds(1120, 30, 100, 100);
		btnCerrar.setBackground(null);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setIcon(imgCerrar);
		enunciadoPane.add(btnCerrar);

		lblFondoEnunciado = new JLabel();
		lblFondoEnunciado.setBounds(10, 10, 1246, 663);
		lblFondoEnunciado.setIcon(fondoEnunciado);
		enunciadoPane.add(lblFondoEnunciado);
		
		btnDiario = new JButton("DIARIO");
		btnDiario.setOpaque(false);
		btnDiario.setBounds(1027, 50, 182, 50);
		contentPane.add(btnDiario);
		
		btnEnunciado = new JButton("ENUNCIADO");
		btnEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(true);
				visibilidadEnunciadoPane(true, false);
			}
		});
		btnEnunciado.setOpaque(false);
		btnEnunciado.setBounds(1027, 120, 182, 50);
		contentPane.add(btnEnunciado);

		btnPistas = new JButton("PISTAS");
		btnPistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(true);
				visibilidadEnunciadoPane(false, true);
			}
		});
		btnPistas.setOpaque(false);
		btnPistas.setBounds(1027, 190, 182, 50);
		contentPane.add(btnPistas);

		// Crear los JLabel con la funcionalidad de arrastre
		crearTrozosPapel(listaPosicionesCorrectas, listaTrozosPapel);
		// Creamos las zonas correctas
		crearPosicionCorrecta(listaPosicionesCorrectas, coordenadasCorrectas);

		ImageIcon fondoPantalla = crearScaledImage("imagenes/FondoSegundaPruebaPupitre.png", 1280, 720);

		JButton btnListo = new JButton("LISTO");
		btnListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean todoCorrecto = true;
				if (!comprobarResultado(listaPosicionesCorrectas, listaTrozosPapel)) {
					todoCorrecto = false;
				}
				if (todoCorrecto) {
					System.out.println("¡Todo correcto!");
				} else {
					System.out.println("Algunos trozos no están en el lugar correcto.");
				}
			}

		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListo.setBounds(1028, 531, 182, 100);
		btnListo.setOpaque(false);
		contentPane.add(btnListo);

		btnCerrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				
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
		contentPane.add(lblImagenFondo);
	}

	private ImageIcon crearScaledImage(String rutaImagen, int x, int y) {
		ImageIcon icono = new ImageIcon(rutaImagen);
		Image img = icono.getImage();
		Image img2 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(img2);
		return scaledImg;
	}

	private void crearPosicionCorrecta(ArrayList<JLabel> listaPosicionesCorrectas, int[][] posicionesCorrectas) {
		for (int i = 0; i < posicionesCorrectas.length; i++) {
			JLabel posicionCorrecta = crearPosicionCorrecta(posicionesCorrectas[i][0], posicionesCorrectas[i][1]);
			listaPosicionesCorrectas.add(posicionCorrecta);
			contentPane.add(posicionCorrecta);
		}
	}

	private void crearTrozosPapel(ArrayList<JLabel> listaPosicionesCorrectas, ArrayList<JLabel> listaTrozosPapel) {
		for (int i = 0; i < coordenadasIniciales.length; i++) {
			JLabel trozoPapel = crearLabel(coordenadasIniciales[i][0], coordenadasIniciales[i][1], i);
			listaTrozosPapel.add(trozoPapel);
			contentPane.add(trozoPapel);

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
				trozoPapel.setLocation(coordenadasIniciales[i][0], coordenadasIniciales[i][1]);
			}
		};
		return soltarRaton;
	}

	private MouseMotionListener trozoPapelMouseDragged(JLabel trozoPapel) {
		MouseMotionListener moverRaton = new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent raton) {
				// Actualizar la posición mientras se arrastra
				trozoPapel.setLocation(
						Math.max(0,
								Math.min(
										raton.getXOnScreen() - contentPane.getLocationOnScreen().x
												- trozoPapel.getWidth() / 2,
										contentPane.getWidth() - trozoPapel.getWidth())),
						Math.max(0,
								Math.min(
										raton.getYOnScreen() - contentPane.getLocationOnScreen().y
												- trozoPapel.getHeight() / 2,
										contentPane.getHeight() - trozoPapel.getHeight())));
			}
		};
		return moverRaton;
	}

	private void visibilidadEnunciadoPane(boolean visibilidadEnunciado, boolean visibilidadPista) {
		lblEnunciado.setVisible(visibilidadEnunciado);

		btnPrimeraPista.setVisible(visibilidadPista);
		btnSegundaPista.setVisible(visibilidadPista);
		btnTerceraPista.setVisible(visibilidadPista);
	}

	// METODO Creacion label
	private JLabel crearLabel(int x, int y, int i) {
		ImageIcon icon = new ImageIcon(obtenerPosicionImagen(i));
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		JLabel etiqueta = new JLabel("Trozo");
		etiqueta.setForeground(Color.RED);
		etiqueta.setBackground(Color.RED);
		etiqueta.setOpaque(true);
		etiqueta.setIcon(scaledIcon);
		etiqueta.setBounds(x, y, 175, 175);
		etiqueta.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		return etiqueta;
	}

	// METODO Obtener una imagen
	private String obtenerPosicionImagen(int num) {
		String[] posicion = { "imagenes/SegundaPrueba/Numero3.png", "imagenes/SegundaPrueba/Numero8.png",
				"imagenes/SegundaPrueba/Numero9.png", "imagenes/SegundaPrueba/Numero12.png",
				"imagenes/SegundaPrueba/Numero15.png", "imagenes/SegundaPrueba/Numero17.png" };
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
