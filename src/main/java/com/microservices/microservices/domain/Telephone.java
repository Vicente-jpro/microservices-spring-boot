package com.microservices.microservices.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "telephones")
public class Telephone {


	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(unique = true)
	private String number;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn( name = "user_id", nullable = false)
	private User user;
	
}
