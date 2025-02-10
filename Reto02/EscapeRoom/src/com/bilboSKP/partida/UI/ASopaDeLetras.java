package com.bilboSKP.partida.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import herramientas.ImageRescaler;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ASopaDeLetras extends JPanel {

    private Font fontPersonal;
    private JTextArea palabraSeleccionada;
    private Map<String, Integer> palabrasCorrectas = new HashMap<>();
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private ArrayList<Point> posicionesSeleccionadas = new ArrayList<>();
    private String[][] sopa = {
        	{"P", "A", "L", "A", "B", "R", "A", "S"},
        	{"D", "A", "D", "X", "E", "N", "Á", "U"},
        	{"M", "C", "U", "X", "X", "Á", "M", "E"},
        	{"C", "R", "E", "A", "S", "Á", "X", "L"},
        	{"X", "R", "L", "E", "S", "X", "X", "E"},
        	{"C", "X", "E", "X", "S", "R", "X", "N"},
        	{"X", "X", "N", "X", "S", "X", "A", "X"},
        	{"C", "R", "E", "E", "S", "X", "X", "S"}
	};

    private JLabel[] fraseHuecos;
    private JButton[][] botones;
    private Map<String, ArrayList<Point>> palabrasYPosiciones = new HashMap<>();
    private JPanel enunciadoPane;
	private JLabel lblEnunciado;
	private JLabel lblFondoEnunciado;
	private JButton btnEnunciado;
	private JButton btnPistas;
	private JButton btnPrimeraPista;
	private JButton btnSegundaPista;
	private JButton btnTerceraPista;
	private JButton btnCerrar;
	private JPanel panelCentral;
	private JLabel lblFondo;
	private JPanel panelFrase;
	private Container panelInferior;

    public ASopaDeLetras(AEntradaJuego aEntradaJuego, Locale local) {
        try {
            fontPersonal = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/fonts/Chalk Brush.ttf"));
            fontPersonal = fontPersonal.deriveFont(17f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontPersonal);

        } catch (FontFormatException | IOException e1) {
            System.out.println("Error, font no cargado.");
            e1.printStackTrace();
        }

        setBounds(0, 0, 1400, 720);
        setLayout(null);
        
        ImageIcon fondoEnunciado = ImageRescaler.scaleImage("/imagenes/fondoEnunciado.png", 1400, 720);

		btnEnunciado = new JButton("ENUNCIADO");
		btnEnunciado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibilidadEnunciadoPane(true, false);
				lblFondo.setVisible(false);
			}
		});
		btnEnunciado.setOpaque(true);
		btnEnunciado.setBounds(1290, 100, 100, 80);
		aEntradaJuego.getContentPane().add(btnEnunciado, 0);

		btnPistas = new JButton("PISTAS");
		btnPistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visibilidadEnunciadoPane(false, true);
				lblFondo.setVisible(false);
			}
		});
		btnPistas.setOpaque(true);
		btnPistas.setBounds(1290, 200, 100, 80);
		aEntradaJuego.getContentPane().add(btnPistas, 0);
		
		enunciadoPane = new JPanel();
		enunciadoPane.setBounds(0, 0, 1400, 720);
		enunciadoPane.setOpaque(false);
		enunciadoPane.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		enunciadoPane.setLayout(null);
		add(enunciadoPane);

		lblEnunciado = new JLabel();
		lblEnunciado.setBounds(10, 10, 1280, 720);
		lblEnunciado.setOpaque(false);
		lblEnunciado.setForeground(Color.black);
		lblEnunciado.setFont(fontPersonal);
		lblEnunciado.setText(
				"<html><center><p>PRUEBA 02</p><br><p>Mientras examinas el lugar, notas varios trozos de papel rotos esparcidos por el suelo. Intentas leerlos, pero no les encuentras sentido.</p><br><p>Al darles la vuelta, descubres que cada fragmento tiene un n\u00FAmero escrito.</p><br><p>Descubre c\u00F3mo deben estar ordenados.</p></center></html>");
		lblEnunciado.setBorder(BorderFactory.createEmptyBorder(0, 100, 100, 100));
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setVerticalAlignment(SwingConstants.CENTER);
		enunciadoPane.add(lblEnunciado);

		btnPrimeraPista = new JButton(
				"<html><center><p>DESBLOQUEAR PRIMERA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnPrimeraPista.setBounds(265, 180, 740, 100);
		btnPrimeraPista.setVisible(false);
		enunciadoPane.add(btnPrimeraPista);

		btnSegundaPista = new JButton(
				"<html><center><p>DESBLOQUEAR SEGUNDA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnSegundaPista.setBounds(265, 290, 740, 100);
		btnSegundaPista.setVisible(false);
		enunciadoPane.add(btnSegundaPista);

		btnTerceraPista = new JButton(
				"<html></center><p>DESBLOQUEAR TERCERA PISTA</p><p>Monedas necesarias</p></center></html>");
		btnTerceraPista.setBounds(265, 400, 740, 100);
		btnTerceraPista.setVisible(false);
		enunciadoPane.add(btnTerceraPista);

		ImageIcon imgCerrar = ImageRescaler.scaleImage("/imagenes/simboloCerrar.png", 100, 100);
		ImageIcon imgCerrarRojo = ImageRescaler.scaleImage("/imagenes/simboloCerrarRojo.png", 100, 100);

		btnCerrar = new JButton();
		btnCerrar.setBounds(1120, 30, 100, 100);
		btnCerrar.setBackground(null);
		btnCerrar.setBorderPainted(false);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
		btnCerrar.setIcon(imgCerrar);
		enunciadoPane.add(btnCerrar);

		lblFondoEnunciado = new JLabel();
		lblFondoEnunciado.setBounds(10, 10, 1280, 700);
		lblFondoEnunciado.setIcon(fondoEnunciado);
		enunciadoPane.add(lblFondoEnunciado);

        lblFondo = new JLabel();
        lblFondo.setIcon(ImageRescaler.scaleImage("/imagenes/PzrrA.jpeg", 1400, 720));
        lblFondo.setBounds(0, 0, 1400, 720);
        lblFondo.setVisible(false);
        add(lblFondo);

        panelFrase = new JPanel();
        panelFrase.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelFrase.setBounds(200, 150, 800, 50);
        panelFrase.setFont(fontPersonal);
        lblFondo.add(panelFrase);

        String[] frasePartes = {"Las", "_____", "_____", "_____", "de lo que", "_____"}; 
        fraseHuecos = new JLabel[frasePartes.length];

        palabrasCorrectas.put("PALABRAS", 1);
        palabrasCorrectas.put("DUELEN", 2);
        palabrasCorrectas.put("MÁS", 3);
        palabrasCorrectas.put("CREES", 5);

        for (int i = 0; i < frasePartes.length; i++) {
            JLabel lblParte = new JLabel(frasePartes[i]);
            lblParte.setFont(fontPersonal);
            if (frasePartes[i].equals("_____")) {
                lblParte.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lblParte.setPreferredSize(new Dimension(150, 30));
                lblParte.setHorizontalAlignment(SwingConstants.CENTER);
                fraseHuecos[i] = lblParte;
            }
            panelFrase.add(lblParte);
        }

        panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(sopa.length, sopa[0].length));
        panelCentral.setBounds(410, 225, 400, 200);
        lblFondo.add(panelCentral);

        botones = new JButton[sopa.length][sopa[0].length];

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa[i].length; j++) {
                JButton boton = new JButton(sopa[i][j]);
                boton.setFont(new Font("Arial", Font.BOLD, 16));
                panelCentral.add(boton);
                botones[i][j] = boton;

                final int row = i;
                final int col = j;

                boton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (!botonesSeleccionados.contains(boton)) {
                            botonesSeleccionados.add(boton);
                            boton.setBackground(Color.YELLOW);
                            posicionesSeleccionadas.add(new Point(row, col));
                            actualizarPalabraSeleccionada();
                        } else {
                            botonesSeleccionados.remove(boton);
                            boton.setBackground(null);
                            removerPosicionSeleccionada(row, col);
                            actualizarPalabraSeleccionada();
                        }
                    }
                });
            }
        }

        panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout(10, 10));
        panelInferior.setBounds(410, 450, 400, 50);
        lblFondo.add(panelInferior);

        palabraSeleccionada = new JTextArea(1, 20);
        palabraSeleccionada.setFont(new Font("Arial", Font.PLAIN, 18));
        palabraSeleccionada.setEditable(false);
        panelInferior.add(palabraSeleccionada, BorderLayout.CENTER);

        JButton btnComprobar = new JButton("Comprobar");
        btnComprobar.setFont(new Font("Arial", Font.BOLD, 16));
        panelInferior.add(btnComprobar, BorderLayout.EAST);

        btnComprobar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                verificarPalabra();
            }
        });
        
        btnCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enunciadoPane.setVisible(false);
				lblFondo.setVisible(true);
				repaint();
				revalidate();

			}
		});
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setIcon(imgCerrarRojo);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setIcon(imgCerrar);
			}
		});

        inicializarPalabras();
    }


    private void actualizarPalabraSeleccionada() {
        StringBuilder sb = new StringBuilder();
        for (JButton boton : botonesSeleccionados) {
            sb.append(boton.getText());
        }
        palabraSeleccionada.setText(sb.toString());
    }

    private void removerPosicionSeleccionada(int row, int col) {
        posicionesSeleccionadas.removeIf(p -> p.x == row && p.y == col);
    }

    private void verificarPalabra() {
        String palabra = palabraSeleccionada.getText().toUpperCase();

        if (palabrasYPosiciones.containsKey(palabra)) {
            ArrayList<Point> posicionesPalabra = palabrasYPosiciones.get(palabra);
            if (compararPosiciones(posicionesPalabra, posicionesSeleccionadas)) {
                colocarPalabraEnFrase(palabra);
                for (JButton boton : botonesSeleccionados) {
                    boton.setEnabled(false);
                    boton.setBackground(new Color(76,153,0));
                }
                botonesSeleccionados.clear();
                posicionesSeleccionadas.clear();
                palabraSeleccionada.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Las letras seleccionadas no corresponden a la ubicación correcta de la palabra.", "Posiciones incorrectas", JOptionPane.ERROR_MESSAGE);
                restablecerSeleccion();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Palabra incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            restablecerSeleccion();
        }
    }

    private boolean compararPosiciones(ArrayList<Point> posicionesPalabra, ArrayList<Point> posicionesUsuario) {
        if (posicionesPalabra.size() != posicionesUsuario.size()) {
            return false;
        }

        Comparator<Point> comparator = new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                if (p1.x != p2.x) {
                    return Integer.compare(p1.x, p2.x);
                } else {
                    return Integer.compare(p1.y, p2.y);
                }
            }
        };

        Collections.sort(posicionesPalabra, comparator);
        Collections.sort(posicionesUsuario, comparator);

        for (int i = 0; i < posicionesPalabra.size(); i++) {
            Point p1 = posicionesPalabra.get(i);
            Point p2 = posicionesUsuario.get(i);
            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }

    private void colocarPalabraEnFrase(String palabra) {
        int index = palabrasCorrectas.get(palabra);
        JLabel hueco = fraseHuecos[index];

        if (hueco != null && hueco.getText().equals("_____")) {
            hueco.setText(palabra);
            hueco.setForeground(Color.black);
        }
    }

    private void restablecerSeleccion() {
        for (JButton boton : botonesSeleccionados) {
            boton.setBackground(null);
        }
        botonesSeleccionados.clear();
        posicionesSeleccionadas.clear();
        palabraSeleccionada.setText("");
    }

    private void inicializarPalabras() {
        ArrayList<Point> posicionesPalabras = new ArrayList<>();
        for (int col = 0; col <= 7; col++) {
            posicionesPalabras.add(new Point(0, col));
        }
        palabrasYPosiciones.put("PALABRAS", posicionesPalabras);


        ArrayList<Point> posicionesDuelen = new ArrayList<>();
        posicionesDuelen.add(new Point(1, 2)); 
        posicionesDuelen.add(new Point(2, 2)); 
        posicionesDuelen.add(new Point(3, 2)); 
        posicionesDuelen.add(new Point(4, 2)); 
        posicionesDuelen.add(new Point(5, 2)); 
        posicionesDuelen.add(new Point(6, 2)); 
        palabrasYPosiciones.put("DUELEN", posicionesDuelen);


        ArrayList<Point> posicionesMas = new ArrayList<>();
        posicionesMas.add(new Point(2, 6)); 
        posicionesMas.add(new Point(3, 5)); 
        posicionesMas.add(new Point(4, 4)); 
        palabrasYPosiciones.put("MÁS", posicionesMas);

        ArrayList<Point> posicionesCrees = new ArrayList<>();
        for (int col = 0; col <= 4; col++) {
            posicionesCrees.add(new Point(7, col));
        }
        palabrasYPosiciones.put("CREES", posicionesCrees);
    }
    private void visibilidadEnunciadoPane(boolean visibilidadEnunciado, boolean visibilidadPista) {
		enunciadoPane.setVisible(true);
		lblEnunciado.setVisible(visibilidadEnunciado);
		btnPrimeraPista.setVisible(visibilidadPista);
		btnSegundaPista.setVisible(visibilidadPista);
		btnTerceraPista.setVisible(visibilidadPista);
		repaint();
		revalidate();
	}
}

