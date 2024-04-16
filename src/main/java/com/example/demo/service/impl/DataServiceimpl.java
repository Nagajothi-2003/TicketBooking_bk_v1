package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BusRouteDTO;
import com.example.demo.model.BusRoute;
import com.example.demo.model.BusSchedule;
import com.example.demo.model.Operator;
import com.example.demo.repo.BusScheduleRepo;
import com.example.demo.repo.OperatorRepo;
import com.example.demo.repo.RegisterRepo;
import com.example.demo.repo.RouteRepo;
import com.example.demo.service.AggDataService;

@Service
public class DataServiceimpl implements AggDataService {
	
	@Autowired
	private RouteRepo routeRepo;

	@Autowired
	private OperatorRepo operatorRepo;
	
	@Autowired
	private BusScheduleRepo busScheduleRepo;
	
	@Override
	public List<BusRouteDTO> getDataByOriginDestinationAndDate(String origin, String destination, String date) {
        // Fetch bus routes based on origin, destination, and date
        List<BusRoute> busRoutes = routeRepo.findByOriginDestinationAndDate(origin, destination, date);

        List<BusRouteDTO> data = new ArrayList<>();

        // Iterate over each bus route
        for (BusRoute busRoute : busRoutes) {
            // Retrieve the operator for this bus route
        	 Operator operator  = operatorRepo.findByBusRoute(busRoute);

            // Retrieve bus schedules for this bus route
            List<BusSchedule> busSchedules = busScheduleRepo.findByBusRoute(busRoute);

            // Create a DTO to hold bus route, operator, and bus schedules
            BusRouteDTO dto = new BusRouteDTO(busRoute, operator, busSchedules);

            // Add the DTO to the list
            data.add(dto);
        }

        return data;
    }
	 
}
