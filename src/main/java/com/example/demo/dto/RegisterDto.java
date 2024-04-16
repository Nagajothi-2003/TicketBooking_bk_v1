package com.example.demo.dto;

import com.example.demo.model.Register;

public class RegisterDto {
	private String status;
	private Register register;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Register getRegister() {
		return register;
	}
	public void setRegister(Register register) {
		this.register = register;
	}
	

}
