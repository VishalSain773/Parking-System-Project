package com.vishal.parkinglot.jsonobject;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS) 
@Document(collection = "parkingjson")
public class ParkingJSON {
	
	@Id
	private String id;
	
	private String slotNo;
	
	private String vehicleNo;
	
	private long checkInTime;
	
	private double money;
	
	private boolean paid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSlotNo() {
		return slotNo;
	}

	public void setSlotNo(String slotNo) {
		this.slotNo = slotNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public long getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(long checkInTime) {
		this.checkInTime = checkInTime;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	@Override
	public String toString() {
		return "ParkingJSON [id=" + id + ", slotNo=" + slotNo + ", vehicleNo=" + vehicleNo + ", checkInTime="
				+ checkInTime + ", money=" + money + ", paid=" + paid + "]";
	}	

}
