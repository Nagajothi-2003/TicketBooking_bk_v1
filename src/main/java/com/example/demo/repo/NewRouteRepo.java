package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.NewBusRoute;

public interface NewRouteRepo extends JpaRepository<NewBusRoute, Integer>{
	@Query("SELECT DISTINCT b.destination FROM NewBusRoute b WHERE b.destination LIKE %?1%")
	 List<String> findByDestination(String destination);
	
	 @Query("SELECT DISTINCT b.origin FROM NewBusRoute b WHERE b.origin LIKE %?1%")
	   List<String> findOriginsByPrefix(String prefix);
}
