package com.microservices.microservices.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.microservices.microservices.domain.User;
import com.microservices.microservices.dto.UserDto;
import com.microservices.microservices.execeptions.UserNotFoundExeception;
import com.microservices.microservices.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	} 
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public UserDto getUser(Long id) {
		
		UserDto dto = new UserDto();
		
		User user = userRepository.findById(id).orElseThrow( () -> new UserNotFoundExeception( "User not found"));
		BeanUtils.copyProperties(user, dto);
		return dto;
		
	}
	
	public List<User> findUserByName(String name){
		return userRepository.findUserByNameAndSort(name, Sort.by("name")) ;
	}
	
	public List<User> readAll(){
		return userRepository.findAll() ;
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
}
