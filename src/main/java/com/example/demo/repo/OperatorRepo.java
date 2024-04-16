package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BusRoute;
import com.example.demo.model.Operator;
@Repository
public interface OperatorRepo extends JpaRepository<Operator, Integer>{
	  @Query("SELECT o FROM Operator o JOIN o.busSchedules bs WHERE bs.busRoute = :busRoute")
	    Operator findByBusRoute(@Param("busRoute") BusRoute busRoute);
}
