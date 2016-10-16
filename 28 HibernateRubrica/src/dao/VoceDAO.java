package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateUtil.HibernateUtil;
import model.*;

public class VoceDAO {
	
	private RubricaDAO rDAO = new RubricaDAO();
	
	public Voce cercaVoceDAO(int id_r, String nome, String cognome) {
		
		Session session = HibernateUtil.openSession();
		
		String hql = "SELECT * " +
				 	 "FROM Voce " +
				 	 "WHERE cognome = :cognome AND nome = :nome AND id";
		
		Transaction tx = null;
		Voce result = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("cognome", cognome);
			query.setParameter("nome", nome);
			result = (Voce) query.uniqueResult();
			tx.commit();
			
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		if (result != null)
			return result;
		
		return null;
	}
	
	public Voce aggiungiVoceDAO (String nomeR, String nome, String cognome, String telefono) {
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeR);
		
		Voce v = null;
		if (!cercaUtente(nomeR, nome, cognome) && r != null){
			String sql = "INSERT INTO VOCE(nome, cognome, telefono, id_rubrica_fk) " +
						 "VALUES (?, ?, ?, ?)";
		}

	return v;
	}

	
	private boolean cercaUtente (String nomeR, String nome, String cognome) {
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeR);
		
		if (r != null){
		
			String sql = "SELECT * " +
				 	 	 "FROM Voce " +
				 	     "WHERE NOME = ? AND COGNOME = ? AND ID_RUBRICA_FK = ?";
			
		}
		return false;
	}

	public Voce eliminaVoceDAO(String nomeRubrica, String nome, String cognome) {
		
		Rubrica r = rDAO.cercaRubricaDAO(nomeRubrica);
		
		Voce v = null;
		if (r != null){
			{
				v = cercaVoceDAO(nomeRubrica, nome, cognome);
				
				
				
				String sql = "DELETE " +
				 	 	 	 "FROM Voce " +
				 	 	 	 "WHERE NOME = ? AND COGNOME = ? AND ID_RUBRICA_FK = ?";
			
				
				
			}
		}
		
		return null;
	}
}
