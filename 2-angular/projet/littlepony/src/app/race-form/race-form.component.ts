import { Component, OnInit } from '@angular/core';
import { Race } from '../race';
import { RaceService } from '../race.service';
import { Router } from '@angular/router';
import { Pony } from '../pony';
import { PonyService } from '../pony.service';

@Component({
  selector: 'app-race-form',
  templateUrl: './race-form.component.html',
  styleUrls: ['./race-form.component.css']
})
export class RaceFormComponent implements OnInit {
  model: Race;
  participants: Array<Pony>;
  ponySelected: Array<boolean>;
  constructor(private service: RaceService, private router: Router, private servicePony: PonyService) {
    this.model = new Race();
    this.servicePony.getAllPonies().subscribe((p) => this.participants = p);
    this.ponySelected = new Array(this.participants.length);
   }

  ngOnInit() {
  }
  onSubmit()
  {
    this.ponySelected.forEach( (e, i) => {
      if(e === true)
      {
          this.model.ponies.push(this.participants[i]);
      }
    });
    this.service.addRace(this.model);
    this.router.navigate(['/Races']);
  }
}
