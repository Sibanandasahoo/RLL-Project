package com.enzbookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzbookclub.model.Books;
import com.enzbookclub.model.Feedback;

import com.enzbookclub.service.FeedbackService;
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService Service;
	
	@PostMapping("/feedback/insert")
	public Feedback addNewFeedback(@RequestBody Feedback feedback)
	{
		return Service.addFeedback(feedback);
	}
	
	@GetMapping("/feedback/list")
	public List<String> listFeedback()
	{
		return Service.getAllFeedback();
	}
	
}
