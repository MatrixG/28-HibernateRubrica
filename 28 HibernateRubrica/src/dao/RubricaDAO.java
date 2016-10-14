package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pkgExceptions.RubricaGi‡Presente;
import pkgExceptions.RubricaNonEsiste;
import pkgRubrica.Rubrica;

public class RubricaDAO extends ConnesioneDAO{
	
	private Connection con = connetti();
	
	// Cerca una rubrica passando la mail dell'utente
	public Rubrica cercaRubricaDAO(String email) throws RubricaNonEsiste{
		
		String sql = "SELECT * " +
				 	 "FROM Rubrica " +
				 	 "WHERE MAIL = ?";
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		Rubrica r = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if (rs.next()){
				
				r = new Rubrica(rs.getInt(1), rs.getString(2),
								   rs.getString(3));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if (rs != null) try { rs.close(); } catch (SQLException e){e.printStackTrace();}
			if (ps != null) try { ps.close(); } catch (SQLException e){e.printStackTrace();}
		}
		
		if (r == null)
			throw new RubricaNonEsiste("Rubrica non presente");
		
		return r;
	}
	
	
	// Aggiunge una nuova rubrica
	public Rubrica aggiungiRubricaDAO(String nome, String email) throws RubricaGi‡Presente{
			
			if (!cercaRubrica(email)){
				String sql = "INSERT INTO RUBRICA(nome, mail) " +
							 "VALUES (?, ?)";
			
				PreparedStatement ps = null;
				Rubrica r = null;
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, nome);
					ps.setString(2, email);
					
					if (ps.executeUpdate() == 1){
						
						return cercaRubricaDAO(email);
					
					}	
				} catch (SQLException | RubricaNonEsiste e) {
					
					e.printStackTrace();
				}finally {
					if (ps != null) try { ps.close(); } catch (SQLException e){e.printStackTrace();}
				}
				return r;	
			}
		
		throw new RubricaGi‡Presente("La rubrica Ë gi‡ presente");
	}
	
	
	
	private boolean cercaRubrica(String email){
		
		String sql = "SELECT * " +
			 	 "FROM Rubrica " +
			 	 "WHERE MAIL = ?";
	
	ResultSet rs = null;
	PreparedStatement ps = null;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		
		if (rs.next()){
			
			return true;
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		if (rs != null) try { rs.close(); } catch (SQLException e){e.printStackTrace();}
		if (ps != null) try { ps.close(); } catch (SQLException e){e.printStackTrace();}
	}
	
	return false;
	}
}
