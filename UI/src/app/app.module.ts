import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms'

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GameControlComponent } from './game-control/game-control.component';
import { OddComponent } from './odd/odd.component';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
import { EvenComponent } from './even/even.component';
import { DetailModalComponent } from './detail-modal/detail-modal.component';
import { ParkingService } from './app.service';
import { CheckInComponent } from './check-in/check-in.component';
import { CheckOutComponent } from './check-out/check-out.component';

@NgModule({
  declarations: [
    AppComponent,
    GameControlComponent,
    OddComponent,
    EvenComponent,
    DetailModalComponent,
    CheckInComponent,
    CheckOutComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ParkingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
