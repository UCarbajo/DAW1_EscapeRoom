package com.bilboSKP.partida.UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

public class SopaDeLetras extends JFrame {

    private JPanel contentPane;
    private JTextArea palabraSeleccionada;
    private Set<String> palabrasCorrectas = Set.of("PALABRAS", "DUELEN", "MÁS", "CREES"); // Palabras correctas
    private ArrayList<JButton> botonesSeleccionados = new ArrayList<>();
    private String[][] sopa = {
            {"P", "X", "X", "X", "B", "X", "M", "D"},
            {"D", "A", "E", "X", "E", "N", "Á", "U"},
            {"M", "C", "L", "X", "X", "X", "S", "E"},
            {"C", "R", "E", "A", "S", "X", "X", "L"},
            {"X", "R", "X", "E", "B", "X", "X", "E"},
            {"C", "X", "X", "X", "S", "R", "X", "N"},
            {"X", "X", "E", "X", "S", "X", "A", "X"},
            {"C", "R", "E", "E", "S", "X", "X", "S"}
    };
    private JLabel[] fraseHuecos;

    public SopaDeLetras() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Imagen de fondo
        JLabel lblFondo = new JLabel();
        lblFondo.setIcon(new ImageIcon("imagenes/PzrrA.jpeg"));
        lblFondo.setBounds(0, 0, 1280, 720);
        contentPane.add(lblFondo);

        // Panel izquierdo para la frase con huecos
        JPanel panelFrase = new JPanel();
        panelFrase.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelFrase.setBounds(300, 150, 600, 50);
        lblFondo.add(panelFrase);

        String[] frasePartes = {"Las", "_____", "_____", "_____", "de lo que", "_____"}; // Ajusta la frase aquí si es necesario
        fraseHuecos = new JLabel[frasePartes.length];

        for (int i = 0; i < frasePartes.length; i++) {
            JLabel lblParte = new JLabel(frasePartes[i]);
            lblParte.setFont(new Font("Arial", Font.BOLD, 18));
            if (frasePartes[i].equals("_____")) {
                lblParte.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                lblParte.setPreferredSize(new Dimension(100, 30));
                lblParte.setHorizontalAlignment(SwingConstants.CENTER);
                fraseHuecos[i] = lblParte;
            }
            panelFrase.add(lblParte);
        }

        // Panel central para la sopa de letras
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(sopa.length, sopa[0].length));
        panelCentral.setBounds(410, 225, 400, 200);
        lblFondo.add(panelCentral);

        for (int i = 0; i < sopa.length; i++) {
            for (int j = 0; j < sopa[i].length; j++) {
                JButton boton = new JButton(sopa[i][j]);
                boton.setFont(new Font("Arial", Font.BOLD, 16));
                panelCentral.add(boton);

                boton.addActionListener(e -> {
                    if (!botonesSeleccionados.contains(boton)) {
                        botonesSeleccionados.add(boton);
                        boton.setBackground(Color.YELLOW);
                        actualizarPalabraSeleccionada();
                    } else {
                        botonesSeleccionados.remove(boton);
                        boton.setBackground(null);
                        actualizarPalabraSeleccionada();
                    }
                });
            }
        }

        // Panel inferior con la palabra seleccionada y el botón "Comprobar"
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
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPalabra();
            }
        });
    }

    private void actualizarPalabraSeleccionada() {
        StringBuilder sb = new StringBuilder();
        for (JButton boton : botonesSeleccionados) {
            sb.append(boton.getText());
        }
        palabraSeleccionada.setText(sb.toString());
    }

    private void verificarPalabra() {
        String palabra = palabraSeleccionada.getText().toUpperCase();
        if (palabrasCorrectas.contains(palabra)) {
            // Rellenar la frase con la palabra encontrada
            for (int i = 0; i < fraseHuecos.length; i++) {
                JLabel hueco = fraseHuecos[i];
                if (hueco != null && hueco.getText().equals("_____")) {
                    hueco.setText(palabra);
                    hueco.setForeground(Color.GREEN);
                    break;
                }
            }
            // Resetear selección
            botonesSeleccionados.forEach(boton -> boton.setBackground(null));
            botonesSeleccionados.clear();
            palabraSeleccionada.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Palabra incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            // Resetear selección
            botonesSeleccionados.forEach(boton -> boton.setBackground(null));
            botonesSeleccionados.clear();
            palabraSeleccionada.setText("");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SopaDeLetras frame = new SopaDeLetras();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
