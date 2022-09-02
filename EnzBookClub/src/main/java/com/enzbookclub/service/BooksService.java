package com.enzbookclub.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzbookclub.model.Books;
import com.enzbookclub.repository.BooksRepo;

@Service
public class BooksService {

	@Autowired
	private BooksRepo repo;

	public Books saveBooks(Books book) {
		return repo.save(book);
	}

	public List<Books> getAllUser() {
		return repo.findAll();
	}


	

}
