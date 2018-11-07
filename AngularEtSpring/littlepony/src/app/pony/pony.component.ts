import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PonyService } from '../pony.service';
import { Pony } from '../pony';

@Component({
  selector: 'app-pony',
  templateUrl: './pony.component.html',
  styleUrls: ['./pony.component.css']
})
export class PonyComponent implements OnInit {
  pony: Pony;
  constructor(private route: ActivatedRoute, private servicePony: PonyService) { 
    this.pony = new Pony();
  }

  ngOnInit() {
    const id: number = parseInt(this.route.snapshot.paramMap.get('id'), 0);
    this.servicePony.getPony(id).subscribe(p =>this.pony = p);
  }

}
