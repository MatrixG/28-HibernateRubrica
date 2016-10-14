package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import dao.*;

public class RubricaDAOTest {

	@Test
	public void cercaRubricaDAOTest() {
		
		Rubrica r = new Rubrica(1, "Alessandro", "alexboa@tiscali.it");
		RubricaDAO rDAO = new RubricaDAO();
		Rubrica out = null;
		

		
		assertEquals(r.getId(), out.getId());
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
	}
	
	@Test
	public void aggiungiRubricaDAOTest(){
		
		Rubrica r = new Rubrica(2, "Pinco", "pincopallino@hotmail.com");
		RubricaDAO rDAO = new RubricaDAO();
		Rubrica out = null;
		

		
		assertEquals(r.getEmail(), out.getEmail());
		assertEquals(r.getNomeRubrica(), out.getNomeRubrica());
		
	}

}
