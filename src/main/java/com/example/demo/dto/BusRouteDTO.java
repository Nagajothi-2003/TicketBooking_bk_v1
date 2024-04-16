package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.BusRoute;
import com.example.demo.model.BusSchedule;
import com.example.demo.model.Operator;

public class BusRouteDTO {
	  private BusRoute busRoute;
	  private Operator operator;
	  private List<BusSchedule> busSchedules;
	  
	public BusRouteDTO(BusRoute busRoute, Operator operator, List<BusSchedule> busSchedules) {
		super();
		this.busRoute = busRoute;
		this.operator = operator;
		this.busSchedules = busSchedules;
	}
	
	public BusRoute getBusRoute() {
		return busRoute;
	}
	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public List<BusSchedule> getBusSchedules() {
		return busSchedules;
	}
	public void setBusSchedules(List<BusSchedule> busSchedules) {
		this.busSchedules = busSchedules;
	}
	  
}
