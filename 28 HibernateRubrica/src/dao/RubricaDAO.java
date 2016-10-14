package dao;

import model.*;

public class RubricaDAO {
	
	
	
	public Rubrica cercaRubricaDAO(String email) {
		
		String sql = "SELECT * " +
				 	 "FROM Rubrica " +
				 	 "WHERE MAIL = ?";
		
		
		
		return null;
	}
	
	

	public Rubrica aggiungiRubricaDAO(String nome, String email) {
			
			if (!cercaRubrica(email)){
				String sql = "INSERT INTO RUBRICA(nome, mail) " +
							 "VALUES (?, ?)";
			
				
				return null;	
			}
		
		return null;
	}
	
	
	
	private boolean cercaRubrica(String email){
		
		String sql = "SELECT * " +
			 	 "FROM Rubrica " +
			 	 "WHERE MAIL = ?";
	
	
	
	return false;
	}
}
