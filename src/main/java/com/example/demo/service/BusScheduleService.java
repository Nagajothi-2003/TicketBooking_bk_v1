package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.BusSchedule;
import com.example.demo.model.OperatorBusSchedule;

public interface BusScheduleService {
	BusSchedule createschedule(int operatorId,int route_id,BusSchedule busSchedule);
	List<BusSchedule> getAllSchedule();
	BusSchedule getBusSchedule(int schedule_id);
	
//	BusSchedule getSchedulesByOperatorAndRoute(int operatorId,int route_id );
//	ResponseEntity<?> getSchedule(int page,int size);
	//extra
	List<BusSchedule> getBusSchedules( String origin, String destination, String date);
    List<BusSchedule> getAllBusSchedules();
    
  //New BusSchedule
    OperatorBusSchedule addSchedule(int routeId, OperatorBusSchedule operatorBusSchedule);
	List<OperatorBusSchedule> getBusSchedule( String origin, String destination, String date);
	OperatorBusSchedule deleteBusSchedule(int id);

}
