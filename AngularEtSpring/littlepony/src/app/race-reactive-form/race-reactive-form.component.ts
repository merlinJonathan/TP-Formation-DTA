import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { RaceService } from '../race.service';
import { Pony } from '../pony';
import { Race } from '../race';
import { PonyService } from '../pony.service';
import { PoniesComponent } from '../ponies/ponies.component';
import { NgbDate} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-race-reactive-form',
  templateUrl: './race-reactive-form.component.html',
  styleUrls: ['./race-reactive-form.component.css']
})
export class RaceReactiveFormComponent implements OnInit {
  participants = Array<Pony>();
  poneySelected = Array<Pony>();

  raceForm = this.fb.group({
    location: ['location', Validators.required],
    date: [new NgbDate(2018, 2, 1), Validators.required],
    ponies: Array<Pony>()
  });

  add: boolean;
  id: number;
  constructor(private router: Router, private fb: FormBuilder, private serviceRace: RaceService, private servicePoney: PonyService, private routeActivated: ActivatedRoute) {

  }

  ngOnInit() {

    if (this.routeActivated.snapshot.paramMap.get('id') === null) {
      this.add = true;
    
      this.servicePoney.getAllPonies().subscribe((p) => {
        this.participants = p;
      });
    }
    else {
      this.add = false;
      this.id = parseInt(this.routeActivated.snapshot.paramMap.get('id'));


      // recuperation des poneys de la course et du trie des poneys ny participants pas
      this.serviceRace.getRace(this.id).subscribe(r => {

        this.raceForm.setValue({
          location: r.location,
          date: r.date,
          ponies: r.ponies
        });
        this.poneySelected = this.raceForm.value.ponies;
    
        this.servicePoney.getAllPonies().subscribe((p) => {
          this.participants = p;
          for(const pony of r.ponies) {
            this.participants = this.participants.filter(e => e.id !== pony.id);
          }
        });
      });

      
      // ajout des poneys de la courses dans les poney selectionné du picker list
      this.participants.forEach((p, i) =>
      {
        for (let ponySelec of this.poneySelected) {
          if (p.id === ponySelec.id)
          {
            this.participants.splice(this.participants.indexOf(p), 1);
          }
        }
      });
    }
  }

  onSubmit() {
    if(this.add)
    {
      this.raceForm.value.date.month -= 1; // pour corriger un bug ou c'est toujours le mois suivant qui apparait
      const dateForm: Date = new Date(this.raceForm.value.date.year, this.raceForm.value.date.month, this.raceForm.value.date.day);
      const r: Race = new Race(this.raceForm.value.location, dateForm);
      r.ponies = this.poneySelected;
      this.serviceRace.addRace(r);
    }
    else
    {
        let r = new Race(this.raceForm.value.location, new Date(this.raceForm.value.date.year, this.raceForm.value.date.month-1, this.raceForm.value.date.day));
        r.id = this.id;
        r.ponies = this.raceForm.value.ponies;
        this.serviceRace.updateRace(r);

    }
  }
}
