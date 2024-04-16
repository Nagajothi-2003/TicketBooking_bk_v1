 package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BusRoute;
import com.example.demo.model.BusSchedule;
import com.example.demo.model.Operator;
@Repository
public interface BusScheduleRepo extends JpaRepository<BusSchedule, Integer> {
//	 BusSchedule findByOperatorIdAndRouteId(int operatorId ,int route_id);

	  @Query("SELECT o FROM BusSchedule o WHERE o.busRoute = :busRoute")
	  List<BusSchedule> findByBusRoute(@Param("busRoute") BusRoute busRoute);

}
