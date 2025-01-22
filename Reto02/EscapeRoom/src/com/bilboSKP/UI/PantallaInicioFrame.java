package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PantallaInicioFrame extends JFrame {

	private JPanel contentPane;
	private ImageIcon originalIcon;

	public PantallaInicioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel JLabelImagen = new JLabel("");
		JLabelImagen.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelImagen.setIcon(new ImageIcon("D:\\Proyecto2\\DALL\u00B7E 2025-01-21 12.59.33 - A creative and dramatic design for a start screen of an escape room themed around bullying and witnessing. The central focus is a wooden door with a d.jpg"));
		JLabelImagen.setEnabled(false);
		contentPane.add(JLabelImagen, BorderLayout.CENTER);
		
		originalIcon = new ImageIcon ("D:\\Proyecto2\\DALL\u00B7E 2025-01-21 12.59.33 - A creative and dramatic design for a start screen of an escape room themed around bullying and witnessing. The central focus is a wooden door with a d.jpg");

	}

}
