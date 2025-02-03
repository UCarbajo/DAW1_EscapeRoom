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
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class EntradaJuego extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnenEstaEscuela;
	private JLabel lblIntroduccion;
	private JLabel lblMouseAnimacion;
	private ResourceBundle idioma;
	private Locale locale;

	public EntradaJuego(Locale local) {
		
		cambiarIdioma(local);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// TODO ESTA PARTE NO ESTA OPERATIVA
		contentPane.addMouseListener(animacionPulsarRaton());

		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			Font fontPersonal = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/AppleGaramond.ttf"));
			fontPersonal = fontPersonal.deriveFont(30f);

			// TODO USAR EN ESTA PARTE DE CODIGO EN CASO DE QUE NO CARGUE EL FONT
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);

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
		} catch (FontFormatException | IOException e) {
			System.out.println("No ha cargado el font correctamente");
			e.printStackTrace();
		}

		ImageIcon icon = new ImageIcon("imagenes/entradaCole.jpeg");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(scaledIcon);
		lblEntradaCole.setBounds(0, 0, 1280, 692);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);
		contentPane.add(lblEntradaCole);
	}
	
	private void cambiarIdioma(Locale local) {
        locale = local;  
        idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
    }
	
//TODO ESTA PARTE PERMITE GENERA UNA ANIMACION SOBRE EL PUNTERO DEL RATON AL PULSARLO
//	   NO FUNCIONA SI EL RATON ESTA EN MOVIMIENTO
	
	public MouseListener animacionPulsarRaton() {
		return new MouseAdapter() {
			private JLabel lblMouseAnimacion = null; // El JLabel para la animaci�n
			private Timer currentTimer; // Para guardar el Timer actual

			@Override
			public void mouseClicked(MouseEvent e) {
				// Si ya hay una animaci�n en pantalla, la eliminamos antes de crear una nueva
				if (lblMouseAnimacion != null && lblMouseAnimacion.getParent() != null) {
					contentPane.remove(lblMouseAnimacion);
					contentPane.revalidate();
					contentPane.repaint();
				}

				// Creamos una nueva animaci�n
				ImageIcon animacion = new ImageIcon("imagenes/mouseClickAnimation.gif");
				lblMouseAnimacion = new JLabel(animacion);
				int width = animacion.getIconWidth();
				int height = animacion.getIconHeight();
				lblMouseAnimacion.setBounds(e.getX() - width / 2, e.getY() - height / 2, width, height);

				contentPane.add(lblMouseAnimacion);
				contentPane.revalidate();
				contentPane.repaint();

				// Iniciamos un nuevo Timer para eliminar la animaci�n despu�s de 400ms
				if (currentTimer != null && currentTimer.isRunning()) {
					currentTimer.stop(); // Detenemos el Timer anterior si est� corriendo
				}

				currentTimer = new Timer(400, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						contentPane.remove(lblMouseAnimacion);
						contentPane.revalidate();
						contentPane.repaint();
					}
				});
				currentTimer.start(); // Iniciamos el nuevo Timer
			}
		};
	}
}
