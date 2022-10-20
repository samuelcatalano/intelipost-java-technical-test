package com.br.intelipost.intelipost.model;

import com.br.intelipost.intelipost.model.enums.LoginRole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Getter
	@Setter
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	@Getter
	@Setter
	private LoginRole type;

}