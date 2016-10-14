package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;

import pkgExceptions.RubricaGi‡Presente;
import pkgExceptions.RubricaNonEsiste;
import pkgExceptions.VoceNonPresente;
import pkgRubrica.GestioneRubrica;
import pkgRubrica.Rubrica;
import pkgRubrica.Voce;

public class GestioneRubricaTest {

	@Test
	public void cercaRubricaTest() {
		
		Rubrica r = new Rubrica(1, "Alessandro", "alexboa@tiscali.it");
		GestioneRubrica g = new GestioneRubrica();
		Rubrica out = null;
		
		try {
			out = g.cercaRubrica("alexboa@tiscali.it");
		} catch (RubricaNonEsiste e) {
			
			e.printStackTrace();
		}
		
		assertEquals(r.getId(), out.getId());
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
	}
	
	@Test
	public void aggiungiRubricaTest(){
		
		Rubrica r = new Rubrica(1, "Mario", "mario@rossi.it");
		GestioneRubrica g = new GestioneRubrica();
		Rubrica out = null;
		
		try {
			out = g.registraRubrica("Mario", "mario@rossi.it");
		} catch (RubricaGi‡Presente e) {
			
			e.printStackTrace();
		}
		
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
		
	}
	
	@Test
	public void aggiungiVoceTest(){
		
		Voce v = new Voce (1, "Pablo", "Neruda", "987654");
		GestioneRubrica g = new GestioneRubrica();
		
		Voce out = null;
		try {
		
			out = g.aggiungiVoce("alexboa@tiscali.it", v.getNome(), v.getCognome(), v.getTelefono());
		
		} catch (RubricaNonEsiste e) {
			e.printStackTrace();
		}
		
		assertEquals(v.getNome(), out.getNome());
		assertEquals(v.getCognome(), out.getCognome());
		assertEquals(v.getTelefono(), out.getTelefono());
	}

}
