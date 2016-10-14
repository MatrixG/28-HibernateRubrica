package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Voce;
import utility.DataSource;

public class VoceDAO {
	
	//1- Create
	public int creaVoce(String nome, String cognome, String telefono, int id){
		int token = 0;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "INSERT INTO VOCE (NOME, COGNOME, TELEFONO, ID_RUBRICA) VALUES (?, ?, ?, ?)";
			st = con.prepareStatement(sql, new String[]{"ID_VOCE"});
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, telefono);
			st.setInt(4, id);
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()&&rs!=null){
				token = rs.getInt(1);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
		return token;
	}
	
	//2- Read
	public Map<Integer, Voce> trovaVoce(int id_r){
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Map<Integer, Voce> lista = new TreeMap<Integer, Voce>();
		try {
			String sql = "SELECT * FROM VOCE WHERE ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_r);
			rs = st.executeQuery();
			while(rs.next()){
					int id_V = rs.getInt(1);
					String nome = rs.getString(2);
					String cognome = rs.getString(3);
					String telefono = rs.getString(4);
					int id_R = rs.getInt(5);
					v = new Voce(id_V, nome, cognome, telefono, id_R);
					lista.put(v.getId_voce(), v);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
		return lista;
	}
	
	public Voce trovaVoce(int id_v, int id_r){
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM VOCE WHERE ID_VOCE =? AND ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_v);
			st.setInt(2, id_r);
			rs = st.executeQuery();
			
			if(rs.next()){
				int id_V = rs.getInt(1);
				String nome = rs.getString(2);
				String cognome = rs.getString(3);
				String telefono = rs.getString(4);
				int id_R = rs.getInt(5);
				v = new Voce(id_V, nome, cognome, telefono, id_R);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
		return v;
	}
	
	public Voce trovaVoce(String nome, String cognome, int id_r){
		Voce v = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM VOCE WHERE NOME =? AND COGNOME =? AND ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setInt(3, id_r);
			rs = st.executeQuery();
			
			if(rs.next()){
				int id_v = rs.getInt(1);
				String name = rs.getString(2);
				String surname = rs.getString(3);
				String phone = rs.getString(4);
				int id_R = rs.getInt(5);
				v = new Voce(id_v, name, surname, phone, id_R);
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}		
		return v;
	}
	
	//3- Update
	public boolean aggiornaVoce(String nome, String cognome, String telefono, int id_v){
		boolean token = false;
		PreparedStatement st = null;
		try {
			String sql = "UPDATE VOCE SET NOME=?, COGNOME=?, TELEFONO=? WHERE ID_VOCE=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setString(2, cognome);
			st.setString(3, telefono);
			st.setInt(4, id_v);
			int res = st.executeUpdate();
			if(res>0){
				token = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return token;
	}
	
	//4- Delete
	public boolean rimuoviVoce(int id_v){
		boolean token = false;
		PreparedStatement st = null;
		try {
			String sql = "DELETE FROM VOCE WHERE ID_VOCE=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id_v);
			int res = st.executeUpdate();
			if(res>0){
				token = true;
			}
		} catch (SQLException | IOException | PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return token;
	}

}