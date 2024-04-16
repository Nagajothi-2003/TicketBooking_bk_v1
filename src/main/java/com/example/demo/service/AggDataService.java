package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BusRouteDTO;
import com.example.demo.model.BusRoute;

public interface AggDataService {

	 List<BusRouteDTO> getDataByOriginDestinationAndDate(String origin,String destination, String date);
}
