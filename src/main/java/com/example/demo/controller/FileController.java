package com.example.demo.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.NewOperatorBusSchedleDTO;
import com.example.demo.dto.RouteDto;
import com.example.demo.model.BusRoute;
import com.example.demo.model.NewBusRoute;
import com.example.demo.model.OperatorBusSchedule;
import com.example.demo.repo.NewBusScheduleRepo;
import com.example.demo.repo.NewRouteRepo;
import com.example.demo.repo.RouteRepo;

// Annotation 
@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private Environment env;
	
	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private NewBusScheduleRepo newBusScheduleRepo;
	@Autowired
	private NewRouteRepo newRouteRepo;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadedFile) {
		System.out.println("ghiu");
		if (uploadedFile.isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {

			byte[] bytes = uploadedFile.getBytes();
			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "C:\\Users\\Lenovo\\OneDrive\\Documents\\SpringBootProject\\Backendproject\\src\\main\\resources\\uploads\\";
//			String fileLocation = uploadsLocation + uuid + uploadedFile.getOriginalFilename();
			
			String image =uuid+uploadedFile.getOriginalFilename();
			String fileLocation =uploadsLocation+image;
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			
			BusRoute busRoute =new BusRoute();
			busRoute.setImage(image);
//			routeRepo.save(busRoute);
			
//			File file = new File(fileLocation);
			return ResponseEntity.status(HttpStatus.OK).body(image);

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());

		}
	}
	
	@PostMapping("/uploadProduct")
	public ResponseEntity<?> uploadProduct(@ModelAttribute RouteDto dto){
		if(dto.getFile().isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {
			byte[] bytes = dto.getFile().getBytes();
			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "C:\\Users\\Lenovo\\OneDrive\\Documents\\SpringBootProject\\Backendproject\\src\\main\\resources\\uploads\\";
			String fileLocation = uploadsLocation + uuid + dto.getFile().getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			File imageFile = new File(fileLocation);
			
			BusRoute busroute=new BusRoute();
			busroute.setRoute_name(dto.getRoute_name());
			busroute.setOrigin(dto.getOrigin());
			busroute.setDestination(dto.getDestination());
			busroute.setDuration(dto.getDuration());
			busroute.setFare(dto.getFare());
			busroute.setImage(imageFile.getName());
			busroute.setDate(dto.getDate());
			BusRoute savedEntity=routeRepo.save(busroute);
			return ResponseEntity.status(HttpStatus.OK).body(busroute);

		}
		 catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
			}
	}
	@PostMapping("/uploadSchedule/{routeId}")
	public ResponseEntity<?> uploadSchedule(@ModelAttribute NewOperatorBusSchedleDTO dto,@PathVariable int routeId ){
		if(dto.getFile().isEmpty()) {
			return new ResponseEntity<>("Please select a file!", HttpStatus.OK);
		}
		try {
			byte[] bytes = dto.getFile().getBytes();
			UUID uuid = UUID.randomUUID();
//			String uploadsLocation = env.getProperty("resource.uploads");
			String uploadsLocation = "C:\\Users\\Lenovo\\OneDrive\\Documents\\SpringBootProject\\Backendproject\\src\\main\\resources\\uploads\\";
			String fileLocation = uploadsLocation + uuid + dto.getFile().getOriginalFilename();
			Path path = Paths.get(fileLocation);
			Files.write(path, bytes);
			File imageFile = new File(fileLocation);
			OperatorBusSchedule operatorBusSchedule=new OperatorBusSchedule();
			operatorBusSchedule.setOperName(dto.getOperName());
			operatorBusSchedule.setDepTime(dto.getDepTime());
			operatorBusSchedule.setArrTime(dto.getArrTime());
			operatorBusSchedule.setPhone(dto.getPhone());
			operatorBusSchedule.setRating(dto.getRating());
//			
			operatorBusSchedule.setSeats(dto.getSeats());
			operatorBusSchedule.setBusType(dto.getBusType());
			operatorBusSchedule.setFare(dto.getFare());
			operatorBusSchedule.setImage(imageFile.getName());
			operatorBusSchedule.setDuration(dto.getDuration());
			operatorBusSchedule.setDate(dto.getDate());
			NewBusRoute s=newRouteRepo.findById(routeId).get();
			operatorBusSchedule.setNewBusRoute(s);
			OperatorBusSchedule	savedEntity=newBusScheduleRepo.save(operatorBusSchedule);
			return ResponseEntity.status(HttpStatus.OK).body(operatorBusSchedule);
			}
		 catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.CREATED).body(e.getMessage());
			}
	}
	
	
}
