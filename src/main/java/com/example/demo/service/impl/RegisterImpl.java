package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterDto;
import com.example.demo.model.Register;

import com.example.demo.repo.RegisterRepo;
import com.example.demo.service.RegisterService;

@Service
public class RegisterImpl implements RegisterService {
	@Autowired
	private RegisterRepo registerRepo;


	@Override
	public ResponseEntity<?> SignInByUserNameservice(Register register) {
		Register em = registerRepo.findByUsername(register.getUsername());
		Register user = registerRepo.findByEmail(register.getEmail());

		if (em != null) {
			return ResponseEntity.status(HttpStatus.OK).body(em);
		}else if(user!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		
		registerRepo.save(register);
		return ResponseEntity.status(HttpStatus.CREATED).body(em);

	}

	@Override
	public ResponseEntity<?> login(Register register) {
		Register user = registerRepo.findByEmail(register.getEmail());
		Register em = registerRepo.findByUsername(register.getUsername());

		if (user == null || !user.getPassword().equals(register.getPassword())){
			// User not found or password doesn't match
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(user);
		}
		// User found and password matches, proceed with login
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

}
