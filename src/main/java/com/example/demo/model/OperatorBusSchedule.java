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
@Table(name="OperatorBusSchedule")
public class OperatorBusSchedule {
	@Id
	@GeneratedValue
	private int id;
	private String operName;
	private String depTime;
	private String arrTime;
    private String phone;
    private String rating;
	private String seats;
	private String busType;
	private double fare;
	private String image;
	private String duration;
	private String date;
		
	@JsonIgnore
	@ManyToOne
//	(cascade = CascadeType.ALL)
	@JoinColumn(name="routeId")
	private NewBusRoute newBusRoute;
	
	public OperatorBusSchedule() {
		
	}
	
	public OperatorBusSchedule(int id, String operName, String depTime, String arrTime, String phone, String rating,
			String busName, String seats, String busType, double fare, String image, String duration) {
		super();
		this.id = id;
		this.operName = operName;
		this.depTime = depTime;
		this.arrTime = arrTime;
		this.phone = phone;
		this.rating = rating;
		this.seats = seats;
		this.busType = busType;
		this.fare = fare;
		this.image = image;
		this.duration = duration;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public NewBusRoute getNewBusRoute() {
		return newBusRoute;
	}
	public void setNewBusRoute(NewBusRoute newBusRoute) {
		this.newBusRoute = newBusRoute;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getDepTime() {
		return depTime;
	}
	public void setDepTime(String depTime) {
		this.depTime = depTime;
	}
	public String getArrTime() {
		return arrTime;
	}
	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
	
	
	
	

}
