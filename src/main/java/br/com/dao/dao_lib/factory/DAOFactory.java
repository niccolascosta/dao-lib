package br.com.dao.dao_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.dao.dao_lib.dao.DAO;

@SuppressWarnings("unchecked")
public class DAOFactory {

	@Inject
	private EntityManager manager;

	@Produces
	public <T, I> DAO<T, I> factory(InjectionPoint point) {
		ParameterizedType type = (ParameterizedType) point.getType();

		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		return new DAO<>(classe, this.manager);
	}

}
