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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class BSegundaPruebaFrame extends JFrame {

	private JPanel contentPane;
	private JPanel enunciadoPane;
	private JLabel lblEnunciado;
	private JLabel lblFondoEnunciado;
	private JButton btnContinuar;
	private final int[][] coordenadasIniciales = { { 30, 35 }, { 230, 435 }, { 30, 435 }, { 230, 35 }, { 30, 235 },{ 230, 235 } };
	private final int[][] coordenadasCorrectas = { { 500, 25 }, { 500, 225 }, { 500, 425 }, { 700, 25 }, { 700, 225 },{ 700, 425 } };
	private Font fontPersonal;
	
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
		
		//TODO REVISAR ESTA PARTE DEL CODIGO.
		ImageIcon fondoEnunciado = crearScaledImage("imagenes/fondoEnunciado.png", 1266, 683);
		
		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, 1266, 683);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		contentPane.add(enunciadoPane);
		
		btnContinuar = new JButton("<html><center>Continuar</center></html>");
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent raton) {
				btnContinuar.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent raton) {
				btnContinuar.setForeground(Color.black);
			}
		});
		
		JButton btnPistas= new JButton("LISTO");
		btnPistas.setOpaque(false);
		btnPistas.setEnabled(false);
		btnPistas.setBounds(1061, 390, 149, 100);
		contentPane.add(btnPistas);
		
		btnContinuar.setBounds((enunciadoPane.getWidth() - 320) / 2, 572, 320, 60);
		btnContinuar.setFont(fontPersonal);
		btnContinuar.setForeground(Color.black);
		btnContinuar.setOpaque(false);
		btnContinuar.setBackground(null);
		btnContinuar.setBorderPainted(true);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setFocusPainted(false);
		btnContinuar.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.black));

		enunciadoPane.add(btnContinuar);
		
		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1246, 663);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(fontPersonal);
		lblEnunciado.setText("<html><center><p>PRUEBA 02</p><br><p>Te encuentras varios trozos de papel rotos en el suelo, intentas leerlos, pero no les encuentras sentido.</p><br><p>Al darles la vuelta, te das cuenta de que cada trozo tiene un n\u00FAmero escrito.</p><br><p>Descubre c\u00F3mo tienen que estar ordenados.</p></center></html>");
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);
		
		lblFondoEnunciado = new JLabel();
		lblFondoEnunciado.setBounds(10,10, 1246, 663);
		lblFondoEnunciado.setIcon(fondoEnunciado);
		enunciadoPane.add(lblFondoEnunciado);
		
		
		// Crear los JLabel con la funcionalidad de arrastre
		crearTrozosPapel(listaPosicionesCorrectas, listaTrozosPapel);
		desactivarMouseListener(listaTrozosPapel);
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
					System.out.println("�Todo correcto!");
				} else {
					System.out.println("Algunos trozos no est�n en el lugar correcto.");
				}
			}

		});
		btnListo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnListo.setBounds(1061, 531, 149, 100);
		btnListo.setOpaque(false);
		btnListo.setEnabled(false);
		
		contentPane.add(btnListo);

		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				activarMouseListener(listaTrozosPapel, listaPosicionesCorrectas);
				btnListo.setEnabled(true);
			}
		});
		
		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(fondoPantalla);
		contentPane.add(lblImagenFondo);
	}

	private ImageIcon crearScaledImage(String string, int x, int y) {
		ImageIcon icono = new ImageIcon(string);
		Image img = icono.getImage();
		Image img2 = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
		ImageIcon scaledImg = new ImageIcon(img2);
		return scaledImg;
	}

	private void desactivarMouseListener(ArrayList<JLabel> listaTrozosPapel) {
		for(JLabel trozoPapel: listaTrozosPapel) {
			for(MouseListener mouseListener:trozoPapel.getMouseListeners()) {
				trozoPapel.removeMouseListener(mouseListener);
			}
			for(MouseMotionListener mouseMotion:trozoPapel.getMouseMotionListeners()) {
				trozoPapel.removeMouseMotionListener(mouseMotion);
			}
		}
	}

	private void activarMouseListener(ArrayList<JLabel> listaTrozosPapel, ArrayList<JLabel> listaPosicionesCorrectas) {
		for(int i = 0; i < listaTrozosPapel.size(); i++) {
				JLabel trozoPapel = listaTrozosPapel.get(i);
				trozoPapel.addMouseListener(trozoPapelMouseRelease(listaPosicionesCorrectas, trozoPapel, i));
				trozoPapel.addMouseMotionListener(trozoPapelMouseDragged(trozoPapel));
			}
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
				// Verificar si el JLabel est� dentro de una de las zonas correctas
				for (JLabel zona : listaPosicionesCorrectas) {
					if (zona.getBounds().contains(trozoPapel.getBounds())) {
						// Fijar el JLabel en la posici�n de la zona correcta
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
				// Actualizar la posici�n mientras se arrastra
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
