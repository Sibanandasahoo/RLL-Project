package com.enzbookclub.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.enzbookclub.MyGenerator;

@SuppressWarnings("serial")
@Entity
public class Books implements Serializable  {

	@Id
	@GeneratedValue(generator=MyGenerator.generatorName)
	@GenericGenerator(name=MyGenerator.generatorName, strategy = "com.enzbookclub.MyGenerator")
	private String bid;
	private String bname;
	private int bprice;
	private String bseller;
	private String bauthor;
	private String bdescp;
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fid")
	private Feedback feedback;

	@ManyToMany // (cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "feedback",  inverseJoinColumns = @JoinColumn(name = "id"))
	private List<User> user = new ArrayList<>();

	public Books(){

	}

	public Books(String bid, String bname, int bprice, String bseller, String bauthor, String bdescp, String image,
			Feedback feedback, List<User> user) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bprice = bprice;
		this.bseller = bseller;
		this.bauthor = bauthor;
		this.bdescp = bdescp;
		this.image = image;
		this.feedback = feedback;
		this.user = user;
	}


	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBseller() {
		return bseller;
	}

	public void setBseller(String bseller) {
		this.bseller = bseller;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBdescp() {
		return bdescp;
	}

	public void setBdescp(String bdescp) {
		this.bdescp = bdescp;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	
}