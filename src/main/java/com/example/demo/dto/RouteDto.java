package com.example.demo.dto;

import org.springframework.web.multipart.MultipartFile;

public class RouteDto {
	private String route_name;
	private String origin;
	private String destination;
	private String duration;
	private double fare;
	private MultipartFile file;
	private String date;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
