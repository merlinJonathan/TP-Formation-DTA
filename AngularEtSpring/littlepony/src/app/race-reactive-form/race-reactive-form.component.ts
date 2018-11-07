import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
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

  add: boolean;
  id: number;
  constructor(private router: Router, private fb: FormBuilder, private serviceRace: RaceService, private servicePoney: PonyService, private routeActivated: ActivatedRoute) {
    this.poneySelected = [];
  }

  ngOnInit() {
    this.servicePoney.getAllPonies().subscribe( (p) => this.participants = p );
    if(this.routeActivated.snapshot.paramMap.get('id') === null)
    {
      this.add = true;
    }
    else
    {
      this.add = false;
      this.id = parseInt(this.routeActivated.snapshot.paramMap.get('id'));

      this.serviceRace.getRace(this.id).subscribe(r => this.raceForm.setValue({
        location: r.location,
        date: r.date,
        ponies: r.ponies
      }));

      /*for(let p of this.participants)
      {

      }*/
    }
  }

  onSubmit()
  {
    this.raceForm.value.date.month -= 1; // pour corriger un bug ou c'est toujours le mois suivant qui apparait
    const dateForm: Date = new Date(this.raceForm.value.date.year, this.raceForm.value.date.month, this.raceForm.value.date.day);
    const r: Race = new Race(this.raceForm.value.location, dateForm);
    r.ponies = this.poneySelected;
    this.serviceRace.addRace(r);
  }
}
