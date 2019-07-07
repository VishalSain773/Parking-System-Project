import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  evenNumber : number;
  oddNumber : number;
  randomNumber : number;

  onIntervalFiler(randomNumber : number) {
    this.randomNumber = randomNumber;

    if(randomNumber % 2 == 1)
    this.oddNumber = randomNumber;
    else 
    this.evenNumber = randomNumber;

    console.log(randomNumber);
  }
}
