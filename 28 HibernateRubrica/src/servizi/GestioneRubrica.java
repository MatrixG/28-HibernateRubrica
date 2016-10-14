package servizi;

import pkgDAO.RubricaDAO;
import pkgDAO.VoceDAO;
import pkgExceptions.RubricaGi‡Presente;
import pkgExceptions.RubricaNonEsiste;
import pkgExceptions.VoceNonPresente;

public class GestioneRubrica {
	
	private RubricaDAO myDAO = new RubricaDAO();
	private VoceDAO vDAO = new VoceDAO();
	
	
	// Registra una Rubrica
	public Rubrica registraRubrica(String nome, String email) throws RubricaGi‡Presente{
		
		if (email != null && nome != null){
			
			return myDAO.aggiungiRubricaDAO(nome, email);
		}
		return null;
	}
	
	// Cerca una rubrica
	public Rubrica cercaRubrica(String email) throws RubricaNonEsiste{
		
		if (email != null){
			
			return myDAO.cercaRubricaDAO(email);
		}
		return null;
	}
	
	
	public Voce aggiungiVoce(String nomeRubrica, String nome, 
							 String cognome,
							 String telefono) throws RubricaNonEsiste{
		
		if (nomeRubrica != null && nome != null &&
			cognome != null && telefono != null){
			
			return vDAO.aggiungiVoceDAO(nomeRubrica, nome, cognome, telefono);
		}
		return null;
	}
	
	
	// Cerca una voce di una rubrica
	public Voce cercaVoce(String nomeRubrica, String nome, String cognome) throws RubricaNonEsiste, VoceNonPresente{

		if (nomeRubrica != null && nome != null && cognome != null){
			
			return vDAO.cercaVoceDAO(nomeRubrica, nome, cognome);
		}
		return null;
	}
	
	public Voce eliminaVoce(String nomeRubrica, 
						    String nome, 
						    String cognome) throws RubricaNonEsiste{
		
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
