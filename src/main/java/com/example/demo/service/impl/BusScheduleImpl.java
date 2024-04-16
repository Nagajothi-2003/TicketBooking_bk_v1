package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.BusRoute;
import com.example.demo.model.BusSchedule;
import com.example.demo.model.NewBusRoute;
import com.example.demo.model.Operator;
import com.example.demo.model.OperatorBusSchedule;
import com.example.demo.repo.BusScheduleRepo;
import com.example.demo.repo.NewBusScheduleRepo;
import com.example.demo.repo.NewRouteRepo;
import com.example.demo.repo.OperatorRepo;
import com.example.demo.service.BusScheduleService;

import jakarta.persistence.EntityManager;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import com.example.demo.repo.RouteRepo;

@Service
public class BusScheduleImpl implements BusScheduleService{
@Autowired
private BusScheduleRepo busScheduleRepo;

@Autowired
private OperatorRepo operaorRepo;
@Autowired
private RouteRepo busRouteRepo;

@Autowired
private NewRouteRepo newRouteRepo;
@Autowired
private NewBusScheduleRepo newBusScheduleRepo;
@PersistenceContext
private EntityManager entityManager;
//new
	@Override
	public OperatorBusSchedule addSchedule(int routeId, OperatorBusSchedule operatorBusSchedule) {
		NewBusRoute s=newRouteRepo.findById(routeId).get();
		operatorBusSchedule.setNewBusRoute(s);
		OperatorBusSchedule saveshedule=newBusScheduleRepo.saveAndFlush(operatorBusSchedule);
		return saveshedule;
	}
	@Override
	public List<OperatorBusSchedule> getBusSchedule(String origin, String destination, String date) {
	    TypedQuery<OperatorBusSchedule> query = entityManager.createQuery(
	            "SELECT bs FROM OperatorBusSchedule bs " +
	            "JOIN FETCH bs.newBusRoute br " + // Joining with BusRoute
	            "WHERE br.origin = :origin " +
	            "AND br.destination = :destination " +
	            "AND br.date = :date",
	            OperatorBusSchedule.class);

	    query.setParameter("origin", origin);
	    query.setParameter("destination", destination);
	    query.setParameter("date", date);
	    return query.getResultList();
	}
	
	@Override
	public OperatorBusSchedule deleteBusSchedule(int id) {
		OperatorBusSchedule v=newBusScheduleRepo.findById(id).get();
		if (v!=null) {
			newBusScheduleRepo.delete(v);
		}
		return v;
	}
	
//  "SELECT bs FROM BusSchedule bs JOIN bs.busRoute br WHERE br.origin = :origin AND br.destination = :destination AND br.date = :date",
//  BusSchedule.class);

	
	
	@Override
	public BusSchedule  createschedule(int operatorId,int route_id,BusSchedule busSchedule) {
//		BusSchedule s=busScheduleRepo.save(busSchedule);
//				return s;
		Operator operator =operaorRepo.findById(operatorId).get(); 
		busSchedule.setOperator(operator);
		BusRoute busroute= busRouteRepo.findById(route_id).get();
		busSchedule.setBusRoute(busroute);
		BusSchedule saveshedule =busScheduleRepo.save(busSchedule);
		return saveshedule;
	}
	@Override
	public List<BusSchedule> getAllSchedule() {
		List<BusSchedule> bus =busScheduleRepo.findAll();
		return bus;
	}
	@Override
	public BusSchedule getBusSchedule(int schedule_id){
		BusSchedule saveshedule	=busScheduleRepo.findById(schedule_id).get();
		return saveshedule;
	}

//	public List<BusSchedule> getBusSchedulesWithRouteAndOperator(String origin, String destination, String date) {
	@Override
	public List<BusSchedule> getBusSchedules(String origin, String destination, String date) {
	    TypedQuery<BusSchedule> query = entityManager.createQuery(
	            "SELECT bs FROM BusSchedule bs " +
	            "JOIN FETCH bs.busRoute br " + // Joining with BusRoute
	            "JOIN FETCH bs.operator op " + // Joining with Operator
	            "WHERE br.origin = :origin " +
	            "AND br.destination = :destination " +
	            "AND br.date = :date",
	            BusSchedule.class);

	    query.setParameter("origin", origin);
	    query.setParameter("destination", destination);
	    query.setParameter("date", date);
	    return query.getResultList();
	}

	@Override
	 public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepo.findAll();
    }

}

//@Override
//public BusSchedule getSchedulesByOperatorAndRoute(int operatorId, int routeId) {
//   return busScheduleRepo.findByOperatorIdAndRouteId(operatorId, routeId);
//}
//
//@Override
//public ResponseEntity<?> getSchedule(int page,int size ) {
//	PageRequest.of(1, 2);
////	List<BusSchedule> posts=busScheduleRepo.findAll(PageRequest.of(page,size)).toList();
//	List<BusSchedule> posts = busScheduleRepo.findAll(
//			PageRequest.of(
//					page, size, 
//					Sort.by("scheduleid").descending()
//					)).toList();
//	return ResponseEntity
//			.status(HttpStatus.OK)
////			.body(posts);
//	 PageRequest pageable = PageRequest.of(page, size, Sort.by("schedule_id").descending());
//
//	    // Fetch paginated data from the repository
//	    List<BusSchedule> posts = busScheduleRepo.findAll(pageable).toList();
//
//	    // Return the paginated data in a ResponseEntity
//	    return ResponseEntity
//	            .status(HttpStatus.OK)
//	            .body(posts);
//	
//}

//extra


//public List<BusSchedule> getBusSchedules(String origin, String destination, String date) {
//  TypedQuery<BusSchedule> query = entityManager.createQuery(
//          "SELECT bs FROM BusSchedule bs JOIN bs.busRoute br WHERE br.origin = :origin AND br.destination = :destination AND br.date = :date",
//          BusSchedule.class);
//
//  query.setParameter("origin", origin);
//  query.setParameter("destination", destination);
//  query.setParameter("date", date);
//  return query.getResultList();
//}
