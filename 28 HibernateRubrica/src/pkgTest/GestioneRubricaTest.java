package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;
import servizi.*;

public class GestioneRubricaTest {

	@Test
	public void cercaRubricaTest() {
		
		GestioneRubrica g = new GestioneRubrica();
		assertNotNull(g);
		
		g.registraRubrica("Alessandro", "alexboa@tiscali.it");
		Rubrica out = g.cercaRubrica("alexboa@tiscali.it");
		
		assertEquals("alexboa@tiscali.it", out.getEmail());
		assertEquals("Alessandro", out.getNomeRubrica());
	}
	
	@Test
	public void aggiungiRubricaTest(){
		
		Rubrica r = new Rubrica("Mario", "mario@rossi.it");
		GestioneRubrica g = new GestioneRubrica();
		Rubrica out = null;
		
		
		
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
		
	}
	
	@Test
	public void aggiungiVoceTest(){
		
		
		Rubrica r = null;
		Voce v = new Voce (r, "Pablo", "Neruda", "987654");
		GestioneRubrica g = new GestioneRubrica();
		
		Voce out = null;
		
		
		assertEquals(v.getNome(), out.getNome());
		assertEquals(v.getCognome(), out.getCognome());
		assertEquals(v.getTelefono(), out.getTelefono());
	}

}
