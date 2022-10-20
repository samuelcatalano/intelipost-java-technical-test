package com.br.intelipost.intelipost.dao.impl;


import com.br.intelipost.intelipost.dao.BaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Samuel Catalano
 */
public class BaseDAOImpl<T extends Serializable> implements BaseDAO<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> domainClass;
	
	private Class<T> getDomainClass() {
		if (this.domainClass == null) {
			final ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
			this.domainClass = (Class<T>) thisType.getActualTypeArguments()[0];
		}
		return this.domainClass;
	}
	
	@Bean
	public SessionFactory sessionFactory(final HibernateEntityManagerFactory hemf){
		return hemf.getSessionFactory();
	}
	
	private String getDomainClassName() {
		return getDomainClass().getName();
	}
	
	@Override
	public T get(final Serializable id) {
		return (T) getSession().get(getDomainClass(), id);
	}
	
	@Override
	public List<T> getAll() {
		return getSession()	.createQuery("from " + getDomainClassName()).list();
	}
	
	@Override
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public T create(final T t) {
		final Serializable id = getSession().save(t);
		return this.get(id);
	}
	
	@Override
	public void update(final T t) {
		getSession().update(t);
	}
	
	@Override
	public void delete(final T t) {
		getSession().delete(t);
	}
	
	@Override
	public void deleteById(final Serializable id) {
		delete(get(id));
	}
	
	@Override
	public void deleteAll() {
		getSession().createQuery("delete " + getDomainClassName()).executeUpdate();
	}
}
