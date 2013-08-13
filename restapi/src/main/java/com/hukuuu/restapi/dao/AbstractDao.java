package com.hukuuu.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<T> {

	private final Class<T> entityClass;
	protected abstract EntityManager getEntityManager();

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T create(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public T edit(T entity) {
		return getEntityManager().merge(entity);
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery cq = getEntityManager()
				.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<T> findRange(int[] range) {
		return null;
	}

	public int count() {
		CriteriaQuery cq = getEntityManager()
				.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getMaxResults();
	}
}
