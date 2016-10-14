package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pkgExceptions.RubricaGi‡Presente;
import pkgExceptions.RubricaNonEsiste;
import pkgExceptions.VoceNonPresente;
import pkgRubrica.Rubrica;
import pkgRubrica.Voce;

public class VoceDAO extends ConnesioneDAO{
	
	private Connection con = connetti();
	private RubricaDAO rDAO = new RubricaDAO();
	
	public Voce cercaVoceDAO(String nomeR, String nome, String cognome) throws RubricaNonEsiste, VoceNonPresente{
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeR);
		
		Voce v = null;
		if (r != null){
		
		String sql = "SELECT * " +
			 	 "FROM Voce " +
			 	 "WHERE NOME = ? AND COGNOME = ? AND ID_RUBRICA_FK = ?";
	
	ResultSet rs = null;
	PreparedStatement ps = null;
	try {
		ps = con.prepareStatement(sql);
		ps.setString(1, nome);
		ps.setString(2, cognome);
		ps.setInt(3, r.getId());
		rs = ps.executeQuery();
		
		if (rs.next()){
			
			v = new Voce(rs.getInt(1), rs.getString(2),
							   rs.getString(3), rs.getString(4));
		}else{
			
			throw new VoceNonPresente("Contatto non Ë presente!");
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally {
		if (rs != null) try { rs.close(); } catch (SQLException e){e.printStackTrace();}
		if (ps != null) try { ps.close(); } catch (SQLException e){e.printStackTrace();}
	}
		}
	
	if (r == null)
		throw new RubricaNonEsiste("Rubrica non presente");
		
	
	return v;
	}
	
	public Voce aggiungiVoceDAO (String nomeR, String nome, String cognome, String telefono) throws RubricaNonEsiste{
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeR);
		
		Voce v = null;
		if (!cercaUtente(nomeR, nome, cognome) && r != null){
			String sql = "INSERT INTO VOCE(nome, cognome, telefono, id_rubrica_fk) " +
						 "VALUES (?, ?, ?, ?)";
		
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setString(2, cognome);
				ps.setString(3, telefono);
				ps.setInt(4, r.getId());
				
				if (ps.executeUpdate() == 1){
					
					return cercaVoceDAO(nomeR, nome, cognome);
				
				}	
			} catch (SQLException | RubricaNonEsiste | VoceNonPresente e) {
				
				e.printStackTrace();
			}finally {
				if (ps != null) try { ps.close(); } catch (SQLException e){e.printStackTrace();}
			}	
		}
	
	return v;
	}

	
	private boolean cercaUtente (String nomeR, String nome, String cognome) throws RubricaNonEsiste{
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeR);
		
		if (r != null){
		
			String sql = "SELECT * " +
				 	 	 "FROM Voce " +
				 	     "WHERE NOME = ? AND COGNOME = ? AND ID_RUBRICA_FK = ?";
			
			ResultSet rs = null;
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setString(2, cognome);
				ps.setInt(3, r.getId());
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
				}
		return false;
	}

	public Voce eliminaVoceDAO(String nomeRubrica, String nome, String cognome) throws RubricaNonEsiste {
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeRubrica);
		
		Voce v = null;
		if (r != null){
			{
				v = cercaVoceDAO(nomeRubrica, nome, cognome);
				
				
				
				String sql = "DELETE " +
				 	 	 	 "FROM Voce " +
				 	 	 	 "WHERE NOME = ? AND COGNOME = ? AND ID_RUBRICA_FK = ?";
			
				ResultSet rs = null;
				PreparedStatement ps = null;
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, nome);
					ps.setString(2, cognome);
					ps.setInt(3, r.getId());
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
				
			}
		}
		
		return null;
	}
}
