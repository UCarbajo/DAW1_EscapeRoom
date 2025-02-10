package com.bilboSKP.partida.UI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import herramientas.PanelImagen;
import herramientas.TimerManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;

public class CFinal extends JFrame {

	private JPanel contentPane;
	private JPanel contentP;
	private JPanel contentPane2;
	JLabel lblTiempo;
	int segundosSala = 0;
	int minutosSala = 60;
	int horasSala = 0;
	int segundosPasados;
	int segundosPasadosSala;
	int pistasPedidas;
	boolean totem;
	int numeroClicks;
	Font font = null;
	
    private int correctAnswers = 0; // Contador de respuestas correctas

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CFinal frame = new CFinal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    
    public CFinal() {
    	
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170,80,905,626);
		contentP = new JPanel();
		contentP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentP);
		contentP.setLayout(null);
		
		contentPane = new PanelImagen("/img/final.jpeg");
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

        
		lblTiempo = new JLabel();
		lblTiempo.setBounds(71, 11, 170, 48);
		lblTiempo.setFont(new Font("Uncial Antiqua", Font.BOLD, 20));
		lblTiempo.setForeground(Color.WHITE);
		contentPane.add(lblTiempo);
		
		TimerManager.getInstance().setLblTiempo(lblTiempo);
		
		
        setTitle("Aula: La revelación");
       

        JLabel frase1 = new JLabel("Gracias por seguir mi historia. Ojalá alguien lo hubiera hecho cuando yo aún estaba aquí.");
        frase1.setHorizontalTextPosition(SwingConstants.CENTER);
        frase1.setHorizontalAlignment(SwingConstants.CENTER);
        frase1.setBounds(234, 154, 383, 173);
        
        try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 8);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} frase1.setFont(font);
        

        frase1.setBackground(Color.WHITE);
        frase1.setForeground(UIManager.getColor("Button.shadow"));
        contentPane.add(frase1);
        frase1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
			CFinalZoom v5 = new CFinalZoom();
			v5.setVisible(true);
			dispose();
		}
    });
        

        JLabel pistaButton = new JLabel("");
        pistaButton.setBounds(772, 11, 51, 48);
        pistaButton.setIcon(new ImageIcon(CAula7.class.getResource("/img/Clue.png")));
        pistaButton.setBackground(new Color(0, 0, 0));
        pistaButton.setForeground(Color.WHITE);
        pistaButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		// TODO Auto-generated method stub
        		super.mouseClicked(e);
        	}
        });
        contentPane.add(pistaButton);
        
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

    private void mostrarPista() {
        JOptionPane.showMessageDialog(null, "Busca las palabras que tengan sentido en el contexto de lo que Alex sentía.");
    }

    private void mostrarMensajeFinal() {
        JOptionPane.showMessageDialog(null, "Has completado todas las frases.\n" +
                "Lección: Muchas veces, las víctimas dejan señales, pero pasan desapercibidas porque no las sabemos leer.\n" +
                "Aprende a escuchar y prestar atención a los que te rodean. Tu apoyo puede marcar la diferencia.");
        System.exit(0);
    }

	
		
		
		
}
