package com.enzbookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.enzbookclub.exception.ResourceNotFoundException;
import com.enzbookclub.model.Books;
import com.enzbookclub.repository.BooksRepo;
import com.enzbookclub.service.BooksService;

@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BooksController {
	@Autowired
	private BooksService service;

	@Autowired
	private BooksRepo repo;

	@PostMapping("/addBooks")

	public Books saveBooks(@RequestBody Books book) {
		Books bookObj = null;
		bookObj = service.saveBooks(book);
		return bookObj;
	}

	@GetMapping("/vbooks")

	public List<Books> findAllBooks() {
		return repo.findAll();
	}

	@PutMapping("/update/{id}")

	public ResponseEntity<Books> updateBook(@PathVariable int bid, @RequestBody Books bookDetails) {
		Books book = repo.findById(bid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + bid));

		book.setBname(bookDetails.getBname());
		book.setBprice(bookDetails.getBprice());
		book.setBseller(bookDetails.getBseller());
		book.setBauthor(bookDetails.getBauthor());
		book.setBdescp(bookDetails.getBdescp());
		book.setImage(bookDetails.getImage());
		Books updatebook = repo.save(book);
		return ResponseEntity.ok(updatebook);
	}

	@DeleteMapping("/cancel/{id}")

	public List<Books> deleteBook(@PathVariable int id) {
		repo.deleteById(id);
		return repo.findAll();
	}
}
