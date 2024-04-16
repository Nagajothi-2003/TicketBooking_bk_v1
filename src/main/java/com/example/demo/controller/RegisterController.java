package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Register;

import com.example.demo.repo.RegisterRepo;
import com.example.demo.service.RegisterService;

@RestController

@RequestMapping("/Register")

public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterRepo registerRepo;

	@PostMapping("/Registervalue")
	public ResponseEntity<?> SignInByUserNameservice(@RequestBody Register register) {
		ResponseEntity<?> User = registerService.SignInByUserNameservice(register);
		return ResponseEntity.status(HttpStatus.OK).body(User);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Register register) {
		ResponseEntity<?> user = registerService.login(register);
	    return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	@GetMapping("/getVal")
	public List<Register> getVal(){
		List<Register> savedEntity=	registerRepo.findAll();
		return savedEntity;	
	}

}
