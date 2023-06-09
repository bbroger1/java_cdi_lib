package br.com.rcssoft.rcssoft_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.rcssoft.rcssoft_lib.dao.DAO;

public class DAOFactory {
	
	@Inject
	private EntityManager manager;

	@Produces
	public <T> DAO<T> factory(InjectionPoint point) {
		
		ParameterizedType type = (ParameterizedType) point.getType();
		
		@SuppressWarnings("unchecked")
		Class<T> classe = (Class<T>) type.getActualTypeArguments()[0];
		return new DAO<T>(classe, manager);
	}
}
