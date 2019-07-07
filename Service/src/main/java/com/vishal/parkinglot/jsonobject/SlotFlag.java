package com.vishal.parkinglot.jsonobject;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS) 
@Document(collection = "SlotFlag")
public class SlotFlag {
	
	@Id
	private String id;
	
	private String slotNumber;
	
	private boolean booked;

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	@Override
	public String toString() {
		return "SlotFlag [id=" + id + ", slotNumber=" + slotNumber + ", booked=" + booked + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
