package com.vishal.parkinglot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vishal.parkinglot.jsonobject.SlotFlag;

public interface SlotFlagRepository extends MongoRepository<SlotFlag, String> {

	public SlotFlag findOneBySlotNumber(String slotNumber);
}
