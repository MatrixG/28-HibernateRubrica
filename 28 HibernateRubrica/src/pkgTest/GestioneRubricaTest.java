package pkgTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.*;
import servizi.*;

public class GestioneRubricaTest {
	
	@Test
	public void gestioneRubricaTest(){
		
		GestioneRubrica g = new GestioneRubrica();
		assertNotNull(g);
		
		g.registraRubrica("Alessandro", "alexboa@tiscali.it");
		Rubrica out = g.cercaRubrica("alexboa@tiscali.it");
		
		assertEquals("alexboa@tiscali.it", out.getEmail());
		assertEquals("Alessandro", out.getNomeRubrica());
		
	}

}
