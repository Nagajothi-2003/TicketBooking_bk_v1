package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Operator;

public interface OperatorService {
Operator CreateOperator(Operator operator);
Operator deleteOperator(int operatorId);
Operator updateOperator(int operatorId,Operator operator);
Operator getOperator(int operatorId);
List<Operator> findAllOper();
List<Operator> getAllOperators();
}
