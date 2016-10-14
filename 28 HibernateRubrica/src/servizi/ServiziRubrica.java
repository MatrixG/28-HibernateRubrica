package servizi;

import java.util.Map;

import model.Rubrica;
import model.Voce;
import dao.VoceDAO;

public class ServiziRubrica {
	
	private VoceDAO vDAO = new VoceDAO();

	public Voce aggiungiVoce(Rubrica r, String nome, String cognome, String telefono){
		Voce v = null;
		int id = vDAO.creaVoce(nome, cognome, telefono, r.getId_rubrica());
		if(id!=0){
			v = vDAO.trovaVoce(id, r.getId_rubrica());
		}
		return v;
	}
	
	public Voce getVoce(Rubrica r, String nome, String cognome){
		Voce v = null;
		v = vDAO.trovaVoce(nome, cognome, r.getId_rubrica());
		return v;		
	}
	
	public Map<Integer, Voce> getAll(Rubrica r){
		return vDAO.trovaVoce(r.getId_rubrica());
	}

	public Voce updateVoce(Rubrica r, String nomeVecchio, String cognomeVecchio, 
			String nome, String cognome, String telefono){
		Voce v = null;
		v = vDAO.trovaVoce(nomeVecchio, cognomeVecchio, r.getId_rubrica());
		if(v!=null){
			vDAO.aggiornaVoce(nome, cognome, telefono, v.getId_voce());
			v = vDAO.trovaVoce(nome, cognome, r.getId_rubrica());
		}
		return v;
	}
	
	public void deleteVoce(Rubrica r, String nome, String cognome){
		Voce v = vDAO.trovaVoce(nome, cognome, r.getId_rubrica());
		vDAO.rimuoviVoce(v.getId_voce());		
	}

	
}