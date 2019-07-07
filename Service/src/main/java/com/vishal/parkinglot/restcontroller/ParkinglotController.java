package com.vishal.parkinglot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.parkinglot.jsonobject.ParkingJSON;
import com.vishal.parkinglot.jsonobject.SlotFlag;
import com.vishal.parkinglot.service.ParkingService;

@RestController
public class ParkinglotController {

	@Autowired
	private ParkingService parkingService;

	@GetMapping("/greetings")
	public String greetings() {
		return "greetings";
	}

	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*"})
	@GetMapping("/slotDisplay")
	public List<SlotFlag> slotDisplay() {
		return parkingService.slotDisplay();
	}
	
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*"})
	@GetMapping("/parkedSlots")
	public List<ParkingJSON> parkedSlots() {
		return parkingService.getAllParkedCars();
	}


	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*"})
	@GetMapping("/check-in/{slotNumber}/{vehicleNo}")
	public boolean checkIn(@PathVariable(value = "slotNumber") String slotNumber,
			@PathVariable(value = "vehicleNo") String vehicleNo) {

		return parkingService.checkIn(slotNumber, vehicleNo);
	}
	
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*"})
	@GetMapping("/check-out/{vehicleNo}")
	public ParkingJSON checkOut(@PathVariable(value = "vehicleNo") String vehicleNo) {

		return parkingService.checkOut(vehicleNo);
		
	}
	
	@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "*"})
	@GetMapping("/paid/{vehicleNo}")
	public boolean paid(@PathVariable(value = "vehicleNo") String vehicleNo) {
		return parkingService.paid(vehicleNo);
	}

}
