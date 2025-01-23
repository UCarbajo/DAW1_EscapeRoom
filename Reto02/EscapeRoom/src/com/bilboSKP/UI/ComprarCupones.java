package com.bilboSKP.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bilboSKP.baseDatos.EscapeRoomBD;
import com.bilboSKP.centroEscolar.CentroEscolar;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComprarCupones extends JFrame {

	private JPanel contentPane;
	private JTextField NumeroCupones;

	public ComprarCupones(CentroEscolar centro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton ComprarCupones = new JButton("ComprarCupones");
		ComprarCupones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numeroCupones = Integer.parseInt(NumeroCupones.getText());
				comprarCupones(centro, numeroCupones);
			}
		});
		ComprarCupones.setBounds(180, 86, 111, 21);
		contentPane.setLayout(null);
		
		NumeroCupones = new JTextField();
		NumeroCupones.setBounds(180, 125, 96, 19);
		NumeroCupones.setColumns(10);
		contentPane.add(NumeroCupones);
		contentPane.add(ComprarCupones);
	}
	private void comprarCupones(CentroEscolar centro, int numeroCupones) {
		EscapeRoomBD acceso = new EscapeRoomBD();
		acceso.comprarCupones(centro, numeroCupones);
		
	}
}
