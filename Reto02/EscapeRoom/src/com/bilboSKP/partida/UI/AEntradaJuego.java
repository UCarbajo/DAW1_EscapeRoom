package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import herramientas.ImageRescaler;
import herramientas.TimerManager;

public class AEntradaJuego extends JFrame {

	private JPanel contentPane;
	private JPanel menuInteractivoPane;
	private ZDiarioFrame diario;
	private APasilloFrame pasilloPane;
	private JTextPane txtpnenEstaEscuela;
	private JLabel lblIntroduccion;
	private ResourceBundle idioma;
	private Locale locale;
	private JButton btnFlechaArriba;
	private Font fontPersonal;
	private JButton btnDiario;
	private JPanel inicioPane;
	private JPanel navegacionPane;
	private JLabel lblTiempo;
	private TimerManager timeManager;
	private JPanel iconoPanel;

	public AEntradaJuego(Locale local) {

		cambiarIdioma(local);
		timeManager = TimerManager.getInstance();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1400, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);

		menuInteractivoPane = new JPanel();
		menuInteractivoPane.setBounds(0, 0, 1280, 720);
		menuInteractivoPane.setLayout(null);
		menuInteractivoPane.setVisible(false);
		menuInteractivoPane.setOpaque(false);

		iconoPanel = new JPanel();
		iconoPanel.setBounds(1290, 11, 100, 698);
		iconoPanel.setLayout(null);
		contentPane.add(iconoPanel);
		
		btnDiario = new JButton();
		btnDiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuInteractivoPane.isVisible()) {
					menuInteractivoPane.setVisible(false);
					navegacionPane.setVisible(true);
					contentPane.repaint();
					contentPane.revalidate();
				} else {
					menuInteractivoPane.setVisible(true);
					navegacionPane.setVisible(false);
					contentPane.setComponentZOrder(menuInteractivoPane, 0);
					contentPane.repaint();
					contentPane.revalidate();
				}
			}
		});
		btnDiario.setBackground(null);
		btnDiario.setContentAreaFilled(false);
		btnDiario.setFocusable(false);
		btnDiario.setBorder(null);
		btnDiario.setIcon(ImageRescaler.scaleImage("/imagenes/iconoDiario.png", 100, 80));
		btnDiario.setOpaque(true);
		btnDiario.setVisible(false);
		btnDiario.setBounds(0, 53, 100, 80);
		iconoPanel.add(btnDiario);
		contentPane.add(menuInteractivoPane);

		lblTiempo = new JLabel("60:00");
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setForeground(Color.BLACK);
		lblTiempo.setBorder(new LineBorder(Color.black, 2));
		lblTiempo.setBounds(0, 0, 100, 42);
		iconoPanel.add(lblTiempo);
		timeManager.setLblTiempo(lblTiempo);
		lblTiempo.setFont(new Font("Arial", Font.PLAIN, 30));

		diario = new ZDiarioFrame(local);
		diario.setBounds(0, 0, 1280, 720);
		diario.setVisible(true);
		diario.setOpaque(true);
		menuInteractivoPane.add(diario, 0);

		navegacionPane = new JPanel();
		navegacionPane.setLayout(null);

		navegacionPane.setBounds(0, 0, 1280, 720);
		navegacionPane.setVisible(true);
		contentPane.add(navegacionPane);

		pasilloPane = new APasilloFrame(this, local);
		pasilloPane.setBounds(0, 0, 1280, 720);
		pasilloPane.setVisible(false);
		navegacionPane.add(pasilloPane);

		inicioPane = new JPanel();
		inicioPane.setBounds(0, 0, 1280, 720);
		inicioPane.setLayout(null);
		navegacionPane.add(inicioPane);

		try {
			fontPersonal = Font.createFont(Font.TRUETYPE_FONT,
					getClass().getResourceAsStream("/fonts/AppleGaramond.ttf"));
			fontPersonal = fontPersonal.deriveFont(30f);

			// TODO USAR EN ESTA PARTE DE CODIGO EN CASO DE QUE NO CARGUE EL FONT
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontPersonal);

		} catch (FontFormatException | IOException e) {
			System.out.println("No ha cargado el font correctamente");
			e.printStackTrace();
		}

		JButton btnAdelante = new JButton(idioma.getString("label.adelante"));
		btnAdelante.setBounds(560, 589, 150, 50);
		inicioPane.add(btnAdelante);

		lblIntroduccion = new JLabel(idioma.getString("label.instruccionesPantallaInicio"));
		lblIntroduccion.setBounds(0, 0, 1280, 720);
		lblIntroduccion.setBorder(new EmptyBorder(350, 350, 350, 350));
		lblIntroduccion.setForeground(Color.BLACK);
		lblIntroduccion.setFont(fontPersonal);
		lblIntroduccion.setBackground(new Color(255, 255, 255, 200));
		lblIntroduccion.setOpaque(false);
		lblIntroduccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduccion.setVerticalAlignment(SwingConstants.CENTER);
		inicioPane.add(lblIntroduccion);

		txtpnenEstaEscuela = new JTextPane();
		txtpnenEstaEscuela.setEditable(false);
		txtpnenEstaEscuela.setBounds(0, 0, 1280, 720);
		txtpnenEstaEscuela.setBackground(new Color(255, 255, 255, 180));
		txtpnenEstaEscuela.setOpaque(true);
		inicioPane.add(txtpnenEstaEscuela);

		ImageIcon imgFlechaArriba = ImageRescaler.scaleImage("/imagenes/FlechaArriba.png", 23, 50);
		btnFlechaArriba = new JButton("");
		btnFlechaArriba.setIcon(imgFlechaArriba);
		btnFlechaArriba.setOpaque(false);
		btnFlechaArriba.setContentAreaFilled(false);
		btnFlechaArriba.setBorder(null);
		btnFlechaArriba.setVisible(false);
		btnFlechaArriba.setBounds(610, 522, 100, 100);
		inicioPane.add(btnFlechaArriba);

		btnAdelante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIntroduccion.setVisible(false);
				txtpnenEstaEscuela.setVisible(false);
				btnAdelante.setVisible(false);
				btnFlechaArriba.setVisible(true);
				btnDiario.setVisible(true);
			}
		});

		btnFlechaArriba.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				inicioPane.setVisible(false);
				pasilloPane.setVisible(true);
				repaint();
				revalidate();
			}
		});
		ImageIcon fondoEntrada = ImageRescaler.scaleImage("/imagenes/entradaCole.jpeg", 1280, 720);
		JLabel lblEntradaCole = new JLabel("");
		lblEntradaCole.setIcon(fondoEntrada);
		lblEntradaCole.setBounds(0, 0, 1280, 720);
		lblEntradaCole.setBackground(new Color(100, 100, 100, 150));
		lblEntradaCole.setOpaque(true);
		lblEntradaCole.setForeground(Color.black);
		inicioPane.add(lblEntradaCole);

	}

	private void cambiarIdioma(Locale local) {
		locale = local;
		idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
	}

	public JPanel getNavegacionPane() {
		return navegacionPane;
	}

	public void setNavegacionPane(JPanel navegacionPane) {
		this.navegacionPane = navegacionPane;
	}

	public JPanel getMenuInteractivoPane() {
		return menuInteractivoPane;
	}

	public void setMenuInteractivoPane(JPanel menuInteractivoPane) {
		this.menuInteractivoPane = menuInteractivoPane;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getIconoPanel() {
		return iconoPanel;
	}
	
}
