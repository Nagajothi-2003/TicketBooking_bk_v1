package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BusSchedule;
import com.example.demo.model.OperatorBusSchedule;
import com.example.demo.repo.BusScheduleRepo;
import com.example.demo.service.BusScheduleService;

@RestController
@RequestMapping("/BusSchedule")
public class BusScheduleController {
	@Autowired
	private BusScheduleService busScheduleService;

	@Autowired
	private BusScheduleRepo busScheduleRepo;

	// New BusSchedule

	@PostMapping("/addSchedule/{routeId}")
	public ResponseEntity<?> addSchedule(@PathVariable int routeId,
			@RequestBody OperatorBusSchedule operatorBusSchedule) {
		OperatorBusSchedule s = busScheduleService.addSchedule(routeId, operatorBusSchedule);
		return ResponseEntity.status(HttpStatus.OK).body(s);

	}

	@GetMapping("/busSchedule")
	public List<OperatorBusSchedule> getBusSchedule(@RequestParam String origin, @RequestParam String destination,
			@RequestParam String date) {
		return busScheduleService.getBusSchedule(origin, destination, date);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBusSchedule(@PathVariable int id) {
		OperatorBusSchedule s = busScheduleService.deleteBusSchedule(id);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	// New BusSchedule

	@PostMapping("/createschedule/{operatorId}/{route_id}")
	public ResponseEntity<?> createschedule(@PathVariable int operatorId, @PathVariable int route_id,
			@RequestBody BusSchedule busSchedule) {
		BusSchedule s = busScheduleService.createschedule(operatorId, route_id, busSchedule);
		return ResponseEntity.status(HttpStatus.OK).body(s);

	}

	@GetMapping("/getAll")
	public List<BusSchedule> getAllSchedule() {
		List<BusSchedule> s = busScheduleService.getAllSchedule();
		return s;
	}

	@GetMapping("/get/{schedule_id}")
	public ResponseEntity<?> getBusSchedule(@PathVariable int schedule_id) {
		BusSchedule s = busScheduleService.getBusSchedule(schedule_id);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	@GetMapping("/list/{page}/{size}")
	public ResponseEntity<?> getPostsPage(@PathVariable int page, @PathVariable int size) {
		PageRequest.of(2, 3);

//		List<Post> posts = busScheduleRepo.findAll(PageRequest.of(page, size)).toList();
//		List<BusSchedule> posts = busScheduleRepo.findAll(
//				PageRequest.of(
//						page, size, 
//					Sort.by("schedule_id").descending()
//					)).toList();
		List<BusSchedule> posts = busScheduleRepo.findAll(PageRequest.of(page, size, Sort.by("bus_name"))).toList();
		return ResponseEntity.status(HttpStatus.OK).body(posts);
	}

//	extra
	@GetMapping("/bus-schedules")
	public List<BusSchedule> getBusSchedules(@RequestParam String origin, @RequestParam String destination,
			@RequestParam String date) {
		return busScheduleService.getBusSchedules(origin, destination, date);
	}

}

//@GetMapping("list/{page}/{size}")
//public ResponseEntity<?> getSchedule(@PathVariable int page,@PathVariable int size){
////	PageRequest.of(1,2);
//	ResponseEntity s=busScheduleService.getSchedule(page,size);
//	return ResponseEntity.status(HttpStatus.OK).body(s);
//
//}
//

//@GetMapping("/getAll")
//public ResponseEntity<?> getAllSchedule() {
//	ResponseEntity s = busScheduleService.getAllSchedule();
//	return ResponseEntity.status(HttpStatus.OK).body(s);
//}

//@GetMapping("/BusSchedule/getSchedulesByOperatorAndRoute/{operatorId}/{routeId}")
//public BusSchedule getSchedulesByOperatorAndRoute(@PathVariable int  operatorId,@PathVariable int route_id ){
//	return busScheduleService.getSchedulesByOperatorAndRoute(operatorId,route_id);
//}

//@GetMapping("/get/{operatorId}")
//public ResponseEntity<?> get(@PathVariable int operatorId){
//	BusSchedule s= busScheduleRepo.findById(operatorId).get();
//	return ResponseEntity.status(HttpStatus.OK).body(s);
//
//}
