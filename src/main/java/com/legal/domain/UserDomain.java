package com.legal.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class UserDomain {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@Column(length = 50)
	String first_name, last_name, email;
	@Column(length = 10)
	long mobile;
	@Column
	boolean validate;
	@Column(length = 20)
	String login_type;
	@Column(length = 10)
	String role;
	@Column
	Timestamp created_ts;
	@Column
	Timestamp modified_ts;
	@Column(length = 250)
	String username;

	@Column(length = 250)
	String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public String getLogin_type() {
		return login_type;
	}

	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreated_ts() {
		return created_ts;
	}

	public void setCreated_ts(Timestamp created_ts) {
		this.created_ts = created_ts;
	}

	public Timestamp getModified_ts() {
		return modified_ts;
	}

	public void setModified_ts(Timestamp modified_ts) {
		this.modified_ts = modified_ts;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
