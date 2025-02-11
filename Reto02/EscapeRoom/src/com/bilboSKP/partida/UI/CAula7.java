package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.bilboSKP.partida.Pista;

import herramientas.ImageRescaler;

public class CAula7 extends JPanel {

	// Constantes de tamaño
	private static final int TAMANO_FRAME_X = 1280;
	private static final int TAMANO_FRAME_Y = 720;

	// Paneles y componentes
	private JPanel contentPane;
	private JPanel enunciadoPane;
	private JPanel panelPrueba;
	private JPanel darkOverlay;
	private JLabel lblEnunciado;
	private JLabel lblTiempo;
	private JLabel lblLeccion;
	private JLabel lblContinuar;
	private JButton btnEnunciado;
	private JButton btnPrimeraPista;
	private JButton btnSegundaPista;
	private JButton btnTerceraPista;
	private JButton btnPistas;

	// Fuentes
	private Font font;
	private Font font2;
	private Font fontLeccion;

	// Variables adicionales
	private int numeroClicks = 0;
	private JButton btnCerrar;
	private Font fontTextoPrueba;
	private ResourceBundle idioma;

	public CAula7(AEntradaJuego aEntradaJuego, Locale local) {
		setBounds(0, 0, 1400, 720);
		setLayout(null);

		cambiarIdioma(local);
		cargarFuentes();
		inicializarComponentes(aEntradaJuego, local);
		configurarEventos();
	}

	private void cambiarIdioma(Locale local) {
		try {
		    Locale locale = local;
		    idioma = ResourceBundle.getBundle("idioma.menuInicio", locale);
		} catch (MissingResourceException e) {
			System.out.println("Error de locale");
		    e.printStackTrace();  // Verifica el error
		}
	}

	private void cargarFuentes() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf"))
					.deriveFont(Font.PLAIN, 40);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);

			fontLeccion = font.deriveFont(Font.PLAIN, 40);
			ge.registerFont(fontLeccion);

			fontTextoPrueba = font.deriveFont(60f);
			ge.registerFont(fontTextoPrueba);
			
			font2 = font.deriveFont(Font.PLAIN, 8);
			ge.registerFont(font2);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	private void inicializarComponentes(AEntradaJuego aEntradaJuego, Locale local) {
		// Panel principal con imagen de fondo
		contentPane = new PanelImagen("/imagenes/aula7.jpg"); // Cambiado img/aula7.jpg por imagenes/aula7.jpg
		contentPane.setBounds(0, 0, TAMANO_FRAME_X, TAMANO_FRAME_Y);
		contentPane.setLayout(null);
		add(contentPane);

		// Panel del enunciado
		inicializarEnunciadoPane();

		// Botones y etiquetas
		inicializarBotones(aEntradaJuego, local);
		inicializarLabels();

		// Panel de la prueba
		inicializarPanelPrueba();

		// Panel de oscurecimiento
		inicializarDarkOverlay();
	}

	private void inicializarEnunciadoPane() {
		enunciadoPane = new PanelImagen("/imagenes/fondoEnunciado.png"); // Cambiado img/fondoEnunciado.png por imagenes/fondoEnunciado.png
		enunciadoPane.setBounds(0, 0, 1400, 720);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		enunciadoPane.setVisible(false);
		contentPane.add(enunciadoPane);

		ImageIcon imgCerrar = ImageRescaler.scaleImage("/imagenes/simboloCerrar.png", 100, 100); // Cambiado img/simboloCerrar.png por imagenes/simboloCerrar.png
		ImageIcon imgCerrarRojo = ImageRescaler.scaleImage("/imagenes/simboloCerrarRojo.png", 100, 100); // Cambiado img/simboloCerrarRojo.png por imagenes/simboloCerrarRojo.png

		btnCerrar = new JButton();
		btnCerrar.setBounds(1120, 30, 100, 100);
		btnCerrar.setBackground(null);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setIcon(imgCerrar);
		enunciadoPane.add(btnCerrar);
		
		btnCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				panelPrueba.setVisible(true);
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
		
		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1280, 699);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(font);
		lblEnunciado.setText(idioma.getString("label.descripcionEnunciadoTerceraPrueba"));
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);

		// Botones de pistas (inicialmente ocultos)
		btnPrimeraPista = new JButton(idioma.getString("label.primeraPista"));
		btnPrimeraPista.setBounds(265, 180, 740, 100);
		btnPrimeraPista.setVisible(false);
		enunciadoPane.add(btnPrimeraPista);

		btnSegundaPista = new JButton(idioma.getString("label.segundaPista"));
		btnSegundaPista.setBounds(265, 290, 740, 100);
		btnSegundaPista.setVisible(false);
		enunciadoPane.add(btnSegundaPista);

		btnTerceraPista = new JButton(idioma.getString("label.terceraPista"));
		btnTerceraPista.setBounds(265, 400, 740, 100);
		btnTerceraPista.setVisible(false);
		enunciadoPane.add(btnTerceraPista);
	}

	private void inicializarBotones(AEntradaJuego aEntradaJuego, Locale local) {
		btnEnunciado = new JButton();
		btnEnunciado.setVisible(false);
		btnEnunciado.setOpaque(true);
		btnEnunciado.setBackground(null);
		btnEnunciado.setContentAreaFilled(false);
		btnEnunciado.setFocusable(false);
		btnEnunciado.setBorder(null);
		btnEnunciado.setIcon(ImageRescaler.scaleImage("/imagenes/iconoEnunciado.png", 100, 80)); // Cambiado img/iconoEnunciado.png por imagenes/iconoEnunciado.png
		btnEnunciado.setBounds((aEntradaJuego.getIconoPanel().getWidth() - 100) / 2, 150, 100, 80);
		aEntradaJuego.getIconoPanel().add(btnEnunciado);

		btnPistas = new JButton();
		btnPistas.setVisible(false);
		btnPistas.setOpaque(true);
		btnPistas.setIcon(ImageRescaler.scaleImage("/imagenes/iconoPista.png", 100, 80)); // Cambiado img/iconoPista.png por imagenes/iconoPista.png
		btnPistas.setBackground(null);
		btnPistas.setContentAreaFilled(false);
		btnPistas.setFocusable(false);
		btnPistas.setBorder(null);
		btnPistas.setBounds((aEntradaJuego.getIconoPanel().getWidth()-100)/2, 250, 100, 80);
		aEntradaJuego.getIconoPanel().add(btnPistas);
	}

	private void inicializarLabels() {
		lblTiempo = new JLabel();
		lblTiempo.setBounds(71, 11, 170, 48);
		lblTiempo.setFont(new Font("Uncial Antiqua", Font.BOLD, 20));
		lblTiempo.setForeground(Color.WHITE);
		contentPane.add(lblTiempo);

		// Asumiendo que TimerManager es una clase que maneja el cronómetro
		// TimerManager.getInstance().setLblTiempo(lblTiempo);

		// Etiqueta con la frase clicable

		JLabel frase = new JLabel(idioma.getString("label.textoSala"));
		frase.setBounds(1030, 454, 128, 50);
		frase.setHorizontalTextPosition(SwingConstants.CENTER);
		frase.setHorizontalAlignment(SwingConstants.CENTER);
		frase.setFont(font2);
		frase.setBackground(Color.WHITE);
		frase.setForeground(Color.BLACK);
		contentPane.add(frase);

		frase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enunciadoPane.setVisible(true);
				panelPrueba.setVisible(false);
				btnEnunciado.setVisible(true);
				btnPistas.setVisible(true);
				frase.setVisible(false);
			}
		});
	}

	private void inicializarPanelPrueba() {
	    panelPrueba = new PanelImagen("/imagenes/whiteboard.png");
	    panelPrueba.setVisible(false);
	    panelPrueba.setSize(TAMANO_FRAME_X, TAMANO_FRAME_Y);
	    panelPrueba.setLayout(null);
	    contentPane.add(panelPrueba);

	    JLabel lblTriste = new JLabel(idioma.getString("label.textoTriste"));
	    lblTriste.setBounds(200, 150, 700, 152);
	    lblTriste.setFont(fontTextoPrueba);
	    panelPrueba.add(lblTriste);

	    JLabel lblHabla = new JLabel(idioma.getString("label.textoHabla"));
	    lblHabla.setBounds(200, 300, 700, 152);
	    lblHabla.setFont(fontTextoPrueba);
	    panelPrueba.add(lblHabla);

	    JLabel label1 = new JLabel(idioma.getString("label.textoPalabraUno"));
	    label1.setBounds(200, 500, 200, 30);
	    label1.setFont(new Font("Arial", Font.BOLD, 40));
	    panelPrueba.add(label1);

	    JTextField entrada1 = new JTextField(10);
	    entrada1.setBounds(400, 495, 200, 50);
	    entrada1.setFont(new Font("Arial", Font.BOLD, 40));
	    panelPrueba.add(entrada1);

	    JLabel label2 = new JLabel(idioma.getString("label.textoPalabraDos"));
	    label2.setBounds(800, 500, 200, 30);
	    label2.setFont(new Font("Arial", Font.BOLD, 40));
	    panelPrueba.add(label2);

	    JTextField entrada2 = new JTextField(10);
	    entrada2.setBounds(1000, 495, 200, 50);
	    entrada2.setFont(new Font("Arial", Font.BOLD, 40));
	    panelPrueba.add(entrada2);

	    JButton verificar = new JButton(idioma.getString("label.textoVerificar"));
	    verificar.setBounds((enunciadoPane.getWidth()-200)/2, 600, 200, 50);
	    verificar.setFont(new Font("Arial", Font.BOLD, 30));
	    panelPrueba.add(verificar);

	    verificar.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String palabra1 = entrada1.getText().trim().toLowerCase();
	            String palabra2 = entrada2.getText().trim().toLowerCase();

	            if ((palabra1.equals("triste") && palabra2.equals("habla")) || (palabra1.equals("sad") && palabra2.equals("talks"))) {
	                JOptionPane.showMessageDialog(null, idioma.getString("label.textoMenuCorrecto"));
	                panelPrueba.setVisible(false);
	                lblLeccion.setVisible(true);
	                darkOverlay.setVisible(true);
	                lblContinuar.setVisible(true);
	                btnEnunciado.setVisible(false);
	                btnPistas.setVisible(false);
	            } else {
	                JOptionPane.showMessageDialog(null, idioma.getString("label.textoMenuIncorrecto"));
	            }
	        }
	    });

	    lblLeccion = new JLabel(idioma.getString("label.textoLeccion"));
	    lblLeccion.setBounds(310, 237, 653, 300);
	    lblLeccion.setForeground(Color.WHITE);
	    lblLeccion.setFont(fontLeccion);
	    lblLeccion.setVisible(false);
	    contentPane.add(lblLeccion);

	    lblContinuar = new JLabel(idioma.getString("label.continuar"));
	    lblContinuar.setBounds((enunciadoPane.getWidth()-200)/2, 542, 200, 29);
	    lblContinuar.setForeground(Color.WHITE);
	    lblContinuar.setFont(font);
	    lblContinuar.setVisible(false);
	    contentPane.add(lblContinuar);
	}

	private void inicializarDarkOverlay() {
	    darkOverlay = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            Graphics2D g2d = (Graphics2D) g.create();
	            g2d.setColor(new Color(0, 0, 0, 160));
	            g2d.fillRect(0, 0, getWidth(), getHeight());
	            g2d.dispose();
	        }
	    };
	    darkOverlay.setOpaque(false);
	    darkOverlay.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
	    darkOverlay.setVisible(false);
	    contentPane.add(darkOverlay);
	}

	private void configurarEventos() {

		// Evento para el botón "Enunciado"
		btnEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibilidadEnunciadoPane(true, false);
			}
		});

		// Evento para el botón de pistas
		btnPistas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				visibilidadEnunciadoPane(false, true);
			}
		});

		// Evento para el label "Continuar" después de resolver la prueba
		lblContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Navegar a la siguiente pantalla o acción
				// Por ejemplo:
				// CFinal v5 = new CFinal();
				// v5.setVisible(true);
				// Aquí deberías implementar la lógica para avanzar en tu aplicación
			}
		});

		// Evento para el contentPane (incrementar número de clics)
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeroClicks++;
			}
		});
	
	}

	private void visibilidadEnunciadoPane(boolean visibilidadEnunciado, boolean visibilidadPista) {
		enunciadoPane.setVisible(true);
		lblEnunciado.setVisible(visibilidadEnunciado);
		btnPrimeraPista.setVisible(visibilidadPista);
		btnSegundaPista.setVisible(visibilidadPista);
		btnTerceraPista.setVisible(visibilidadPista);
	}

	// Clase interna para cargar imágenes de fondo en paneles
	private class PanelImagen extends JPanel {
		private Image imagen;

		public PanelImagen(String ruta) {
			this.imagen = new ImageIcon(getClass().getResource(ruta)).getImage();
			setLayout(null);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
