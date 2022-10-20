package com.br.intelipost.intelipost.controller;

import com.br.intelipost.intelipost.dao.LoginDAO;
import com.br.intelipost.intelipost.model.Login;
import com.br.intelipost.intelipost.utils.IntelipostApplicationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Samuel Catalano
 */

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/intelipost")
@Transactional
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class IntelipostApplicationController{
	
	private final LoginDAO loginDAO;
	
	/**
	 * Login.
	 * @param login the representation of login
	 * @return Response with HTTP status code
	 */
	@POST
	@RequestMapping("/login")
	@Consumes("service/json")
	public ResponseEntity doLogin(@RequestBody final Login login){
		try{
			final Login response = this.loginDAO.doLogin(login.getUsername(), login.getPassword());
			if(response == null){
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error doing login");
			}
			else{
				return ResponseEntity.ok(response);
			}
		}
		catch(final Exception e){
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error doing login");
		}
	}
	
	/**
	 * Create new login.
	 * @param login the representation of login
	 * @return Response with HTTP status code
	 */
	@POST
	@RequestMapping("/create")
	@Consumes("service/json")
	public ResponseEntity create(@RequestBody final Login login){
		try{
			final Login response = this.loginDAO.create(login);
			return ResponseEntity.ok(response);
		}
		catch(final Exception e){
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating login");
		}
	}
	
	/**
	 * Update login.
	 * @param login the representation of login
	 * @return Response with HTTP status code
	 */
	@POST
	@RequestMapping("/update")
	@Consumes("service/json")
	public ResponseEntity update(@RequestBody final Login login){
		try{
			if(login.getUsername() != null) {
				final Login l = this.loginDAO.getByUsername(login.getUsername());
				l.setPassword(IntelipostApplicationUtils.getMD5Password(login.getPassword()));
				l.setName(login.getName());
				l.setTip(login.getTip());
				
				this.loginDAO.update(l);
				return ResponseEntity.ok().build();
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating login");
			}
		}
		catch(final Exception e){
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating login");
		}
	}
}