import { Component, OnInit, Output, EventEmitter } from "@angular/core";
import { ParkingService } from "../app.service";

@Component({
  selector: "app-check-out",
  templateUrl: "./check-out.component.html",
  styleUrls: ["./check-out.component.css"]
})
export class CheckOutComponent implements OnInit {
  @Output() updateAvailableSlots = new EventEmitter<any>();

  parkingFare: number;
  slotNumber: any;
  vehicleNumber: any;

  constructor(private parkingService: ParkingService) {}

  ngOnInit() {}

  updateSlots() {
    let tempArray: any;
    this.parkingService.getAvailableSlots().subscribe(data => {
      console.log(data);
      tempArray = data;
      tempArray.sort((a, b) => a.slotNumber - b.slotNumber);
      this.updateAvailableSlots.emit(tempArray);
    });
  }

  checkOut(vehicleNumber) {
    console.log("Fair Paid", vehicleNumber);
    if (vehicleNumber.length != 0) {
      let localData: any;
      this.parkingService.checkOut(vehicleNumber).subscribe(data => {
        localData = data;
        this.parkingFare = localData.money;
        this.slotNumber = localData.slotNo;
      });
      this.parkingService.fairPaid(vehicleNumber).subscribe(data => {
        console.log(data);
      });
      this.updateSlots();
    }
  }
}
