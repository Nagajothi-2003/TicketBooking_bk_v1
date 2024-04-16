package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BusRoute;
@Repository
public interface RouteRepo extends JpaRepository<BusRoute, Integer>{
	 @Query("SELECT DISTINCT b.origin FROM BusRoute b WHERE b.origin LIKE %?1%")
	   List<String> findOriginsByPrefix(String prefix);
	 
	 @Query("SELECT DISTINCT b.destination FROM BusRoute b WHERE b.destination LIKE %?1%")
	 List<String> findByDestination(String destination);
	 
//	  List<BusRoute> findByOriginDestinationAndDate(String origin, String destination, String date);
	  @Query("SELECT br FROM BusRoute br WHERE br.origin = :origin AND br.destination = :destination AND br.date = :date")
	  List<BusRoute> findByOriginDestinationAndDate(@Param("origin") String origin, @Param("destination") String destination, @Param("date") String date);
}

