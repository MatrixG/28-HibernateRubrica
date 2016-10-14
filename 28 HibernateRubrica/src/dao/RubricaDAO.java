package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DataSource;
import model.*;

public class RubricaDAO {
	
	//1- Create
	public int creaRubrica(String nome){
		int token = 0;
		PreparedStatement st = null;
		try {
			Connection con = DataSource.getInstance().getConnection();
			String sql = "INSERT INTO RUBRICA (NOME) VALUES (?)";
			st = con.prepareStatement(sql, new String[]{"ID_RUBRICA"});
			st.setString(1, nome);
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
	public Rubrica trovaRubrica(int id){
		Rubrica r = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM RUBRICA WHERE ID_RUBRICA =?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()){
				int id_r = rs.getInt(1);
				String nome = rs.getString(2);
				r = new Rubrica(id_r, nome);
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
		return r;
	}
	
	//3- Update
	public boolean aggiornaRubrica(int id, String nome){
		boolean token = false;
		PreparedStatement st = null;
		try {
			String sql = "UPDATE RUBRICA SET NOME=? WHERE ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setString(1, nome);
			st.setInt(2, id);
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
	public boolean rimuoviRubrica(int id){
		boolean token = false;
		PreparedStatement st = null;
		try {
			String sql = "DELETE FROM RUBRICA WHERE ID_RUBRICA=?";
			Connection con = DataSource.getInstance().getConnection();
			st = con.prepareStatement(sql);
			st.setInt(1, id);
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