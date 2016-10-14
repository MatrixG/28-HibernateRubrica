package prova;

import java.util.Map;

import dao.RubricaDAO;
import servizi.ServiziRubrica;
import model.Rubrica;
import model.Voce;

public class RubricaMain {

	public static void main(String[] args) {
		
		RubricaDAO rDAO = new RubricaDAO();
		rDAO.creaRubrica("Fabrizio");
		Rubrica r = rDAO.trovaRubrica(1);
		System.out.println(r.getNome());
		
		ServiziRubrica g = new ServiziRubrica();
		
		Voce v1 = g.aggiungiVoce(r, "aaa", "aaa", "111");
		System.out.println(v1.getId_voce()+"\t"+v1.getNome()+"\t"+v1.getCognome()+"\t"+v1.getTelefono());
		Voce v2 = g.aggiungiVoce(r, "bbb", "bbb", "222");
		System.out.println(v2.getId_voce()+"\t"+v2.getNome()+"\t"+v2.getCognome()+"\t"+v2.getTelefono());
		Voce v3 = g.aggiungiVoce(r, "ccc", "ccc", "333");
		System.out.println(v3.getId_voce()+"\t"+v3.getNome()+"\t"+v3.getCognome()+"\t"+v3.getTelefono());
		Voce v4 = g.aggiungiVoce(r, "ddd", "ddd", "444");
		System.out.println(v4.getId_voce()+"\t"+v4.getNome()+"\t"+v4.getCognome()+"\t"+v4.getTelefono());
		
		System.out.println();
		Voce v5 = g.getVoce(r, "bbb", "bbb");
		System.out.println(v5.getId_voce()+"\t"+v5.getNome()+"\t"+v5.getCognome()+"\t"+v5.getTelefono());
		
		System.out.println();
		Voce v6 = g.updateVoce(r, "ccc", "ccc", "eee", "eee", "555");
		System.out.println(v6.getId_voce()+"\t"+v6.getNome()+"\t"+v6.getCognome()+"\t"+v6.getTelefono());
		g.deleteVoce(r, "ddd", "ddd");
		
		System.out.println();
		
		Map<Integer, Voce> voci = g.getAll(r);
		
		for(Map.Entry<Integer, Voce> voce : voci.entrySet()){
			System.out.println(voce.getKey()+"\t"+voce.getValue().getNome()+"\t"
					+voce.getValue().getCognome()+"\t"+voce.getValue().getTelefono());
			
		}

	}

}