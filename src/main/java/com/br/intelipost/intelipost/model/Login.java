package com.br.intelipost.intelipost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Samuel Catalano
 */

@Entity
@Table(name = "login")
public class Login implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	@Getter
	@Setter
	private String name;
	
	@Column(name = "username", nullable = false, length = 100)
	@Getter
	@Setter
	private String username;
	
	@Column(name = "password", nullable = false, length = 50)
	@Getter
	@Setter
	private String password;
	
	@Column(name = "tip", nullable = false, length = 100)
	@Getter
	@Setter
	private String tip;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id")
	@Getter
	@Setter
	private Role role;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Getter
	@Setter
	private Date created;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified", nullable = false)
	@Getter
	@Setter
	private Date modified;
}