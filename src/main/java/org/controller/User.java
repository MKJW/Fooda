package org.controller;

import java.util.Date;

public class User {
	private String userid;
	private String username;
	private String password;
	private String country;
	private String email;
	private Date createdDate;
	private Date modifiedDate;

	public User() {
	}

	public User(String userid, String username, String password, String country) {
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.country = country;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", country=" + country
				+ ", email=" + email + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
