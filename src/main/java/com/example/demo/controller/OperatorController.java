package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Operator;
import com.example.demo.model.Register;
import com.example.demo.service.OperatorService;

@RestController
@RequestMapping("/Operator")
public class OperatorController {
	@Autowired
	private OperatorService operatorservice;
	
	@PostMapping("/CreateOperator")
	public ResponseEntity<?> CreateOperator(@RequestBody Operator operator){		
		Operator s=operatorservice.CreateOperator(operator);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	
	@DeleteMapping("/delete/{operatorId}")
	public ResponseEntity<?> deleteOperator(@PathVariable int operatorId){
		Operator v=operatorservice.deleteOperator(operatorId);
		return ResponseEntity.status(HttpStatus.OK).body(v);
	}
	
	@PostMapping("/updateOperator/{operatorId}")
	public ResponseEntity<?> updateOperator(@PathVariable int operatorId ,@RequestBody Operator operator){
		Operator d=operatorservice.updateOperator(operatorId,operator);
		return ResponseEntity.status(HttpStatus.OK).body(d);

	}
	
	@GetMapping("/get/{operatorId}")
	public ResponseEntity<?> getOperator(@PathVariable int operatorId ){
		Operator e=operatorservice.getOperator(operatorId);
		return ResponseEntity.status(HttpStatus.OK).body(e);

	}
	@GetMapping("/findAll")
	public List<Operator> findAll(){
		List<Operator> e=operatorservice.findAllOper();
		return e;

	}
//	@GetMapping("/getVal")
//	public List<Register> getVal(){
//		List<Register> savedEntity=	registerRepo.findAll();
//		return savedEntity;	
//	}
}
