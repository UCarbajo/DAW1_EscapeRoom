package com.bilboSKP.partida.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SopaDeLetras extends JFrame {

    private JPanel contentPane;
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

    public SopaDeLetras() {
        try {
            fontPersonal = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Chalk Brush.ttf"));
            fontPersonal = fontPersonal.deriveFont(17f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fontPersonal);

        } catch (FontFormatException | IOException e1) {
            System.out.println("Error, font no cargado.");
            e1.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFondo = new JLabel();
        lblFondo.setIcon(new ImageIcon("imagenes/PzrrA.jpeg"));
        lblFondo.setBounds(0, 0, 1280, 720);
        contentPane.add(lblFondo);

        JPanel panelFrase = new JPanel();
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

        JPanel panelCentral = new JPanel();
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

        JPanel panelInferior = new JPanel();
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
}

