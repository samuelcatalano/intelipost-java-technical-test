package com.br.intelipost.intelipost.dao.impl;

import com.br.intelipost.intelipost.dao.LoginDAO;
import com.br.intelipost.intelipost.model.Login;
import com.br.intelipost.intelipost.utils.IntelipostApplicationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author Samuel Catalano
 */

@Slf4j
@RequiredArgsConstructor
@Repository
@Transactional
public class LoginDAOImpl extends BaseDAOImpl<Login> implements LoginDAO {
	
	
	@Override
	public Login create(final Login login){
		Login response = null;
		try{
			if(login.getId() == null){
				login.setCreated(new Date());
			}
			login.setModified(new Date());
			
			final String md5 = IntelipostApplicationUtils.getMD5Password(login.getPassword());
			login.setPassword(md5);
			response = super.create(login);
		}
		catch(final NoSuchAlgorithmException e){
			log.error(e.getMessage());
		}
		return response;
	}
	
	@Override
	public Login doLogin(final String username, final String password){
		return (Login) addCriteria(username, password).uniqueResult();
	}
	
	@Override
	public Login getByUsername(final String username){
		return (Login) addCriteria(username, null).uniqueResult();
	}
	
	/**
	 * Adding criteria to get login
	 * @param username the username
	 * @param password the password
	 * @return Criteria
	 */
	private Criteria addCriteria(final String username, final String password){
		final Criteria criteria = getSession().createCriteria(Login.class);
		try{
			if(username != null) {
				criteria.add(Restrictions.like("username", username));
			}
			if(password != null) {
				final String md5 = IntelipostApplicationUtils.getMD5Password(password);
				criteria.add(Restrictions.like("password", md5));
			}
			
			return criteria;
		}
		catch(final NoSuchAlgorithmException e){
			log.error(e.getMessage());
		}
		return criteria;
	}
}