package fr.dta.AngularEtSpring.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dta.AngularEtSpring.model.IdEntity;

@Repository
@Transactional
public abstract class GenericDAO<T extends IdEntity> {
	
	private Class<T> classType;

	@PersistenceContext
	private EntityManager em;
	
	public GenericDAO(Class<T> classType) {
		this.classType = classType;
	}

	public void insert(T o) {
		em.persist(o);
	}

	public List<T> findAll() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(classType);
		Root<T> root = criteria.from(classType);
		criteria.select(root);


		return em.createQuery(criteria).getResultList();
	}
	
	public Optional<T> findBySQL(String sql, String ...args)
	{
		Query q = em.createQuery(sql);
		int compteur = 0;
		for(String s : args)
		{
			q.setParameter(compteur++, s);
		}
		
		return  (Optional<T>) q.getSingleResult();
	}

	public T findById(long id) {
		return em.find(classType, id);
	}

	public void update(T o) {
		em.merge(o);
	}
	
	public void delete(long id)
	{
		em.remove(findById(id));
	}
}