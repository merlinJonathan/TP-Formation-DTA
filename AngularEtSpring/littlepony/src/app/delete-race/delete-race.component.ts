import { Component, OnInit } from '@angular/core';
import { RaceService } from '../race.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-race',
  templateUrl: './delete-race.component.html',
  styleUrls: ['./delete-race.component.css']
})
export class DeleteRaceComponent implements OnInit {

  constructor(private route: Router, private serviceRace: RaceService, private routeActivated: ActivatedRoute) { }

  ngOnInit() {
    const id:  number = parseInt(this.routeActivated.snapshot.paramMap.get('id'));
    this.serviceRace.deleteRace(id);
  }
}
