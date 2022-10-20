package com.br.intelipost.intelipost.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @author Samuel Catalano
 */

public interface BaseDAO<T extends Serializable>{
	
	T get(Serializable id);
	List<T> getAll();
	Session getSession();
	void update(T t);
	void delete(T t);
	void deleteById(Serializable id);
	void deleteAll();
	T create(T t);
}