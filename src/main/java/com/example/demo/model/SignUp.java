package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SignUP")
public class SignUp {
	@Id
	@GeneratedValue
	private int sign_up;
	private String username;
	private String email;
	private String password;
	public int getSign_id() {
		return sign_up;
	}
	public void setSign_id(int sign_up) {
		this.sign_up = sign_up;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}

