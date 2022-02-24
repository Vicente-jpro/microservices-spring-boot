package com.microservices.microservices.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservices.microservices.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.name like  %?1%")
	List<User> findUserByNameAndSort(String name, Sort sort);
	
	User findUserByName(String name);
}
