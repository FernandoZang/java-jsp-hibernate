package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.query.Query;

import models.Bovino;
import connection.ConnectionFactory;


public class BovinoDao {
	EntityManager em;
	
	
	public BovinoDao() {
		
	}
	
	
	public boolean save(Bovino b){
		em = ConnectionFactory.getEntityManager();// one-EntityManager per request pattern
		try {
			if(b.getId()==null){
				em.getTransaction().begin();
				em.persist(b);
				em.getTransaction().commit();
			}
			else{
				em.getTransaction().begin();
				em.merge(b);
				em.getTransaction().commit();
			}
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally{
			em.close();// one-EntityManager per request pattern
		}
	}
	
	
	public Bovino getById(Integer id){
		em = ConnectionFactory.getEntityManager();
		Bovino b = null;
		try{
			b = em.find(Bovino.class, id);
		}catch(Exception e){
			System.out.println("Não foi possivel encontrar o bovino com o id especificado");
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		
		return b;
	}
	
	
	public List<Bovino> getAll(){
		em = ConnectionFactory.getEntityManager();
		List<Bovino> bovinos = null;
		try{
			bovinos = (List<Bovino>) em.createQuery("from Bovino").getResultList();
		}
		catch(Exception e){
			System.out.println("Erro ao buscar a entidade bovino no Banco de dados");
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		
		return bovinos;
	}
	
	
	public List<Bovino> getBovinoByNameStartWith(String nameStart){
		em = ConnectionFactory.getEntityManager();
		List<Bovino> bovinos = null;
		try {
			String q = 
					"SELECT b FROM Bovino b " + 
					"WHERE b.nome like :pattern";
			TypedQuery<Bovino> query = em.createQuery(q, Bovino.class);
			query.setParameter("pattern", nameStart + "%" );
			bovinos = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			em.close();
		}
		return bovinos;
	}
	
	
	
	
	
	

	
	
}//endof: BovinoDao
