import { Component, OnInit, EventEmitter, Output } from "@angular/core";
import { ParkingService } from '../app.service'

@Component({
  selector: "app-game-control",
  templateUrl: "./game-control.component.html",
  styleUrls: ["./game-control.component.css"],
  providers:[ParkingService]
})
export class GameControlComponent implements OnInit {
  @Output() intervalFired = new EventEmitter<number>();
  // randomNumber: number;
  // interval: any;
  availableSlots : any;
  checkIn : boolean = true;
  slotNumber : number ;

  constructor(
    private parkingService : ParkingService
  ) {}

  ngOnInit() {
    this.getAvailableSlots();
  }

  parkingVehicle(vehicleNumber) {
    if(vehicleNumber.value != null || vehicleNumber.value != "" || vehicleNumber.value != undefined) {
    console.log("value"+vehicleNumber.value);
    }
    vehicleNumber.value = "";
  }

  getAvailableSlots() {
    this.parkingService.getAvailableSlots().subscribe((data) => {
      this.availableSlots = data;
      this.availableSlots.sort((a, b) => a.slotNumber - b.slotNumber);
    }
    );
  }

  checkInOut(slotNumber) {
    this.slotNumber = slotNumber;
  }

  updateAvailableSlots(event) {
    this.availableSlots = event;
  }


  // startNumbersEmitting() {
  //   this.interval = setInterval(() => {
  //     this.randomNumber = Math.floor(Math.random() * 10);
  //     document.getElementById("randomNumberTag").innerHTML =
  //     "" + this.randomNumber;
  //     this.intervalFired.emit(this.randomNumber);
  //   }, 1000);
  // }

  // stopNumbersEmitting() {
  //   console.log("Stopping the emit");
  //   clearInterval(this.interval);
  // }
}
