package com.enzbookclub.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;
	private String emailId;
	private String userName;
	private String password;

	@ManyToMany(mappedBy = "user")
	@JsonIgnore
	private List<Books> book1 = new ArrayList<>();

	public User() {

	}

	public User(int id, String emailId, String userName, String password, List<Books> book1) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.book1 = book1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Books> getBook1() {
		return book1;
	}

	public void setBook1(List<Books> book1) {
		this.book1 = book1;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", userName=" + userName + ", password=" + password
				+ ", book1=" + book1 + "]";
	}

}
