package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PantallaInicioFrame extends JFrame {

	private JPanel contentPane;

	public PantallaInicioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ImageIcon icon = new ImageIcon("imagenes/ImagenPortada.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(1264, 681, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		try {
			// Cargar la fuente desde el archivo
			Font fuenteQuickPencilGrande = crearFontQuickPencil(80f);
			Font fuenteQuickPencilMediana = crearFontQuickPencil(60f);
			Font fuenteQuickPencilPequena = crearFontQuickPencil(50f);
			
			Font fuenteQuickPencilMediano = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/QuickPencil-Regular.ttf"));
			fuenteQuickPencilMediano = fuenteQuickPencilMediano.deriveFont(60f);
			
			JButton btnJugar = new JButton("JUGAR");
			btnJugar.setBounds(163, 159, 335, 100);
			btnJugar.setFont(fuenteQuickPencilGrande);
			btnJugar.setContentAreaFilled(false);
			btnJugar.setBorder(null);
			btnJugar.setFocusPainted(false);
			btnJugar.addMouseListener(cambiarColorBoton(btnJugar));
			contentPane.add(btnJugar);
			
			JButton btnTutorial = new JButton("TUTORIAL");
			btnTutorial.setBounds(163, 286, 335, 100);
			btnTutorial.setFont(fuenteQuickPencilGrande);
			btnTutorial.setContentAreaFilled(false);
			btnTutorial.setBorder(null);
			btnTutorial.setFocusPainted(false);
			btnTutorial.addMouseListener(cambiarColorBoton(btnTutorial));
			contentPane.add(btnTutorial);
			
			JButton btnAjustes = new JButton("AJUSTES");
			btnAjustes.setBounds(163, 432, 335, 100);
			btnAjustes.setFont(fuenteQuickPencilGrande);
			btnAjustes.setContentAreaFilled(false);
			btnAjustes.setBorder(null);
			btnAjustes.setFocusPainted(false);
			btnAjustes.addMouseListener(cambiarColorBoton(btnAjustes));
			contentPane.add(btnAjustes);

			//TODO Preguntar Alberto sobre como corregir la tilde en la o de Código
			
			JLabel lblIntroduceCodigo = new JLabel("Introduce el codigo");
			lblIntroduceCodigo.setHorizontalAlignment(SwingConstants.CENTER);
			lblIntroduceCodigo.setBounds(767, 159, 335, 100);
			lblIntroduceCodigo.setFont(fuenteQuickPencilPequena);
			contentPane.add(lblIntroduceCodigo);
			
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
		Font fuenteQuickPencilGrande = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/QuickPencil-Regular.ttf"));
		fuenteQuickPencilGrande = fuenteQuickPencilGrande.deriveFont(tamañoTexto);
		return fuenteQuickPencilGrande;
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
