package com.example.demo.model;

//import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "busRoute")
public class BusRoute {
	@Id
	@GeneratedValue
	private int route_id;
	private String route_name;
	private String origin;
	private String destination;
	private String duration;
	private double fare;
	private String image;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@OneToMany(mappedBy = "busRoute", cascade = CascadeType.ALL)
	private List<BusSchedule> busSchedules;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int route_id) {
		this.route_id = route_id;
	}

	public String getRoute_name() {
		return route_name;
	}

	public void setRoute_name(String route_name) {
		this.route_name = route_name;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

//	public List<BusSchedule> getBusSchedules() {
//		return busSchedules;
//	}
//
//	public void setBusSchedules(List<BusSchedule> busSchedules) {
//		this.busSchedules = busSchedules;
//	}

}
