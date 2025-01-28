package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class APrimeraPueba extends JFrame {

    private JPanel contentPane;

    public APrimeraPueba() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 20, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon icono = new ImageIcon("imagenes/imgJuego1.jpeg");
        Image img = icono.getImage();
        Image imgEscalado = img.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon iconoEscalado = new ImageIcon(imgEscalado);
        
                JTextPane txtpizarra = new JTextPane();
                txtpizarra.setText("Las palabras duelen más de lo que crees.");
                txtpizarra.setEditable(false);
                txtpizarra.setBounds(176, 306, 207, 20);
                contentPane.add(txtpizarra);
                
                        // Hacer que el fondo del JTextPane sea transparente
                        txtpizarra.setOpaque(false);

        JLabel lblNewLabel = new JLabel(" ");
        lblNewLabel.setIcon(iconoEscalado);
        lblNewLabel.setBounds(0, 0, 1264, 681);
        contentPane.add(lblNewLabel);
    }
}

