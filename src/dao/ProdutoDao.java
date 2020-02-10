package dao;

import java.util.List;

import javax.persistence.EntityManager;

import connection.ConnectionFactory;
import models.Produto;



public class ProdutoDao {
	private static EntityManager em = new ConnectionFactory().getEntityManager();
	
	public List<Produto> getAllProdutos(){		
		List<Produto> produtos = em.createQuery("from Produto").getResultList();
		return produtos;		
	}
	
	
	public boolean save(Produto p){
		try {
			if(p.getId()==null){
				em.getTransaction().begin();
				em.persist(p);
				em.getTransaction().commit();
			}
			else{
				em.getTransaction().begin();
				em.merge(p);
				em.getTransaction().commit();
			}
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.err.println("----xxxx----" + p.toString() + "NÃO FOI SALVO");
			e.printStackTrace();
			return false;
		}
	}
	
	public Produto getById(int id){
		Produto p = em.find(Produto.class, id);
		return p;
		
	}
	
	public boolean removeById(int id){
		try {
			Produto p = getById(id);
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().commit();
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}
	
}
