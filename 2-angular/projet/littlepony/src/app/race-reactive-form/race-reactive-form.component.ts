import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RaceService } from '../race.service';
import { Pony } from '../pony';
import { Race } from '../race';
import { PonyService } from '../pony.service';

@Component({
  selector: 'app-race-reactive-form',
  templateUrl: './race-reactive-form.component.html',
  styleUrls: ['./race-reactive-form.component.css']
})
export class RaceReactiveFormComponent implements OnInit {
  participants: Array<Pony>;
  poneySelected: Array<Pony>;

  raceForm = this.fb.group({
    location: ['location', Validators.required],
    date: [new Date()],
    ponies: [null]
  });

  constructor(private router: Router, private fb: FormBuilder, private serviceRace: RaceService, private servicePoney: PonyService) {
    this.servicePoney.getAllPonies().subscribe( (p) => this.participants = p );
    this.poneySelected = [];
  }

  ngOnInit() {
  }

  onSubmit()
  {
    const dateForm: Date = new Date(this.raceForm.value.date.year, this.raceForm.value.date.month, this.raceForm.value.date.day);
    const r: Race = new Race(this.raceForm.value.location, dateForm);
    r.ponies = this.poneySelected;
    this.serviceRace.addRace(r);
    this.router.navigate(['/']);
  }
}
