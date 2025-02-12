package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

import herramientas.ImageRescaler;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

public class APrimeraPueba extends JPanel {

    private Font fontTexto;
    private ASopaDeLetras sopaLetras;
    private ResourceBundle idioma;

    public APrimeraPueba(AEntradaJuego aEntradaJuego, Locale local) {
    	cambiarIdioma(local);
    	
        repaint();
        revalidate();

        setBounds(0, 0, 1280, 720);
        setLayout(null);

        try {
            // Cargar la fuente personalizada
            fontTexto = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/AppleGaramond.ttf"));
            fontTexto = fontTexto.deriveFont(10f); // Tamaño de la fuente
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontTexto);
        } catch (FontFormatException | IOException e1) {
            System.out.println("Error, fuente no cargada.");
            e1.printStackTrace();
            fontTexto = new Font("Serif", Font.PLAIN, 13); 
        }

        JButton btnPizarra = new JButton(idioma.getString("label.botonPizarra"));
        btnPizarra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                sopaLetras = new ASopaDeLetras(aEntradaJuego, local);
                aEntradaJuego.getNavegacionPane().add(sopaLetras, 0);
                aEntradaJuego.repaint();
                aEntradaJuego.revalidate();
            }
        });

        // Cambiar el color del texto a blanco
        btnPizarra.setForeground(Color.WHITE);

        // Cambiar la fuente del botón con la fuente personalizada
        btnPizarra.setFont(fontTexto);

        btnPizarra.setBounds(137, 281, 346, 160);
        add(btnPizarra);
        btnPizarra.setOpaque(false);
        btnPizarra.setContentAreaFilled(false);
        btnPizarra.setBorder(null);
        btnPizarra.setFocusPainted(false);

        JLabel lblNewLabel = new JLabel(" ");
        lblNewLabel.setIcon(ImageRescaler.scaleImage("/imagenes/imgJuego1.jpeg", 1280, 720));
        lblNewLabel.setBounds(0, 0, 1280, 720);
        add(lblNewLabel);

        repaint();
        revalidate();
    }

	private void cambiarIdioma(Locale local) {
		idioma = ResourceBundle.getBundle("Idioma.menuInicio", local);
		
	}
}

