package com.example.demo.service;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Register;


public interface RegisterService {
	
// Register SetUser(Register register);
 
 ResponseEntity<?> SignInByUserNameservice(Register register);
 ResponseEntity<?> login(Register register);
}
