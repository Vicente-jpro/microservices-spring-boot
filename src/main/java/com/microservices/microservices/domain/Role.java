package com.microservices.microservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "role")
@SequenceGenerator( name =  "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1)
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_role")
	private Long id;
	@Column(name = "name_role")
	private String nameRole;
	
	@Override
	public String getAuthority() {
		return this.nameRole;
	}
}
