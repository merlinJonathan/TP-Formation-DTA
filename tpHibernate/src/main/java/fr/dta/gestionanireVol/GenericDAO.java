package fr.dta.gestionanireVol;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class GenericDAO<T> {
	
	private Class<T> klass;
	
	public GenericDAO(Class<T> t)
	{
		this.klass = t;
	}
	
	public void persist(T t)
	{
		EntityManager em = DataHelper.createEntityManager();
		try {
			DataHelper.beginTx(em);
			
			em.persist(t);
			
			DataHelper.commitTxAndClose(em);
		}catch(Exception e)
		{
			DataHelper.rollbackTxAndClose(em);
		}
	}
	
	
	public void merge(T t) {
		EntityManager em = DataHelper.createEntityManager();
		try {
			DataHelper.beginTx(em);

			em.merge(t);
			
			DataHelper.commitTxAndClose(em);
		}catch(Exception e)
		{
			DataHelper.rollbackTxAndClose(em);
		}
	}
	
	public void remove(Long id)
	{
		EntityManager em = DataHelper.createEntityManager();
		try {
			DataHelper.beginTx(em);

			em.remove(em.find(klass, id));
			
			DataHelper.commitTxAndClose(em);
		}catch(Exception e)
		{
			DataHelper.rollbackTxAndClose(em);
		}
	}
	
	
	public T finById(String sql, Long id)
	{
		EntityManager em = DataHelper.createEntityManager();

		TypedQuery<T> query = em.createQuery(sql, klass);
		
		query.setParameter("id", id);
		T t = query.getSingleResult();
		
		return t;
	}
	
	public T vraiFinById(Long id)
	{
		EntityManager em = DataHelper.createEntityManager();

		T object = em.find(klass, id);
		
		em.close();
		return object;
	}
	
	
	
	public List<T> findListByString(String sql, String chaineCaractere)
	{
		EntityManager em = DataHelper.createEntityManager();
			
		TypedQuery<T> query = em.createQuery(sql, klass);
			
		query.setParameter("chaineCaractere", chaineCaractere);
		return query.getResultList();
	}
	
	public T findSingleByString(String sql, String chaineCaractere)
	{
		EntityManager em = DataHelper.createEntityManager();
			
		TypedQuery<T> query = em.createQuery(sql, klass);
		query.setParameter("chaineCaractere", chaineCaractere);
		
		return query.getSingleResult();
	}
}
