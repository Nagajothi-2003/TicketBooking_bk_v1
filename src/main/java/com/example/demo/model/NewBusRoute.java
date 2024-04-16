package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="newBusRoute")
public class NewBusRoute {
	
	@Id
	@GeneratedValue
	private int routeId;
	private String routeName;
	private String origin;
	private String destination;
	private String date;
	

	@OneToMany(mappedBy ="newBusRoute",cascade = CascadeType.ALL )
	private List<OperatorBusSchedule> operatorBusSchedule;
	
	public int getRouteId() {
		return routeId;
	}

	public List<OperatorBusSchedule> getOperatorBusSchedule() {
		return operatorBusSchedule;
	}

	public void setOperatorBusSchedule(List<OperatorBusSchedule> operatorBusSchedule) {
		this.operatorBusSchedule = operatorBusSchedule;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}




	
	
	

	
}
