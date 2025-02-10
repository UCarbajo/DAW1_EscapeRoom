package com.bilboSKP.partida.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import herramientas.TimerManager;

public class CMensajeFinal extends JFrame {

	private JPanel contentPane;
	private JPanel contentP;
	private JPanel contentPane2;
	JLabel lblTiempo;
	int segundosSala;
	int minutosSala;
	int horasSala;
	int segundosPasados;
	int segundosPasadosSala;
	int pistasPedidas;
	boolean totem;
	int numeroClicks;
	Font font = null;
	private JTextArea fraseFinal;
	
    private int correctAnswers = 0; // Contador de respuestas correctas

    public CMensajeFinal() {
    	
        setTitle("Aula: La revelación");
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170,80,905,626);
		contentP = new JPanel();
		contentP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentP);
		contentP.setLayout(null);
		
		contentPane = new JPanel();
		Color bg = new Color(0,0,0);
		contentPane.setBackground(bg);
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeroClicks=numeroClicks+1;
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,900,600);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		contentP.add(contentPane);
        	
		
		TimerManager.getInstance().setLblTiempo(lblTiempo);

        fraseFinal = new JTextArea("El bullying deja cicatrices profundas. Escucha, apoya y act\u00FAa. T\u00FA puedes ser el cambio.");
        fraseFinal.setForeground(Color.WHITE);
        fraseFinal.setDisabledTextColor(Color.GRAY);
        fraseFinal.setWrapStyleWord(true);
        fraseFinal.setLineWrap(true);
        fraseFinal.setOpaque(false);
        fraseFinal.setEditable(false);
        fraseFinal.setBounds(191, 229, 506, 140);
        fraseFinal.setAlignmentX(Component.CENTER_ALIGNMENT);
        fraseFinal.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 24);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		fraseFinal.setFont(font);
    
        
        
       	fraseFinal.setBackground(Color.WHITE);
       	fraseFinal.setForeground(new Color(255, 255, 255));
        contentPane.add(fraseFinal);

        JButton finalizarButton = new JButton("Salir");
        finalizarButton.setBounds(379, 535, 150, 40);
        finalizarButton.setFont(new Font("Arial", Font.BOLD, 14));
        finalizarButton.setBackground(new Color(60, 179, 113));
        finalizarButton.setForeground(Color.WHITE);
        finalizarButton.setFocusPainted(false);
        finalizarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TimerManager.getInstance().stopTimer();
				String tiempoFinal = TimerManager.getInstance().getTime();
				dispose();
				System.out.println(tiempoFinal);
			}
        });
        contentPane.add(finalizarButton);
        
        //Paramos el timer para almacenarlo en una variable
        
        
    }
    
}
