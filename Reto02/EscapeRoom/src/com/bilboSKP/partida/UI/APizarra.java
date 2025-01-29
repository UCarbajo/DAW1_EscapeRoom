package com.bilboSKP.partida.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class APizarra extends JFrame {

    private JPanel contentPane;
    private JLabel lblPzrrA;

    public APizarra() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        int[][] posicionHuecos = {{324,248},{380,248}, {473, 248}, {505, 248},{870,248} };
        ArrayList<JLabel> listaHuecos = new ArrayList<JLabel>();
        
        int[][] posicionLetras = {{324,400},{380,400}, {473, 400}, {505, 400},{870,400} };
        ArrayList<JLabel> listaLetras = new ArrayList<JLabel>();
        
        for(int i = 0; i < posicionHuecos.length; i++) {
        	JLabel hueco = crearJLabelHueco(posicionHuecos[i][0], posicionHuecos[i][1]);
        	listaHuecos.add(hueco);
        	contentPane.add(hueco);
        }
        
        for(int i = 0; i < posicionLetras.length; i++) {
        	JLabel hueco = crearJLabelLetra(posicionLetras[i][0], posicionLetras[i][1]);
        	listaHuecos.add(hueco);
        	contentPane.add(hueco);
        }
        
        JTextPane textPzrr = new JTextPane();
        textPzrr.setEditable(false);
        textPzrr.setText("Las pal_br_s du_l_n más de lo que cre_s.");
        textPzrr.setBounds(204, 238, 871, 67);
        contentPane.add(textPzrr);
        
        // Aquí se declara solo una vez la fuente
        Font fuente = new Font("Arial", Font.PLAIN, 40); 
        textPzrr.setFont(fuente);
        textPzrr.setForeground(Color.white);
        textPzrr.setOpaque(false);  // Fondo transparente
        
        lblPzrrA = new JLabel("");
        lblPzrrA.setIcon(new ImageIcon("imagenes/PzrrA.jpeg"));
        lblPzrrA.setBounds(0, 0, 1280, 720);
        contentPane.add(lblPzrrA);
        
        
  
	}

	private JLabel crearJLabelHueco(int posicionHuecos, int posicionHuecos2) {
		JLabel lblHueco = new JLabel("");
        lblHueco.setBounds(posicionHuecos, posicionHuecos2, 45, 45);
        lblHueco.setOpaque(true);
        lblHueco.setBackground(Color.yellow);
        return lblHueco;
	}
	
	private JLabel crearJLabelLetra(int posicionHuecos, int posicionHuecos2) {
		JLabel lblLetra = new JLabel("");
        lblLetra.setBounds(posicionHuecos, posicionHuecos2, 45, 45);
        lblLetra.setOpaque(true);
        lblLetra.setBackground(Color.yellow);
        return lblLetra;
	}
}
