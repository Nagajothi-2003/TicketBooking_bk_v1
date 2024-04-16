package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BusSchedule")
public class BusSchedule {
	@Id
	@GeneratedValue
	private int schedule_id;
	private String depature_time;
	private String arrival_time;
	private int bus_number;
	private String bus_name;
	private int seats_available;
	private String bus_type;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "operatorId")
	private Operator operator;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	private BusRoute busRoute;
	
	public int getSchedule_id() {
		return schedule_id;
	}


	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}


	public String getDepature_time() {
		return depature_time;
	}


	public void setDepature_time(String depature_time) {
		this.depature_time = depature_time;
	}


	public String getArrival_time() {
		return arrival_time;
	}


	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}


	public int getBus_number() {
		return bus_number;
	}


	public void setBus_number(int bus_number) {
		this.bus_number = bus_number;
	}


	public String getBus_name() {
		return bus_name;
	}


	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}


	public int getSeats_available() {
		return seats_available;
	}


	public void setSeats_available(int seats_available) {
		this.seats_available = seats_available;
	}


	public String getBus_type() {
		return bus_type;
	}


	public void setBus_type(String bus_type) {
		this.bus_type = bus_type;
	}


	public Operator getOperator() {
		return operator;
	}


	public void setOperator(Operator operator) {
		this.operator = operator;
	}


	public BusRoute getBusRoute() {
		return busRoute;
	}


	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}


	


	



}
