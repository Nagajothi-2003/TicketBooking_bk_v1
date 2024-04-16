package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.BusRoute;
import com.example.demo.model.NewBusRoute;
import com.example.demo.repo.RouteRepo;
import com.example.demo.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private RouteService routeService;
	
//	NewBusRoute
	@PostMapping("/AddBusRoute")
	public ResponseEntity<?>  AddBusRoute(@RequestBody NewBusRoute newBusRoute ){
		NewBusRoute	savedEntity=routeService.AddBusRoute(newBusRoute);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/findAllRoute")
	public List<NewBusRoute> findAllRoute(){
		List<NewBusRoute> e=routeService.findAllRoute();
		return e;
	}
	
	@DeleteMapping("/delete/{routeId}")
	public ResponseEntity<?> deleteBusRoute(@PathVariable int routeId){
		NewBusRoute savedEntity=routeService.deleteBusRoute(routeId);
		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
	}
	
	@GetMapping("/api/routes")
	public List<String> getRoutesByPrefix(@RequestParam String prefix) {
		System.out.println(prefix);
		List<String> e= routeService.getRoutesByPrefix(prefix);
	 return e;
	}
	
	@GetMapping("/api/routes/destination")
	public List<String> getRoutesbyDestination(@RequestParam String Destination){
		System.out.println(Destination);
		List<String> e =routeService.getRoutesbyDestination(Destination);
		return e;
	}
//	NewBusRoute
	
	
//	@PostMapping("/createBusRoute")
//	public ResponseEntity<?> createBusRoute(@RequestBody BusRoute busroute){
//		BusRoute savedEntity=routeService.createBusRoute(busroute);
//		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
//		
//	}
	

//	
//	@PostMapping("/updateRoute/{route_id}")
//	public ResponseEntity<?> updateRoute(@PathVariable int route_id,@RequestBody BusRoute busroute ){
//		BusRoute savedEntity=routeService. updateRoute(route_id, busroute );
//		return ResponseEntity.status(HttpStatus.OK).body(savedEntity);
//
//	}
	

	
	

}
