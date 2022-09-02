package com.enzbookclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.enzbookclub.model.User;

@Repository
public interface RegistrationRepo extends JpaRepository <User, Integer>{
	

	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String email, String password);

}
