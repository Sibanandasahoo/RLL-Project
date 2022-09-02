package com.enzbookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzbookclub.model.User;
import com.enzbookclub.repository.RegistrationRepo;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepo repo;

	public User saveUser(User user) {
		return repo.save(user);

	}

	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);

	}

	public User fetchUserByEmailIdAndPass(String email, String password) {

		return repo.findByEmailIdAndPassword(email, password);
	}

	public List<User> getAllUser() {
		return repo.findAll();
	}
}
