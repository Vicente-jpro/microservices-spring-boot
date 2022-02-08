package com.microservices.microservices.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "telephones")
public class Telephone {


	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(unique = true)
	private String number;
	
	@ManyToOne
	@ForeignKey( name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
