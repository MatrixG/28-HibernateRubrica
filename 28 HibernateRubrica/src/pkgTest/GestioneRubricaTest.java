package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;
import servizi.*;

public class GestioneRubricaTest {

	@Test
	public void cercaRubricaTest() {
		
		Rubrica r = new Rubrica(1, "Alessandro", "alexboa@tiscali.it");
		GestioneRubrica g = new GestioneRubrica();
		Rubrica out = null;
		
		
		
		assertEquals(r.getId(), out.getId());
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
	}
	
	@Test
	public void aggiungiRubricaTest(){
		
		Rubrica r = new Rubrica(1, "Mario", "mario@rossi.it");
		GestioneRubrica g = new GestioneRubrica();
		Rubrica out = null;
		
		
		
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
		
	}
	
	@Test
	public void aggiungiVoceTest(){
		
		Voce v = new Voce (1, "Pablo", "Neruda", "987654");
		GestioneRubrica g = new GestioneRubrica();
		
		Voce out = null;
		
		
		assertEquals(v.getNome(), out.getNome());
		assertEquals(v.getCognome(), out.getCognome());
		assertEquals(v.getTelefono(), out.getTelefono());
	}

}
