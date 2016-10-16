package dao;

import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hibernateUtil.HibernateUtil;


public class RubricaDAO {
	
	
	public Rubrica cercaRubricaDAO(String email) {
		
		Session session = HibernateUtil.openSession();
		
		String hql = "SELECT * " +
				 	 "FROM Rubrica " +
				 	 "WHERE MAIL = :email";
		
		Transaction tx = null;
		Rubrica result = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			result = (Rubrica) query.uniqueResult();
			tx.commit();
			
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	

	public Rubrica aggiungiRubricaDAO(String nome, String email) {
			
			if (!cercaRubrica(email)){
				Session session = HibernateUtil.openSession();
				
				String hql = "INSERT INTO RUBRICA(nome, mail) " +
							 "VALUES (:nome, :mail)";
				Transaction tx = null;
				int result = 0;
				try {
					
					tx = session.getTransaction();
					tx.begin();
					
					Query query = session.createQuery(hql);
					query.setParameter("nome", nome);
					query.setParameter("mail", email);
					result = query.executeUpdate();
					
					tx.commit();
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					session.close();
				}
				
				if (result == 1){
					return cercaRubricaDAO(email);
				}
			}
		return null;
	}
	
	
	private boolean cercaRubrica(String email){
		
		Session session = HibernateUtil.openSession();
		
		String hql = "SELECT * " +
			 	 "FROM Rubrica " +
			 	 "WHERE MAIL = :email";
	
		Transaction tx = null;
		Rubrica result = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			
			Query query = session.createQuery(hql);
			query.setParameter("email", email);
			result = (Rubrica) query.uniqueResult();
			tx.commit();
			
		}catch (Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		if (result != null){
			return true;
		}
		return false;
	}
}
