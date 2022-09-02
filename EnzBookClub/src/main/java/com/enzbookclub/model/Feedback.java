package com.enzbookclub.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Feedback  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int fid;
	private String review;
	private String rating;
	private int bid;
	private int id;

	@OneToMany(mappedBy = "feedback")
	private List<Books> books = new ArrayList<>();

	public Feedback() {

	}

	public Feedback(int fid, String review, String rating, int bid, int id, List<Books> books) {
		super();
		this.fid = fid;
		this.review = review;
		this.rating = rating;
		this.bid = bid;
		this.id = id;
		this.books = books;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", review=" + review + ", rating=" + rating + ", bid=" + bid + ", id=" + id
				+ ", books=" + books + "]";
	}

}
