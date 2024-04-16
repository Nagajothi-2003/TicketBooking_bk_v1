package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BusRouteDTO;
import com.example.demo.service.AggDataService;
import com.example.demo.service.BusScheduleService;
import com.example.demo.service.OperatorService;
import com.example.demo.service.RouteService;

@RestController
@RequestMapping("/api")
public class AggregateDataController {
	@Autowired
	private BusScheduleService busScheduleService;
	
	@Autowired
	private OperatorService operatorservice;
 
	
	@Autowired
	private RouteService routeService;

	@Autowired
	private AggDataService aggDataService;
	
	   @GetMapping("/data")
	    public ResponseEntity<List<BusRouteDTO>> getDataByOriginDestinationAndDate(@RequestParam String origin, @RequestParam String destination, @RequestParam String date) {
	        List<BusRouteDTO> responseData = aggDataService.getDataByOriginDestinationAndDate(origin, destination, date);
	        return ResponseEntity.ok(responseData);
	    }
	
	
	  @GetMapping("/aggregateData")
	    public ResponseEntity<Map<String, Object>> getAllData() {
	        Map<String, Object> responseData = new HashMap<>();
	        responseData.put("operators", operatorservice.getAllOperators());
	        responseData.put("busRoutes", routeService.getAllBusRoutes());
	        responseData.put("busSchedules", busScheduleService.getAllBusSchedules());
	        return ResponseEntity.ok(responseData);
	    }

}
