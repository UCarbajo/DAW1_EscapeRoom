package com.bilboSKP.baseDatos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bilboSKP.centroEscolar.CentroEscolar;
import com.bilboSKP.cupones.Cupones;
import com.bilboSKP.ranking.Ranking;

public class EscapeRoomBD extends AccesoBD {

	public EscapeRoomBD() {
		super(DRIVER_MYSQL, "EscapeRoom", "root", "");
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Ranking> getRanking(CentroEscolar centro) {
		ArrayList<Ranking> listaRanking = null;
		String sql = "Select * FROM ranking WHERE Cif = ?";
		try {
			conectar();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, centro.getCif());
			rs = ps.executeQuery();
			while (rs.next()) {
				Ranking ranking = new Ranking(rs.getInt("puntuacion"), rs.getString("nomClase"));
				listaRanking.add(ranking);
			}
			desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaRanking;
	}

	public CentroEscolar comprobarCentro(String txtrUsuario, String txtrContracea) {
		try {
			String sql = "SELECT * FROM CentroEscolar WHERE username = ? AND contraseña = ?";
			conectar();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, txtrUsuario);
			ps.setString(2, txtrContracea);
			rs = ps.executeQuery();
			if (rs.next()) {
				CentroEscolar centro = new CentroEscolar(rs.getString(0), rs.getString(1));
				return centro;
			}
			desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void comprarCupones(CentroEscolar centro, int numeroCupones) {
		try {
			String sql = "INSERT INTO cupones (FechaActivacion, Estado, FechaCaducidad, CIF)"
					+ "VALUES (?, ?, ?, ?)";
			conectar();
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < numeroCupones; i++) {
				Cupones cupon = new Cupones(centro);
				ps.setDate(1, cupon.getFechaActivacionToDate());
				ps.setString(2, cupon.getEstado());
				ps.setDate(3, cupon.getFechaCaducidadToDate());
				ps.setString(4, cupon.getCentroID());
				ps.execute();
			}
			
			desconectar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
