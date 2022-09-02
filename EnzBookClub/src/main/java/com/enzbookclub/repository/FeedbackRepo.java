package com.enzbookclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enzbookclub.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
	@Query(value = ("select * from feedback"), nativeQuery = true)
	public List<String> findFeedback();

	@Query(value = ("select feedback.fid,feedback.review,feedback.rating,books.bid,books.bname,books.bprice,books.bseller,books.bauthor,books.bdescp,books.image from feedback inner join books on feedback.fid=books.fid where feedback.fid= ?"), nativeQuery = true)
	public List<String> findFid(int fid);

}
