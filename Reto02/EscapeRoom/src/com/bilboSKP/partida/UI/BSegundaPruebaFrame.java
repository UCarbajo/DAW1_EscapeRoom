package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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
	private JButton btnContinuar;
	private final int[][] coordenadasIniciales = { { 150, 50 }, { 900, 463 }, { 150, 463 }, { 900, 50 }, { 150, 255 },{ 900, 255 } };
	private final int[][] coordenadasCorrectas = { { 387, 25 }, { 387, 235 }, { 387, 445 }, { 614, 25 }, { 614, 235 },{ 614, 445 } };
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
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/AppleGaramond.ttf"));
			fontPersonal = fontPersonal.deriveFont(30f);
		} catch (FontFormatException | IOException e1) {
			System.out.println("Error, font no cargado.");
			e1.printStackTrace();
		}
		
		//TODO REVISAR ESTA PARTE DEL CODIGO.
		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, 1266, 683);
		enunciadoPane.setOpaque(true);
		enunciadoPane.setBackground(new Color(255, 255, 255, 10));
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		contentPane.add(enunciadoPane);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds((enunciadoPane.getWidth() - 550) / 2, 572, 550, 50);
		btnContinuar.setFont(fontPersonal);
		btnContinuar.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				activarMouseListener(listaTrozosPapel, listaPosicionesCorrectas);
			}
		});
		enunciadoPane.add(btnContinuar);
		
		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1246, 663);
		lblEnunciado.setOpaque(true);
		lblEnunciado.setFont(fontPersonal);
		lblEnunciado.setText("<html><center>Esto es una prueba, Esto es una prueba, Esto es una prueba, Esto es una prueba, Esto es una prueba, Esto es una prueba, Esto es una prueba </center></html>");
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);

		// Crear los JLabel con la funcionalidad de arrastre
		crearTrozosPapel(listaPosicionesCorrectas, listaTrozosPapel);
		desactivarMouseListener(listaTrozosPapel);
		// Creamos las zonas correctas
		crearPosicionCorrecta(listaPosicionesCorrectas, coordenadasCorrectas);

		ImageIcon icono = new ImageIcon("imagenes/FondoSegundaPrueba.png");
		Image img = icono.getImage();
		Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imgEscalado);

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
		btnListo.setBounds(1100, 500, 100, 100);
		btnListo.setOpaque(false);
		btnListo.setEnabled(false);
		contentPane.add(btnListo);

		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(iconoEscalado);
		contentPane.add(lblImagenFondo);
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
				// Verificar si el JLabel está dentro de una de las zonas correctas
				for (JLabel zona : listaPosicionesCorrectas) {
					if (zona.getBounds().contains(trozoPapel.getBounds())) {
						// Fijar el JLabel en la posición de la zona correcta
						trozoPapel.setLocation(zona.getX() + zona.getWidth() / 8, zona.getY() + zona.getHeight() / 8);
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

	// METODO Creacion label
	private JLabel crearLabel(int x, int y, int i) {
		ImageIcon icon = new ImageIcon(obtenerPosicionImagen(i));
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		JLabel etiqueta = new JLabel("Trozo");
		etiqueta.setForeground(Color.RED);
		etiqueta.setBackground(Color.RED);
		etiqueta.setOpaque(true);
		etiqueta.setIcon(scaledIcon);
		etiqueta.setBounds(x, y, 150, 150);
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
