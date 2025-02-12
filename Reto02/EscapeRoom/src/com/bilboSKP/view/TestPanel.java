package com.bilboSKP.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TestPanel extends JFrame {

	private JPanel contentPane;
	private JPanel panelFinal;
	private JLabel lblMensajeFinal;
	private JButton btnFinalizar;
	private Font fontFinal;
	private JLabel lblImgFondoFinal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestPanel frame = new TestPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestPanel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setUndecorated(true);
		try {
			fontFinal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/BebasNeue-Regular.ttf"));
			fontFinal = fontFinal.deriveFont(70f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(fontFinal);
			
		} catch (FontFormatException | IOException e1) {
			
			e1.printStackTrace();
		}
		
		
		contentPane.removeAll();
		panelFinal = new JPanel();
		panelFinal.setBounds(0,0, 1400, 720);
		panelFinal.setLayout(null);
		panelFinal.setBackground(null);	
		getContentPane().add(panelFinal, 0);
		
		btnFinalizar = new JButton("<html><center>FINALIZAR</html></center>");
		btnFinalizar.setBounds(618, 639, 174, 70);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelFinal.add(btnFinalizar);
		
		lblMensajeFinal = new JLabel("<html><center><p>FIN DEL JUEGO</p><br><p>GRACIAS POR JUGAR</p></html></center>", SwingConstants.CENTER);
		lblMensajeFinal.setForeground(Color.white);
		lblMensajeFinal.setBounds(0, 0, 1400, 273);
		lblMensajeFinal.setFont(fontFinal);
		panelFinal.add(lblMensajeFinal);
		
		lblImgFondoFinal = new JLabel();
		lblImgFondoFinal.setBounds(0, 0, 1400, 720);
		lblImgFondoFinal.setIcon(ImageRescaler.scaleImage("/imagenes/fondoFinal.png", 1400, 720));
		panelFinal.add(lblImgFondoFinal);
		
		contentPane.repaint();
		contentPane.revalidate();
	}

}
