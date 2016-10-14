package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;

import pkgDAO.VoceDAO;
import pkgExceptions.RubricaNonEsiste;
import pkgExceptions.VoceNonPresente;
import pkgRubrica.GestioneRubrica;
import pkgRubrica.Voce;

public class VoceDAOTest {

	@Test
	public void testRicercaUtente() {
		
		Voce v = new Voce (1, "Pinco", "Pallino", "01234567");
		VoceDAO vDAO = new VoceDAO();
		Voce out = null;
		try {
		
			out = vDAO.cercaVoceDAO("alexboa@tiscali.it", v.getNome(), v.getCognome());
		
		} catch (RubricaNonEsiste | VoceNonPresente e) {
			e.printStackTrace();
		}
		
		assertEquals(v.getId(), out.getId());
		assertEquals(v.getNome(), out.getNome());
		assertEquals(v.getCognome(), out.getCognome());
		assertEquals(v.getTelefono(), out.getTelefono());
		
	}
	
	@Test
	public void aggiungiVoceTest(){
		
		Voce v = new Voce (1, "Massimo", "Meridio", "333456123");
		VoceDAO vDAO = new VoceDAO();
		Voce out = null;
		try {
		
			out = vDAO.aggiungiVoceDAO("alexboa@tiscali.it", v.getNome(), v.getCognome(), v.getTelefono());
		
		} catch (RubricaNonEsiste e) {
			e.printStackTrace();
		}
		
		assertEquals(v.getNome(), out.getNome());
		assertEquals(v.getCognome(), out.getCognome());
		assertEquals(v.getTelefono(), out.getTelefono());
	}

}
