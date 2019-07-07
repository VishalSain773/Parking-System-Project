package com.vishal.parkinglot.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.vishal.parkinglot.jsonobject.ParkingJSON;
import com.vishal.parkinglot.jsonobject.SlotFlag;

public interface ParkingRepository extends MongoRepository<ParkingJSON, String>{

	public ParkingJSON findOneByvehicleNo(String vehicleNo);
	//List<ParkingJSON> find(Query query, Class<ParkingJSON> class1);

}
