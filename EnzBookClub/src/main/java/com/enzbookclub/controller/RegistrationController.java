package com.enzbookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enzbookclub.exception.ResourceNotFoundException;
import com.enzbookclub.model.User;
import com.enzbookclub.repository.BooksRepo;
import com.enzbookclub.repository.RegistrationRepo;
import com.enzbookclub.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;
	@Autowired
	private RegistrationRepo repo;

	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		if (tempEmail != null && !"".equals(tempEmail)) {
			User userObj = service.fetchUserByEmailId(tempEmail);
			if (userObj != null) {
				throw new Exception("user with " + tempEmail + " is already exist");
			}
		}
		User userObj = null;
		userObj = service.saveUser(user);
		return userObj;
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmail != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPass(tempEmail, tempPass);
		}
		if (userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;
	}

	

	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User user = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(user);
	}

}
