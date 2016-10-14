package servizi;

import dao.*;
import model.Rubrica;
import model.Voce;



public class GestioneRubrica {
	
	private RubricaDAO myDAO = new RubricaDAO();
	private VoceDAO vDAO = new VoceDAO();
	
	
	// Registra una Rubrica
	public Rubrica registraRubrica(String nome, String email) {
		
		if (email != null && nome != null){
			
			return myDAO.aggiungiRubricaDAO(nome, email);
		}
		return null;
	}
	
	// Cerca una rubrica
	public Rubrica cercaRubrica(String email) {
		
		if (email != null){
			
			return myDAO.cercaRubricaDAO(email);
		}
		return null;
	}
	
	
	public Voce aggiungiVoce(String nomeRubrica, String nome, 
							 String cognome,
							 String telefono){
		
		if (nomeRubrica != null && nome != null &&
			cognome != null && telefono != null){
			
			return vDAO.aggiungiVoceDAO(nomeRubrica, nome, cognome, telefono);
		}
		return null;
	}
	
	
	// Cerca una voce di una rubrica
	public Voce cercaVoce(String nomeRubrica, String nome, String cognome) {

		if (nomeRubrica != null && nome != null && cognome != null){
			
			return vDAO.cercaVoceDAO(nomeRubrica, nome, cognome);
		}
		return null;
	}
	
	public Voce eliminaVoce(String nomeRubrica, 
						    String nome, 
						    String cognome) {
		
		if (nomeRubrica != null && nome != null && cognome != null){
			
			return vDAO.eliminaVoceDAO(nomeRubrica, nome, cognome);
		}
		
		
		return null;
	}
	
	public Voce modificaVoce(String nomeRubrica, String nome, 
							 String cognome, 
							 String telefono){
		
		return null;
	}
}
