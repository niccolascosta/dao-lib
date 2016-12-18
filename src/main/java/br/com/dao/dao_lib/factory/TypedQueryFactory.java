package br.com.dao.dao_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.dao.dao_lib.jpa.annotation.Query;

@SuppressWarnings("unchecked")
public class TypedQueryFactory {

	@Inject
	private EntityManager em;
	
	@Produces
	@Query
	public <T> TypedQuery<T> factory(InjectionPoint point){
		
		ParameterizedType parameterizedType = (ParameterizedType)point.getType();
		Class<T> classe = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		String jpql = point.getAnnotated().getAnnotation(Query.class).value();
		return em.createQuery(jpql, classe);
	}
}
