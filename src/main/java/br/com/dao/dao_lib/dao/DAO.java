package br.com.dao.dao_lib.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T, I> implements Serializable {

	private static final long serialVersionUID = -1603139969274284275L;
	private final Class<T> classe;
	private final EntityManager em;

	public DAO(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	public void adiciona(T t) {
		this.em.persist(t);
	}

	public void atualiza(T t) {
		this.em.merge(t);
	}

	public T buscaPorId(I id) {
		T instancia = this.em.find(this.classe, id);
		return instancia;
	}

	public Long contaTodos() {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		query.select(builder.count(query.from(this.classe)));
		return this.em.createQuery(query).getSingleResult();
	}

	public List<T> listaTodos() {
		CriteriaQuery<T> query = this.em.getCriteriaBuilder().createQuery(this.classe);
		query.select(query.from(this.classe));
		List<T> lista = this.em.createQuery(query).getResultList();
		return lista;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		CriteriaQuery<T> query = this.em.getCriteriaBuilder().createQuery(this.classe);
		query.select(query.from(this.classe));
		List<T> lista = this.em.createQuery(query).setFirstResult(firstResult).setMaxResults(maxResults)
				.getResultList();
		return lista;
	}

	public void remove(T t) {
		this.em.remove(this.em.merge(t));
	}

}
