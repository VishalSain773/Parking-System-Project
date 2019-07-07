package com.vishal.parkinglot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.vishal.parkinglot.jsonobject.ParkingJSON;
import com.vishal.parkinglot.jsonobject.SlotFlag;
import com.vishal.parkinglot.repository.ParkingRepository;
import com.vishal.parkinglot.repository.SlotFlagRepository;

@Service
public class ParkingService {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private SlotFlagRepository slotFlagRepository;
	
	@Autowired
	private ParkingRepository parkingRepository;
	
//	@Autowired
//	private ParkingJSON parkingJSON;
//	
//	@Autowired
//	private SlotFlag slotFlag;
	
	public List<SlotFlag> slotDisplay() {
		return slotFlagRepository.findAll();
	}
	
	public List<ParkingJSON> getAllParkedCars() {
		return parkingRepository.findAll();
	}
	
	public boolean checkIn(String slotNumber, String vehicleNo) {
		ParkingJSON parkingJSON = new ParkingJSON();
		SlotFlag slotFlag = new SlotFlag();
		System.out.println("SlotFlag.hashCode" + slotFlag.hashCode());
		for(SlotFlag slotFlagF : slotFlagRepository.findAll()) {
			System.out.println("slotFlag before F" + slotFlagF);
		}
		System.out.println("slotNumber " + slotNumber);
		System.out.println("vehicleNo " + vehicleNo);
		parkingJSON.setCheckInTime(System.currentTimeMillis());
		parkingJSON.setSlotNo(slotNumber);
		parkingJSON.setVehicleNo(vehicleNo);
		slotFlag.setSlotNumber(slotNumber);
		slotFlag.setBooked(true);
		ParkingJSON parkingSaved = parkingRepository.save(parkingJSON);
		SlotFlag slotFlagL = slotFlagRepository.findOneBySlotNumber(slotNumber);
		String id = slotFlagL.getId();
		System.out.println("id " + id);
		if(null != slotFlagL && slotFlagL.getSlotNumber().equals(slotNumber) && slotFlagL.isBooked() == false){
			System.out.println("slotFlagL " + slotFlagL);
			slotFlagRepository.deleteById(id);
			slotFlagRepository.save(slotFlag);
			
		}
		for(SlotFlag slotFlagF : slotFlagRepository.findAll()) {
			System.out.println("slotFlag F" + slotFlagF);
		}
			
		if(parkingSaved != null)
			return true;
		return false;
		
	}

	public ParkingJSON checkOut(String vehicleNo) {
		ParkingJSON parkingJSON = new ParkingJSON();
		SlotFlag slotFlag = new SlotFlag();
		Query query = new Query();
		query.addCriteria(Criteria.where("vehicleNo").is(vehicleNo));
		//List<ParkingJSON> parkingJSONList = mongoTemplate.find(query, ParkingJSON.class);
		ParkingJSON parkingJSONL = parkingRepository.findOneByvehicleNo(vehicleNo);
		//for(ParkingJSON parkingJSONL : parkingJSONList){
		String slotNumber = parkingJSONL.getSlotNo();
			long parkingTime = System.currentTimeMillis() - parkingJSONL.getCheckInTime();
			System.out.println(parkingTime);
			long timeInMin = (parkingTime/60000);
			parkingJSON.setSlotNo(parkingJSONL.getSlotNo());
			parkingJSON.setVehicleNo(parkingJSONL.getVehicleNo());
			parkingJSON.setPaid(parkingJSONL.isPaid());
			parkingJSON.setMoney(timeInMin);
			parkingRepository.delete(parkingJSONL);
		//}
		parkingRepository.save(parkingJSON);
		SlotFlag slotFlagL = slotFlagRepository.findOneBySlotNumber(slotNumber);
		String id = slotFlagL.getId();
		slotFlag.setSlotNumber(slotNumber);
		slotFlag.setBooked(false);
		System.out.println("id " + id);
		if(null != slotFlagL && slotFlagL.getSlotNumber().equals(slotNumber) && slotFlagL.isBooked() == true){
			System.out.println("slotFlagL " + slotFlagL);
			slotFlagRepository.deleteById(id);
			slotFlagRepository.save(slotFlag);
		}
		for(SlotFlag slotFlagF : slotFlagRepository.findAll()) {
			System.out.println("slotFlag F" + slotFlagF);
		}
		return parkingJSON;
	}

	public boolean paid(String vehicleNo) {
		ParkingJSON parkingJSON = new ParkingJSON();
		Query query = new Query();
		query.addCriteria(Criteria.where("vehicleNo").is(vehicleNo));
		ParkingJSON parkingJSONL = parkingRepository.findOneByvehicleNo(vehicleNo);
//		List<ParkingJSON> parkingJSONList = mongoTemplate.find(query, ParkingJSON.class);
//		for(ParkingJSON parkingJSONL : parkingJSONList){
			parkingJSON = parkingJSONL;
			parkingJSON.setPaid(true);
			parkingRepository.delete(parkingJSONL);
//		}
//		parkingRepository.save(parkingJSON);
		if(null != parkingJSON)
			return true;
		return false;
	}
}
