package com.br.intelipost.intelipost.dao;

import com.br.intelipost.intelipost.model.Login;

/**
 * @author Samuel Catalano
 */
public interface LoginDAO extends BaseDAO<Login>{
	
	Login doLogin(final String username, final String password);
	Login getByUsername(final String username);
	
}