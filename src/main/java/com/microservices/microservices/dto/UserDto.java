package com.microservices.microservices.dto;

import java.time.LocalDate;
import java.util.List;

import com.microservices.microservices.domain.Telephone;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private List<Telephone> telephones ;
}
