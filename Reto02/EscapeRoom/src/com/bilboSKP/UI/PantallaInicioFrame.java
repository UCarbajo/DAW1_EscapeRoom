package com.bilboSKP.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.bilboSKP.partida.UI.AEntradaJuego;

public class PantallaInicioFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JLabel lblIntroduceCodigo;
	private ResourceBundle idioma;
	private JButton btnEmpezar;
	private JTextArea lblTxtTutorialUno;
	private JTextArea lblTxtTutorialDos;
	private JTextArea lblTxtTutorialTres;
	private JTextArea lblTxtTutorialCuatro;
	private JTextArea lblTxtTutorialCinco;
	private JLabel lblSeleccionarIdioma;
	private JLabel lblBanderaEspana;
	private JLabel lblEspanol;
	private JLabel lblBanderaInglesa;
	private JLabel lblIngles;
	private JButton btnJugar;
	private JButton btnTutorial;
	private JButton btnAjustes;
	private JLabel lblImagenNino;
	private Locale locale;
	
	public PantallaInicioFrame() {
		
		cambiarIdioma("es");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ImageIcon imagenNino = tamanoImagen("imagenes/ninoAcosado.png", 405, 325);
		
		lblImagenNino = new JLabel();
		lblImagenNino.setBounds(720, 170, 405, 325);
		lblImagenNino.setIcon(imagenNino);
		contentPane.add(lblImagenNino);
		
		contentPane.addMouseListener(null);

		try {
			// Cargar la fuente desde el archivo
			Font fuenteQuickPencilGrande = crearFontQuickPencil(80f);
			Font fuenteQuickPencilMedianaGrande = crearFontQuickPencil(60f);
			Font fuenteQuickPencilMediana = crearFontQuickPencil(40f);
			Font fuenteQuickPencilPequena = crearFontQuickPencil(25f);
			
			btnJugar = new JButton(idioma.getString("label.jugar"));
			btnJugar.setBounds(163, 159, 335, 100);
			btnJugar.setForeground(Color.black);
			btnJugar.setFont(fuenteQuickPencilGrande);
			btnJugar.setContentAreaFilled(false);
			btnJugar.setBorder(null);
			btnJugar.setFocusPainted(false);
			btnJugar.addMouseListener(cambiarColorBoton(btnJugar));
			contentPane.add(btnJugar);
			
			btnTutorial = new JButton(idioma.getString("label.tutorial"));
			btnTutorial.setBounds(163, 286, 335, 100);
			btnTutorial.setForeground(Color.black);
			btnTutorial.setFont(fuenteQuickPencilGrande);
			btnTutorial.setContentAreaFilled(false);
			btnTutorial.setBorder(null);
			btnTutorial.setFocusPainted(false);
			btnTutorial.addMouseListener(cambiarColorBoton(btnTutorial));
			contentPane.add(btnTutorial);
			
			btnAjustes = new JButton(idioma.getString("label.ajustes"));
			btnAjustes.setBounds(163, 432, 335, 100);
			btnAjustes.setForeground(Color.black);
			btnAjustes.setFont(fuenteQuickPencilGrande);
			btnAjustes.setContentAreaFilled(false);
			btnAjustes.setBorder(null);
			btnAjustes.setFocusPainted(false);
			btnAjustes.addMouseListener(cambiarColorBoton(btnAjustes));
			contentPane.add(btnAjustes);

			//Lo que se muestra al pulsar JUGAR
			lblIntroduceCodigo = new JLabel(idioma.getString("label.introducir_codigo"));
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
			
			btnEmpezar = new JButton(idioma.getString("label.empezar"));
			btnEmpezar.setBounds(802, 471, 259, 61);
			btnEmpezar.setForeground(Color.black);
			btnEmpezar.setFont(fuenteQuickPencilMedianaGrande);
			btnEmpezar.setContentAreaFilled(false);
			btnEmpezar.setBorder(null);
			btnEmpezar.setFocusPainted(false);
			btnEmpezar.setVisible(false);
			btnEmpezar.addMouseListener(cambiarColorBoton(btnEmpezar));
			contentPane.add(btnEmpezar);
			
			btnEmpezar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO CONECTAR BD Y COMPROBAR SI EL CODIGO EXISTE;
					AEntradaJuego ventana = new AEntradaJuego(locale);
					ventana.setVisible(true);
					dispose();
				}
			});
			
			//Lo que se muestra al pulsar el boton Tutorial
			
			lblTxtTutorialUno = new JTextArea();			
			lblTxtTutorialUno.setBounds(701, 140, 480, 80);
			lblTxtTutorialUno.setFont(fuenteQuickPencilPequena);
			lblTxtTutorialUno.setText(idioma.getString("label.instruccionesTutorial_1"));
			lblTxtTutorialUno.setLineWrap(true);
			lblTxtTutorialUno.setWrapStyleWord(true);
			lblTxtTutorialUno.setEditable(false);
			lblTxtTutorialUno.setVisible(false);
			lblTxtTutorialUno.setOpaque(false);
			contentPane.add(lblTxtTutorialUno);
			
			lblTxtTutorialDos = new JTextArea();			
			lblTxtTutorialDos.setBounds(701, 220, 480, 80);
			lblTxtTutorialDos.setFont(fuenteQuickPencilPequena);
			lblTxtTutorialDos.setText(idioma.getString("label.instruccionesTutorial_2"));
			lblTxtTutorialDos.setLineWrap(true);
			lblTxtTutorialDos.setWrapStyleWord(true);
			lblTxtTutorialDos.setEditable(false);
			lblTxtTutorialDos.setVisible(false);
			lblTxtTutorialDos.setOpaque(false);
			contentPane.add(lblTxtTutorialDos);
			
			lblTxtTutorialTres = new JTextArea();			
			lblTxtTutorialTres.setBounds(701, 300, 480, 80);
			lblTxtTutorialTres.setFont(fuenteQuickPencilPequena);
			lblTxtTutorialTres.setText(idioma.getString("label.instruccionesTutorial_3"));
			lblTxtTutorialTres.setLineWrap(true);
			lblTxtTutorialTres.setWrapStyleWord(true);
			lblTxtTutorialTres.setEditable(false);
			lblTxtTutorialTres.setVisible(false);
			lblTxtTutorialTres.setOpaque(false);
			contentPane.add(lblTxtTutorialTres);
			
			lblTxtTutorialCuatro = new JTextArea();			
			lblTxtTutorialCuatro.setBounds(701, 380, 480, 80);
			lblTxtTutorialCuatro.setFont(fuenteQuickPencilPequena);
			lblTxtTutorialCuatro.setText(idioma.getString("label.instruccionesTutorial_4"));
			lblTxtTutorialCuatro.setLineWrap(true);
			lblTxtTutorialCuatro.setWrapStyleWord(true);
			lblTxtTutorialCuatro.setEditable(false);
			lblTxtTutorialCuatro.setVisible(false);
			lblTxtTutorialCuatro.setOpaque(false);
			contentPane.add(lblTxtTutorialCuatro);
			
			lblTxtTutorialCinco = new JTextArea();			
			lblTxtTutorialCinco.setBounds(701, 460, 480, 80);
			lblTxtTutorialCinco.setFont(fuenteQuickPencilPequena);
			lblTxtTutorialCinco.setText(idioma.getString("label.instruccionesTutorial_5"));
			lblTxtTutorialCinco.setLineWrap(true);
			lblTxtTutorialCinco.setWrapStyleWord(true);
			lblTxtTutorialCinco.setEditable(false);
			lblTxtTutorialCinco.setVisible(false);
			lblTxtTutorialCinco.setOpaque(false);
			contentPane.add(lblTxtTutorialCinco);
			
			//Lo que sale al pulsar el boton ajustes.
			lblSeleccionarIdioma = new JLabel(idioma.getString("label.seleccionar_idioma"));
			lblSeleccionarIdioma.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeleccionarIdioma.setFont(fuenteQuickPencilMediana);
			lblSeleccionarIdioma.setBounds(701, 118, 480, 42);
			lblSeleccionarIdioma.setVisible(false);
			contentPane.add(lblSeleccionarIdioma);
			
			ImageIcon banderaEspana = tamanoImagen("imagenes/banderaEspana.png", 180, 130);
			
			lblBanderaEspana = new JLabel();
			lblBanderaEspana.setBounds(744, 270, 180, 130);
			lblBanderaEspana.setIcon(banderaEspana);
			lblBanderaEspana.setVisible(false);
			contentPane.add(lblBanderaEspana);
			
			lblEspanol = new JLabel(idioma.getString("label.espanol"));
			lblEspanol.setHorizontalAlignment(SwingConstants.CENTER);
			lblEspanol.setBounds(705, 410, 255, 51);
			lblEspanol.setForeground(Color.black);
			lblEspanol.setFont(fuenteQuickPencilMediana);
			lblEspanol.setVisible(false);
			cambiarFormaIdioma(lblBanderaEspana, lblEspanol, "es");
			contentPane.add(lblEspanol);
			
			ImageIcon banderaInglesa = tamanoImagen("imagenes/banderaInglesa.png", 180, 130);
			
			lblBanderaInglesa = new JLabel();
			lblBanderaInglesa.setBounds(954, 270, 180, 130);
			lblBanderaInglesa.setIcon(banderaInglesa);
			lblBanderaInglesa.setVisible(false);
			contentPane.add(lblBanderaInglesa);
			
			lblIngles = new JLabel(idioma.getString("label.ingles"));
			lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
			lblIngles.setBounds(954, 410, 180, 51);
			lblIngles.setForeground(Color.black);
			lblIngles.setFont(fuenteQuickPencilMediana);
			lblIngles.setVisible(false);
			cambiarFormaIdioma(lblBanderaInglesa, lblIngles, "en");
			contentPane.add(lblIngles);
			
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarVisibilidad(true, false, false);
				}
			});
			
			btnTutorial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarVisibilidad(false, true, false);
				}
			});
			
			btnAjustes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					actualizarVisibilidad(false, false, true);
				}
			});
			
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			System.out.println("No se pudo cargar la fuente.");
		}
		
		contentPane.setLayout(null);
		ImageIcon scaledIcon = tamanoImagen("imagenes/ImagenPortada.png", 1264, 681);
		
		JLabel lblImagenFondo = new JLabel(scaledIcon);
		lblImagenFondo.setBounds(0, 0, 1264, 681);
		contentPane.add(lblImagenFondo);
		
	}

	private ImageIcon tamanoImagen(String rutaImagen, int tamanoX, int tamanoY) {
		ImageIcon icon = new ImageIcon(rutaImagen);
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(tamanoX, tamanoY, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		return scaledIcon;
	}

	private Font crearFontQuickPencil(float tamanoTexto) throws FontFormatException, IOException {
		Font fuenteQuickPencil = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/DoodlePen_Limited.ttf"));
		fuenteQuickPencil = fuenteQuickPencil.deriveFont(tamanoTexto);
		return fuenteQuickPencil;
	}

	private void cambiarIdioma(String tipoIdioma) {
        // Cargar el archivo de propiedades en base al idioma
		// idioma es una cadena como "es" o "en"
        locale = new Locale(tipoIdioma);  
        idioma = ResourceBundle.getBundle("Idioma.menuInicio", locale);
    }
	
	//TODO PREGUNTAR SI HAY OTRA MANERA
	// Actualiza los textos de los botones y las etiquetas
	private void actualizarTextos() {
	    btnJugar.setText(idioma.getString("label.jugar"));
	    btnTutorial.setText(idioma.getString("label.tutorial"));
	    btnAjustes.setText(idioma.getString("label.ajustes"));
	    
	    lblIntroduceCodigo.setText(idioma.getString("label.introducir_codigo"));
	    btnEmpezar.setText(idioma.getString("label.empezar"));
	    lblTxtTutorialUno.setText(idioma.getString("label.instruccionesTutorial_1"));
	    lblTxtTutorialDos.setText(idioma.getString("label.instruccionesTutorial_2"));
	    lblTxtTutorialTres.setText(idioma.getString("label.instruccionesTutorial_3"));
	    lblTxtTutorialCuatro.setText(idioma.getString("label.instruccionesTutorial_4"));
	    lblTxtTutorialCinco.setText(idioma.getString("label.instruccionesTutorial_5"));
	    
	    lblSeleccionarIdioma.setText(idioma.getString("label.seleccionar_idioma"));
	    lblEspanol.setText(idioma.getString("label.espanol"));
	    lblIngles.setText(idioma.getString("label.ingles"));
	    
	}
	
	private void actualizarVisibilidad(boolean jugarVisible, boolean tutorialVisible, boolean ajustesVisible) {
        lblIntroduceCodigo.setVisible(jugarVisible);
        textCodigo.setVisible(jugarVisible);
        btnEmpezar.setVisible(jugarVisible);
        lblTxtTutorialUno.setVisible(tutorialVisible);
        lblTxtTutorialDos.setVisible(tutorialVisible);
        lblTxtTutorialTres.setVisible(tutorialVisible);
        lblTxtTutorialCuatro.setVisible(tutorialVisible);
        lblTxtTutorialCinco.setVisible(tutorialVisible);
        lblSeleccionarIdioma.setVisible(ajustesVisible);
        lblBanderaEspana.setVisible(ajustesVisible);
        lblEspanol.setVisible(ajustesVisible);
        lblBanderaInglesa.setVisible(ajustesVisible);
        lblIngles.setVisible(ajustesVisible);
        lblImagenNino.setVisible(false);
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
	
	private void cambiarFormaIdioma(JLabel lblBandera, JLabel lblIdioma, String idioma) {
		MouseListener mouseListener = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIdioma.setForeground(Color.red);
				lblBandera.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.black));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIdioma.setForeground(Color.black);
				lblBandera.setBorder(null);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				cambiarIdioma(idioma);
				actualizarTextos();
				contentPane.revalidate();
				contentPane.repaint();
			}
		};
		lblBandera.addMouseListener(mouseListener);
		lblIdioma.addMouseListener(mouseListener);
	}
}
