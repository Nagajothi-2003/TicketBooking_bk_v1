package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BusRoute;
import com.example.demo.model.NewBusRoute;


public interface RouteService {

	 BusRoute createBusRoute(BusRoute busroute);
	 
	 BusRoute updateRoute(int route_id,BusRoute busroute);
	
	
	 List<BusRoute> getAllBusRoutes();
	 
//	NewBusRoute
	 NewBusRoute AddBusRoute(NewBusRoute newBusRoute);
	 List<NewBusRoute> findAllRoute();
	 NewBusRoute deleteBusRoute(int routeId);
	 List<String> getRoutesbyDestination(String Destination);
	 List<String> getRoutesByPrefix(String prefix);

}
