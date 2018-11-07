import { Component, OnInit } from '@angular/core';
import { getLocaleDateFormat, FormatWidth } from '@angular/common';
import { Race } from '../race';
import { RaceService } from '../race.service';
import { Router } from '@angular/router';
import { Pony } from '../pony';
import { PonyService } from '../pony.service';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-race-form',
  templateUrl: './race-form.component.html',
  styleUrls: ['./race-form.component.css']
})

export class RaceFormComponent implements OnInit {
  model: Race;
  participants: Array<Pony>;
  dateModel: NgbDateStruct;

  constructor(private service: RaceService,
    private router: Router, 
    private servicePony: PonyService,
    private calendar: NgbCalendar) {
      this.dateModel = this.calendar.getToday();
      this.model = new Race();
      this.servicePony.getAllPonies().subscribe((p) => this.participants = p);
   }

  ngOnInit() {
  }
  onSubmit()
  {
    this.dateModel.month -= 1; // pour corriger un bug où ca prenait le mois suivant

    this.model.date = new Date(this.dateModel.year, this.dateModel.month, this.dateModel.day);    
    this.service.addRace(this.model);
    this.router.navigate(['/']);
  }
}
