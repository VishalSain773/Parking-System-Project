import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable() 
export class ParkingService {
    constructor( private _http: HttpClient) {}
    getAvailableSlots() {
      return this._http.get("http://localhost:8989/parkinglot/slotDisplay")
    }

    checkIn(slotNumber, vehicleNumber) {
        return this._http.get("http://localhost:8989/parkinglot/check-in/"+slotNumber+"/"+vehicleNumber)
    }
    
    fairPaid(vehicleNumber) {
        return this._http.get("http://localhost:8989/parkinglot/paid/"+vehicleNumber)
    }

    checkOut(vehicleNumber) {
        return this._http.get("http://localhost:8989/parkinglot/check-out/"+vehicleNumber)
    }

    getParkedVehicles() {
        return this._http.get("http://localhost:8989/parkinglot/parkedSlots");
    }
}
