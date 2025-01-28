package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BSegundaPruebaFrame extends JFrame {

	private JPanel contentPane;
	int num = 0;

	public BSegundaPruebaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ArrayList<JLabel> listaPosicionesCorrectas = new ArrayList<JLabel>();
		ArrayList<JLabel> listaTrozosPapel = new ArrayList<JLabel>();

		// Creamos las posiciones donde deben ser colocados los trozos de papel.
		int[][] posicionesCorrectas = {
	            {387, 25}, {387, 235}, {387, 445},
	            {614, 25}, {614, 235}, {614, 445}
	        };

		// Definir las posiciones iniciales de los JLabel
		int[][] posicionesIniciales = {
	            {150, 50}, {900, 463}, {150, 463},
	            {900, 50}, {150, 255}, {900, 255}
	        };

		// Crear los JLabel con la funcionalidad de arrastre
		for (int i = 0; i < posicionesIniciales.length; i++) {
			JLabel trozoPapel = crearLabel(posicionesIniciales[i][0], posicionesIniciales[i][1]);
			listaTrozosPapel.add(trozoPapel);
			int posicionX = posicionesIniciales[i][0];
			int posicionY = posicionesIniciales[i][1];
			contentPane.add(trozoPapel);

			trozoPapel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent raton) {
					// Verificar si el JLabel está dentro de una de las zonas correctas
					for (JLabel zona : listaPosicionesCorrectas) {
						if (zona.getBounds().contains(trozoPapel.getBounds())) {
							// Fijar el JLabel en la posición de la zona correcta
							trozoPapel.setLocation(zona.getX() + zona.getWidth() / 8,
									zona.getY() + zona.getHeight() / 8);
							return; // Salir del bucle, ya que hemos encontrado la zona
						}
					}
					trozoPapel.setLocation(posicionX, posicionY);
				}
			});
			trozoPapel.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseDragged(MouseEvent raton) {
					// Actualizar la posición mientras se arrastra
					trozoPapel
							.setLocation(
									Math.max(
											0, Math
													.min(raton.getXOnScreen() - contentPane.getLocationOnScreen().x
															- trozoPapel.getWidth() / 2,
															contentPane.getWidth() - trozoPapel.getWidth())),
									Math.max(0,
											Math.min(
													raton.getYOnScreen() - contentPane.getLocationOnScreen().y
															- trozoPapel.getHeight() / 2,
													contentPane.getHeight() - trozoPapel.getHeight())));
				}
			});
		}
		// Creamos las zonas correctas
		for (int i = 0; i < posicionesCorrectas.length; i++) {
			JLabel posicionCorrecta = crearPosicionCorrecta(posicionesCorrectas[i][0],posicionesCorrectas[i][1]);
			listaPosicionesCorrectas.add(posicionCorrecta);
			contentPane.add(posicionCorrecta);
		}

		ImageIcon icono = new ImageIcon("imagenes/FondoSegundaPrueba.png");
		Image img = icono.getImage();
		Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imgEscalado);

		JButton btnNewButton = new JButton("LISTO");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(1100, 500, 100, 100);
		contentPane.add(btnNewButton);

		JLabel lblImagenFondo = new JLabel("");
		lblImagenFondo.setBounds(0, 0, 1280, 720);
		lblImagenFondo.setIcon(iconoEscalado);
		contentPane.add(lblImagenFondo);
	}

	// METODO Creacion label
	private JLabel crearLabel(int x, int y) {
		ImageIcon icon = new ImageIcon(obtenerPosicionImagen(num));
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

		num++;
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
	
	private boolean comprobarResultado(ArrayList<JLabel> listaPosicionesCorrectas,
			ArrayList<JLabel> listaTrozosPapel) {
		return (listaPosicionesCorrectas.get(0).getBounds().contains(listaTrozosPapel.get(3).getBounds())
		&& listaPosicionesCorrectas.get(1).getBounds().contains(listaTrozosPapel.get(4).getBounds())
		&& listaPosicionesCorrectas.get(2).getBounds().contains(listaTrozosPapel.get(0).getBounds())
		&& listaPosicionesCorrectas.get(3).getBounds().contains(listaTrozosPapel.get(1).getBounds())
		&& listaPosicionesCorrectas.get(4).getBounds().contains(listaTrozosPapel.get(5).getBounds())
		&& listaPosicionesCorrectas.get(5).getBounds().contains(listaTrozosPapel.get(2).getBounds())) 
		||
		  (listaPosicionesCorrectas.get(0).getBounds().contains(listaTrozosPapel.get(1).getBounds())
		&& listaPosicionesCorrectas.get(1).getBounds().contains(listaTrozosPapel.get(5).getBounds())
		&& listaPosicionesCorrectas.get(2).getBounds().contains(listaTrozosPapel.get(2).getBounds())
		&& listaPosicionesCorrectas.get(3).getBounds().contains(listaTrozosPapel.get(3).getBounds())
		&& listaPosicionesCorrectas.get(4).getBounds().contains(listaTrozosPapel.get(4).getBounds())
		&& listaPosicionesCorrectas.get(5).getBounds().contains(listaTrozosPapel.get(0).getBounds()));
	}
}
