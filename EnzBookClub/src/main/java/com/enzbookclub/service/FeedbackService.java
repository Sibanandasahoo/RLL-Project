package com.enzbookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzbookclub.model.Feedback;
import com.enzbookclub.repository.FeedbackRepo;


@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepo repo;
	
	public Feedback addFeedback(Feedback feedback)
	{
		return repo.save(feedback);		
	}
	
	public List<String> getAllFeedback()
	{
		return repo.findFeedback();
	}
	public List<String> findFeedbackById(int fid)
	{
		return repo.findFid(fid);
	}
}
