package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class PantallaInicioFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private ResourceBundle idioma;
	
	public PantallaInicioFrame() {
		
		cambiarIdioma("en");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.addMouseListener(null);

		ImageIcon icon = new ImageIcon("imagenes/ImagenPortada.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1264, 681, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		try {
			// Cargar la fuente desde el archivo
			Font fuenteQuickPencilGrande = crearFontQuickPencil(80f);
			Font fuenteQuickPencilMedianaGrande = crearFontQuickPencil(60f);
			Font fuenteQuickPencilMediana = crearFontQuickPencil(40f);
			Font fuenteQuickPencilPequena = crearFontQuickPencil(25f);
					
			
			JButton btnJugar = new JButton("JUGAR");
			btnJugar.setBounds(163, 159, 335, 100);
			btnJugar.setForeground(Color.black);
			btnJugar.setFont(fuenteQuickPencilGrande);
			btnJugar.setContentAreaFilled(false);
			btnJugar.setBorder(null);
			btnJugar.setFocusPainted(false);
			btnJugar.addMouseListener(cambiarColorBoton(btnJugar));
			contentPane.add(btnJugar);
			
			JButton btnTutorial = new JButton("TUTORIAL");
			btnTutorial.setBounds(163, 286, 335, 100);
			btnTutorial.setForeground(Color.black);
			btnTutorial.setFont(fuenteQuickPencilGrande);
			btnTutorial.setContentAreaFilled(false);
			btnTutorial.setBorder(null);
			btnTutorial.setFocusPainted(false);
			btnTutorial.addMouseListener(cambiarColorBoton(btnTutorial));
			contentPane.add(btnTutorial);
			
			JButton btnAjustes = new JButton("AJUSTES");
			btnAjustes.setBounds(163, 432, 335, 100);
			btnAjustes.setForeground(Color.black);
			btnAjustes.setFont(fuenteQuickPencilGrande);
			btnAjustes.setContentAreaFilled(false);
			btnAjustes.setBorder(null);
			btnAjustes.setFocusPainted(false);
			btnAjustes.addMouseListener(cambiarColorBoton(btnAjustes));
			contentPane.add(btnAjustes);

			//Lo que se muestra al pulsar JUGAR
			JLabel lblIntroduceCodigo = new JLabel("Introduce el código");
			lblIntroduceCodigo.setForeground(Color.black);
			lblIntroduceCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroduceCodigo.setBounds(701, 159, 480, 100);
			lblIntroduceCodigo.setFont(fuenteQuickPencilMediana);
			lblIntroduceCodigo.setVisible(false);
			contentPane.add(lblIntroduceCodigo);
			
			textCodigo = new JTextField();
			textCodigo.setColumns(5);
			textCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			textCodigo.setBounds(802, 291, 259, 92);
			textCodigo.setFont(fuenteQuickPencilGrande);
			textCodigo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
			textCodigo.setVisible(false);
			contentPane.add(textCodigo);
			
			JButton btnEmpezar = new JButton("EMPEZAR");
			btnEmpezar.setBounds(802, 471, 259, 61);
			btnEmpezar.setForeground(Color.black);
			btnEmpezar.setFont(fuenteQuickPencilMedianaGrande);
			btnEmpezar.setContentAreaFilled(false);
			btnEmpezar.setBorder(null);
			btnEmpezar.setFocusPainted(false);
			btnEmpezar.setVisible(false);
			btnEmpezar.addMouseListener(cambiarColorBoton(btnEmpezar));
			contentPane.add(btnEmpezar);
			
			//Lo que se muestra al pulsar el boton Tutorial
			//TODO Preguntar como cambiar el texto del tutorial
			JTextPane textTutorial = new JTextPane();
			textTutorial.setBounds(701, 118, 480, 467);
			textTutorial.setFont(fuenteQuickPencilPequena);
			textTutorial.setEditable(false);
			textTutorial.setText("1 - Para poder empezar a jugar, pulsa el botón jugar e introduce el código.\n" 
								+"2 - Cuando empieze la partida, tendras 60 minutos para completar el escape room.\n"
								+"3 - Deberas buscar y encontrar las diferentes pruebas interactuando con diferentes elementos.\n"
								+"4 - Cada prueba tendra 3 pistas que podras comprar con las monedas que encontraras por el mapa \n"
								+"5 - El juego terminara cuando completes la ultima prueba.");
			textTutorial.setVisible(false);
			contentPane.add(textTutorial);
			
			//Lo que sale al pulsar el boton ajustes.
			
			
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblIntroduceCodigo.setVisible(true);
					textCodigo.setVisible(true);
					btnEmpezar.setVisible(true);
					
					textTutorial.setVisible(false);
				}
			});
			
			btnTutorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblIntroduceCodigo.setVisible(false);
					textCodigo.setVisible(false);
					btnEmpezar.setVisible(false);
					
					textTutorial.setVisible(true);
				}
			});
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la fuente.");
		}
		
		contentPane.setLayout(null);
		JLabel lblImagenFondo = new JLabel(scaledIcon);
		lblImagenFondo.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondo);
		
	}

	private Font crearFontQuickPencil(float tamañoTexto) throws FontFormatException, IOException {
		Font fuenteQuickPencil = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/DoodlePen_Limited.ttf"));
		fuenteQuickPencil = fuenteQuickPencil.deriveFont(tamañoTexto);
		return fuenteQuickPencil;
	}

	private void cambiarIdioma(String tipoIdioma) {
        // Cargar el archivo de propiedades en base al idioma
        Locale locale = new Locale(tipoIdioma);  // idioma es una cadena como "es" o "en"
        idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
    }
	
	private MouseListener cambiarColorBoton(JButton boton) {
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setForeground(Color.red);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setForeground(Color.black);
			}
		};
		return mouseListener;
	}
}
