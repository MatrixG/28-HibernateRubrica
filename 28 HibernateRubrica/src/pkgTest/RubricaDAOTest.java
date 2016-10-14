package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;
import pkgRubrica.*;
import pkgDAO.*;
import pkgExceptions.RubricaGi‡Presente;
import pkgExceptions.RubricaNonEsiste;

public class RubricaDAOTest {

	@Test
	public void cercaRubricaDAOTest() {
		
		Rubrica r = new Rubrica(1, "Alessandro", "alexboa@tiscali.it");
		RubricaDAO rDAO = new RubricaDAO();
		Rubrica out = null;
		
		try {
			out = rDAO.cercaRubricaDAO("alexboa@tiscali.it");
		} catch (RubricaNonEsiste e) {
		
			e.printStackTrace();
		}
		
		assertEquals(r.getId(), out.getId());
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
	}
	
	@Test
	public void aggiungiRubricaDAOTest(){
		
		Rubrica r = new Rubrica(2, "Pinco", "pincopallino@hotmail.com");
		RubricaDAO rDAO = new RubricaDAO();
		Rubrica out = null;
		
		try {
			out = rDAO.aggiungiRubricaDAO("Pinco", "pincopallino@hotmail.com");
		} catch (RubricaGi‡Presente e) {
			e.printStackTrace();
		}
		
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
		
	}

}
