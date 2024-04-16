package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OperatorBusSchedule;

public interface NewBusScheduleRepo  extends JpaRepository<OperatorBusSchedule, Integer>{

}
