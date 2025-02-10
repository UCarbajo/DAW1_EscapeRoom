package com.bilboSKP.partida.UI;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.LayerUI;

import herramientas.PanelImagen;
import herramientas.TimerManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UIManager;

public class CAula7 extends JFrame {

	private JPanel contentPane;
	private JPanel contentP;
	private JPanel contentPane2;
	private JPanel panelPrueba;
	private JPanel enunciadoPane;
	JLabel lblEnunciado;
	JButton btnPrimeraPista;
	JButton btnSegundaPista;
	JButton btnTerceraPista;
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
	Font font2 = null;
	Font fontLeccion = null;
	
    private int correctAnswers = 0; // Contador de respuestas correctas

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CAula7 frame = new CAula7();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    
    public CAula7() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1,1,1280,720);
		contentP = new JPanel();
		contentP.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentP);
		contentP.setLayout(null);
		
		contentPane = new PanelImagen("/img/aula7.jpg");
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numeroClicks=numeroClicks+1;
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0,0,1280,720);
		contentPane.setVisible(true);
		contentPane.setLayout(null);
		contentP.add(contentPane);
		
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 24);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			
			fontLeccion = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 30);
			GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge3.registerFont(font);
			
			font2 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/DK Crayon Crumble.ttf")).deriveFont(Font.PLAIN, 8);
			GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge2.registerFont(font2);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		enunciadoPane = new PanelImagen("/img/fondoEnunciado.png");
		enunciadoPane.setBounds(0, 0, 1266, 683);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		contentPane.add(enunciadoPane);
		
		JButton btnDiario = new JButton("Diario");
		btnDiario.setBounds(1080, 114, 150, 50);
		btnDiario.setOpaque(false);
		contentPane.add(btnDiario);
		
		
		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(174, 11, 899, 663);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(font);
		lblEnunciado.setText("<html><center><p>PRUEBA 07</p><br><br><br><p>Este aula est\u00E1 en silencio pero guarda m\u00E1s voces de lo que parece, las palabras que no pudieron decirse a\u00FAn permanecen, fijas en un lugar donde nadie las borra, donde el tiempo las convierte en un susurro silencioso.</p><br><p>Abre los ojos y busca con atenci\u00F3n lo que otros han ignorado.</p></center></html>");
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);
		
		btnPrimeraPista = new JButton("DESBLOQUEAR PRIMERA PISTA");
		btnPrimeraPista.setBounds(265, 180, 740, 100);
		btnPrimeraPista.setVisible(false);
		enunciadoPane.add(btnPrimeraPista);
		
		btnSegundaPista = new JButton("DESBLOQUEAR SEGUNDA PISTA");
		btnSegundaPista.setBounds(265, 290, 740, 100);
		btnSegundaPista.setVisible(false);
		enunciadoPane.add(btnSegundaPista);
		
		btnTerceraPista = new JButton("DESBLOQUEAR TERCERA PISTA");
		btnTerceraPista.setBounds(265, 400, 740, 100);
		btnTerceraPista.setVisible(false);
		enunciadoPane.add(btnTerceraPista);
		
		JButton btncontinuarEnun = new JButton("Continuar");
		btncontinuarEnun.setBounds(1120, 30, 95, 52);
		enunciadoPane.add(btncontinuarEnun);
		btncontinuarEnun.setFont(font);
		btncontinuarEnun.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
			}
		});
		
		JButton btnEnunciado = new JButton("ENUNCIADO");
		btnEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				visibilidadEnunciadoPane(true, false);
				
			}
		});
		btnEnunciado.setOpaque(false);
		btnEnunciado.setBounds(1080, 50, 150, 50);
		contentPane.add(btnEnunciado);
		
//		 	ImageIcon img = new ImageIcon("/img/whiteboard.png");
//	        Image img2 = img.getImage();
//	        img2 = img2.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
//	        ImageIcon imgScalado = new ImageIcon(img2);
		
		panelPrueba = new PanelImagen("/img/whiteboard.png");
		panelPrueba.setVisible(false);
		panelPrueba.setSize(1280, 720);
		
		        JTextArea lblLeccion = new JTextArea("Muchas v\u00EDctimas no expresan lo que sienten directamente. \r\n      Aprende a escuchar m\u00E1s all\u00E1 de las palabras.");
		        lblLeccion.setLineWrap(true);
		        lblLeccion.setForeground(Color.WHITE);
		        lblLeccion.setOpaque(false);
		        lblLeccion.setWrapStyleWord(true);
		        lblLeccion.setEditable(false);
		        lblLeccion.setLocation(310, 237);
		        lblLeccion.setSize(653, 94);
		        contentPane.add(lblLeccion);
		        lblLeccion.setFont(fontLeccion);
		        lblLeccion.setVisible(false);
		        
		        JLabel lblContinuar = new JLabel();
		        lblContinuar.setText("Continuar");
		        lblContinuar.setForeground(Color.WHITE);
		        lblContinuar.setOpaque(false);
		        lblContinuar.setLocation(600, 542);
		        lblContinuar.setSize(93, 29);
		        contentPane.add(lblContinuar);
		        lblContinuar.setFont(font);
		        lblContinuar.setVisible(false);
		        lblContinuar.addMouseListener(new MouseAdapter() {
				
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		
		        		CFinal v5 = new CFinal();
		    			v5.setVisible(true);
		    			dispose();
		        		
		        	}
		        
		        });
		
		       
		        
		JPanel darkOverlay = new JPanel() {
			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setColor(new Color(0, 0, 0, 160));  // Color negro con 50% de opacidad
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
		};
		darkOverlay.setOpaque(false);
		darkOverlay.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight()); // Cubre toda la ventana
		// Agregar el panel de oscurecimiento sobre el panel principal
		contentPane.add(darkOverlay);
		darkOverlay.setVisible(false);
		
		
		
		JTextField entrada1 = new JTextField(10);
		entrada1.setBounds(438, 135, 86, 20);
		JTextField entrada2 = new JTextField(10);
		entrada2.setBounds(438, 219, 86, 20);
		JButton verificar = new JButton("Verificar");
		verificar.setBounds(453, 354, 71, 23);
		panelPrueba.setLayout(null);
		
		        JLabel label = new JLabel("Palabra 1:");
		        label.setBounds(372, 138, 61, 14);
		        panelPrueba.add(label);
		        panelPrueba.add(entrada1);
		        JLabel label_1 = new JLabel("Palabra 2:");
		        label_1.setBounds(372, 222, 61, 14);
		        panelPrueba.add(label_1);
		        panelPrueba.add(entrada2);
		        panelPrueba.add(verificar);
		        JLabel resultado = new JLabel("", SwingConstants.CENTER);
		        JLabel pistas = new JLabel("", SwingConstants.CENTER);
		        panelPrueba.add(resultado, BorderLayout.SOUTH);
		        panelPrueba.add(pistas, BorderLayout.AFTER_LAST_LINE);
		        contentPane.add(panelPrueba, BorderLayout.CENTER);
		        
		        JLabel lblTriste = new JLabel("Hoy me sent\u00ED 21-19-9-20-21-5");
		        lblTriste.setHorizontalTextPosition(SwingConstants.CENTER);
		        lblTriste.setHorizontalAlignment(SwingConstants.CENTER);
		        lblTriste.setBounds(0, 69, 353, 152);
		        panelPrueba.add(lblTriste);
		        
 
				 JLabel lblHabla = new JLabel("Nadie me 8-1-2-12-1");
				 lblHabla.setHorizontalTextPosition(SwingConstants.CENTER);
				 lblHabla.setHorizontalAlignment(SwingConstants.CENTER);
				 lblHabla.setFont(new Font("DK Crayon Crumble", Font.PLAIN, 20));
				 lblHabla.setBounds(0, 222, 353, 152);
				 panelPrueba.add(lblHabla);
		        
		         
		            lblTriste.setFont(font);
		            lblHabla.setFont(font);
				

        
		lblTiempo = new JLabel();
		lblTiempo.setBounds(71, 11, 170, 48);
		lblTiempo.setFont(new Font("Uncial Antiqua", Font.BOLD, 20));
		lblTiempo.setForeground(Color.WHITE);
		contentPane.add(lblTiempo);
		
		TimerManager.getInstance().setLblTiempo(lblTiempo);
		

        setTitle("Aula: El diario codificado");
             
        
        
        JLabel pistaButton = new JLabel("");
        pistaButton.setBounds(772, 11, 51, 48);
        pistaButton.setIcon(new ImageIcon(CAula7.class.getResource("/img/Clue.png")));
        pistaButton.setHorizontalAlignment(SwingConstants.CENTER);
        pistaButton.setFont(new Font("Arial", Font.BOLD, 14));
        pistaButton.setBackground(new Color(0, 0, 0));
        pistaButton.setForeground(Color.WHITE);
        pistaButton.addMouseListener(new MouseAdapter() {
		
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		visibilidadEnunciadoPane(false, true);
        		
        		
//        		JOptionPane.showMessageDialog(null, "El abecedario guarda las respuestas..");
//        		
//        		for (MouseListener ml : pistaButton.getMouseListeners()) {
//                    pistaButton.removeMouseListener(ml);
//        			}
//        		
//        		// Añade un nuevo action listener que abrirá la nueva ventana en el siguiente clic
//		        pistaButton.addMouseListener(new MouseAdapter() {
//		           
//		        	@Override
//		        	public void mouseClicked(MouseEvent e) {
//		        		JOptionPane.showMessageDialog(null, "Cada letra del abecedario corresponde a un número, A=1, B=2... ");
//		        	}
//		        	
//		        	
//		        });
        	}
        
        
        });
        contentPane.add(pistaButton);
        
        JLabel lblCronometro = new JLabel("");
		lblCronometro.setBounds(10, 11, 51, 48);
		lblCronometro.setIcon(new ImageIcon(CAula7.class.getResource("/img/Timer.png")));
		lblCronometro.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCronometro);
		         

		          JLabel frase = new JLabel("<html><p>Hoy me sent\u00ED [20-18-9-19-20-5].<p/><br><p> Nadie me [8-1-2-12-1].<p/><html/>");
		          frase.setBounds(1030, 454, 128, 50);
		          contentPane.add(frase);
		          frase.setHorizontalTextPosition(SwingConstants.CENTER);
		          frase.setHorizontalAlignment(SwingConstants.CENTER);
		          frase.setFont(font2);
		          frase.setBackground(Color.WHITE);
		          frase.setForeground(Color.BLACK);
		         
		         frase.addMouseListener(new MouseAdapter() {
		             @Override
		             public void mouseClicked(MouseEvent e) {
		                 panelPrueba.setVisible(true);
		                 frase.setVisible(false);
		                 
		             }
		         });
		        
		         
		        
		      // Acción del botón "Verificar"
		         verificar.addActionListener(new ActionListener() {
		             @Override
		             public void actionPerformed(ActionEvent e) {
		                 String palabra1 = entrada1.getText().trim().toLowerCase();
		                 String palabra2 = entrada2.getText().trim().toLowerCase();

		                 if (palabra1.equals("triste") && palabra2.equals("habla")) {
		                     resultado.setText("Correcto! Has descifrado el mensaje.");
		                     panelPrueba.setVisible(false);
		                     lblLeccion.setVisible(true);
		                     darkOverlay.setVisible(true);
		                     lblContinuar.setVisible(true);
		                     btnDiario.setVisible(false);
		                     btnEnunciado.setVisible(false);
		                     pistaButton.setVisible(false);
		                 } else {
		                     JOptionPane.showMessageDialog(null, "Incorrecto");
		                 }
		             }
		         });
		
		
    }		
    
    
    private void visibilidadEnunciadoPane(boolean visibilidadEnunciado, boolean visibilidadPista) {
		
    	enunciadoPane.setVisible(true);
    	lblEnunciado.setVisible(visibilidadEnunciado);
		btnPrimeraPista.setVisible(visibilidadPista);
		btnSegundaPista.setVisible(visibilidadPista);
		btnTerceraPista.setVisible(visibilidadPista);
	}
}
