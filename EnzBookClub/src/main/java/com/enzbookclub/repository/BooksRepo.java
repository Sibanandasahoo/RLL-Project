package com.enzbookclub.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.enzbookclub.model.Books;

public interface BooksRepo extends JpaRepository<Books, Integer>{
	
	
}
