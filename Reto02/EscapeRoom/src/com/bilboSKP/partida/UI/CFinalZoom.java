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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import herramientas.PanelImagen;
import herramientas.TimerManager;

public class CFinalZoom extends JFrame {

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
	private JTextArea frase1;
	
    private int correctAnswers = 0; // Contador de respuestas correctas

    public CFinalZoom() {
    	
        setTitle("Aula: La revelación");
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170,80,905,626);
		contentP = new JPanel();
		contentP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentP);
		contentP.setLayout(null);
		
		contentPane = new PanelImagen("/img/finalZoom.jpg");
//		contentPane = new JPanel();
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


//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(170,80,905,626);
//		contentP = new JPanel();
//		contentP.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentP);
//		contentP.setLayout(null);
//		
//		 contentPane = new PanelImagen("src/img/final.jpeg");
//	     contentPane.setBounds(0, 0, 900, 600);
//	     contentP.add(contentPane);
		
//		contentPane = new PanelImagen("/src/img/final.jpeg");
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setBounds(0,0,900,600);
//		contentPane.setVisible(true);
//		contentPane.setLayout(null);
//		contentP.add(contentPane);
        
        
//        contentPane = new JPanel();
//        contentPane.setLayout(null);
//        contentPane.setBackground(new Color(240, 248, 255));
//        setContentPane(contentPane);
//        contentPane = new PanelImagen("src/img/final.jpeg");
        
		
		
		lblTiempo = new JLabel();
		lblTiempo.setBounds(71, 11, 170, 48);
		lblTiempo.setFont(new Font("Uncial Antiqua", Font.BOLD, 20));
		lblTiempo.setForeground(Color.WHITE);
		contentPane.add(lblTiempo);
		
		TimerManager.getInstance().setLblTiempo(lblTiempo);

        frase1 = new JTextArea("\tGracias por seguir mi historia. \r\n\r\nOjal\u00E1 alguien lo hubiera hecho cuando yo a\u00FAn estaba aqu\u00ED.");
        frase1.setForeground(Color.WHITE);
        frase1.setDisabledTextColor(Color.GRAY);
        frase1.setWrapStyleWord(true);
        frase1.setLineWrap(true);
        frase1.setOpaque(false);
        frase1.setEditable(false);
        frase1.setBounds(191, 229, 506, 140);
        frase1.setAlignmentX(Component.CENTER_ALIGNMENT);
        frase1.setAlignmentY(Component.CENTER_ALIGNMENT);
        
        
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 24);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} frase1.setFont(font);
        
        
//        frase1.setBackground(Color.WHITE);
//        frase1.setForeground(new Color(255, 255, 255));
        contentPane.add(frase1);

        JButton continuarButton = new JButton("Continuar");
        continuarButton.setBounds(379, 535, 150, 40);
        continuarButton.setFont(new Font("Arial", Font.BOLD, 14));
        continuarButton.setBackground(new Color(60, 179, 113));
        continuarButton.setForeground(Color.WHITE);
        continuarButton.setFocusPainted(false);
        continuarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			frase1.setText("X se quitó la vida tras sufrir bullying por años. Esta historia no tiene que repetirse. Siempre puedes marcar la diferencia apoyando a quien lo necesite.");
				   
			for (ActionListener al : continuarButton.getActionListeners()) {
            continuarButton.removeActionListener(al);
			}
			
				// Añade un nuevo action listener que abrirá la nueva ventana en el siguiente clic
		        continuarButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		        			CMensajeFinal v5 = new CMensajeFinal();
		        			v5.setVisible(true);
	//	        			timer.cancel();
		        			dispose();
		        		
		            }
		        });
			
			}
		});
        contentPane.add(continuarButton);
        
        
        JLabel lblCronometro = new JLabel("");
		lblCronometro.setBounds(10, 11, 51, 48);
		lblCronometro.setIcon(new ImageIcon(CFinal.class.getResource("/img/Timer.png")));
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCronometro);
        
        

//        JLabel decoracion = new JLabel();
//        decoracion.setBounds(0, 0, 784, 600);
//        ImageIcon decoracionImagen = new ImageIcon("src/img/final.jpeg");
//        decoracion.setIcon(new ImageIcon(decoracionImagen.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH)));
//        contentPane.add(decoracion);

//      getContentPane().add(contentPane);
        
        
        
       
    }

    private void completarFrase(String frase, String respuestaCorrecta, JButton boton) {
        String respuesta = JOptionPane.showInputDialog(null, "Completa la frase: " + frase);

        if (respuesta != null && respuesta.equalsIgnoreCase(respuestaCorrecta)) {
            JOptionPane.showMessageDialog(null, "Correcto! Has completado la frase.");
            boton.setEnabled(false);
            correctAnswers++;

            if (correctAnswers == 3) {
                mostrarMensajeFinal();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto. Intenta de nuevo.");
        }
    }

    private void cambiarMensaje() {
        frase1.setText("X se quitó la vida tras sufrir bullying por años. Esta historia no tiene que repetirse. Siempre puedes marcar la diferencia apoyando a quien lo necesite.");
   
    }

    private void mostrarMensajeFinal() {
        JOptionPane.showMessageDialog(null, "Has completado todas las frases.\n" +
                "Lección: Muchas veces, las víctimas dejan señales, pero pasan desapercibidas porque no las sabemos leer.\n" +
                "Aprende a escuchar y prestar atención a los que te rodean. Tu apoyo puede marcar la diferencia.");
        System.exit(0);
    }

	
		
		
		
}
