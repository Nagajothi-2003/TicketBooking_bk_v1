package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusRoute;
import com.example.demo.model.NewBusRoute;
import com.example.demo.repo.NewRouteRepo;
import com.example.demo.repo.RouteRepo;
import com.example.demo.service.RouteService;

@Service
public class Routeimpl implements RouteService {
	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private NewRouteRepo newRouteRepo;
	
	@Override
	public BusRoute createBusRoute(BusRoute busroute) {
		BusRoute save=routeRepo.save(busroute);
		return save;
	}
	

	
	@Override
	public BusRoute updateRoute(int route_id,BusRoute busroute) {
		BusRoute s=routeRepo.findById(route_id).get();
		s.setRoute_name(busroute.getRoute_name());
		s.setOrigin(busroute.getOrigin());
		s.setDestination(busroute.getDestination());
		s.setDuration(busroute.getDuration());
		s.setFare(busroute.getFare());
		
		return routeRepo.save(s);
	}
	


	
	@Override
	public List<BusRoute> getAllBusRoutes() {
	        return routeRepo.findAll();
	    }
	
	
//	NewBusRoute
	@Override
	public  NewBusRoute AddBusRoute(NewBusRoute newBusRoute) {
		NewBusRoute save=newRouteRepo.saveAndFlush(newBusRoute);
		return save;
	}
	
	@Override
	public List<NewBusRoute> findAllRoute(){
		List<NewBusRoute> s=newRouteRepo.findAll();
		return s;
	}
	
	@Override
	public NewBusRoute deleteBusRoute(int routeId) {
		NewBusRoute s=newRouteRepo.findById(routeId).get();
		if(s!=null) {
			newRouteRepo.delete(s);
		}
		return s;
	}
	@Override
	public List<String> getRoutesbyDestination(String destination){
		List<String> e =newRouteRepo.findByDestination(destination);
		return e;
		
	}
	
	@Override
	public List<String> getRoutesByPrefix(String prefix){
		List<String> e =newRouteRepo.findOriginsByPrefix(prefix);
		return e;
	}
	
}

