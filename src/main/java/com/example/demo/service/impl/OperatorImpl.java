package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Operator;
import com.example.demo.repo.OperatorRepo;
import com.example.demo.service.OperatorService;

@Service
public class OperatorImpl implements OperatorService {
@Autowired
private OperatorRepo operatorRepo;
 @Override
 public Operator CreateOperator(Operator operator) {
	 Operator s=operatorRepo.saveAndFlush(operator);
	 return s;
 }
 
 @Override
 public Operator deleteOperator(int operatorId) {
	 Operator v=operatorRepo.findById(operatorId).get();
	 if(v!=null) {
		 operatorRepo.delete(v);
	 }
	 return v;
 }
 
 @Override
 public Operator updateOperator(int operatorId,Operator operator ) {
	 Operator s= operatorRepo.findById(operatorId).get();
	 s.setOperatorName(operator.getOperatorName());
	 s.setContactPhone(operator.getContactPhone());
	 return operatorRepo.save(s);
 }
 @Override
 public Operator getOperator(int operatorId) {
	 Operator s=operatorRepo.findById(operatorId).get();
	 return s;
 }
 @Override
 public List<Operator> findAllOper(){
	 List<Operator> s= operatorRepo.findAll();
	 return s;
 }
 
 @Override
 public List<Operator> getAllOperators() {
     return operatorRepo.findAll();
 }
}
