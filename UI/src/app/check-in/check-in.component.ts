import { Component, OnInit, EventEmitter,Input, Output } from '@angular/core';
import { ParkingService } from '../app.service';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.css']
})
export class CheckInComponent implements OnInit {
  @Input('availableSlots') availableSlots : any;
  @Input('slotNumber') slotNumber : number;
  @Output() updateAvailableSlots = new EventEmitter<any>();

  parkedCarsList : any = [];

  constructor(private parkingService : ParkingService) { }

  ngOnInit() {
    this.getParkedCars();
  }

  getParkedCars() {
    let parkedCardList ;
    this.parkingService.getParkedVehicles().subscribe(data => {
      parkedCardList = data;
      parkedCardList.forEach(element => {
          this.parkedCarsList.push(element.vehicleNo);
      });
    })
  }

  updateSlots() {
    let tempArray : any;
    this.parkingService.getAvailableSlots().subscribe(data => {
      console.log(data)
      tempArray = data;
      tempArray.sort((a, b) => a.slotNumber - b.slotNumber);
      this.updateAvailableSlots.emit(tempArray);
    })
  }

  checkIn(vehicleNumber) {
    let emptySlot;
    // this.getParkedCars();
    // console.log(this.parkedCarsList);
    if(this.slotNumber != undefined && vehicleNumber.length !=  0 && !(this.parkedCarsList.some(e => e == vehicleNumber)) ) {
      this.parkingService.checkIn(this.slotNumber,vehicleNumber).subscribe((data) => {
        this.updateAvailableSlots.emit(data);
        this.getParkedCars();
        this.updateSlots()
        vehicleNumber = "";
      })
    } else if (this.slotNumber == undefined && vehicleNumber.length !=  0 && !(this.parkedCarsList.some(e => e == vehicleNumber))) {
      emptySlot = this.availableSlots.filter(x => x.booked == false)[0].slotNumber
      console.log(emptySlot);
      this.parkingService.checkIn(emptySlot,vehicleNumber).subscribe((data) => {
        this.updateAvailableSlots.emit(data);
        this.getParkedCars();
        this.updateSlots()
        vehicleNumber = "";
      })
    } else if ( this.parkedCarsList.some(e => e == vehicleNumber)) {
      alert("This vehicle is already parked! Please check out first")
    }
  }
}
