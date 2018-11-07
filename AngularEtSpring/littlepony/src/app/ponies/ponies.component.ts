import { Component, OnInit, Input } from '@angular/core';
import { Pony } from '../pony';
import { PonyService } from '../pony.service';

@Component({
  selector: 'app-ponies',
  templateUrl: './ponies.component.html',
  styleUrls: ['./ponies.component.css']
})

export class PoniesComponent implements OnInit {
  @Input() ponies: Array<Pony>;

  constructor(private service: PonyService) {
    
  }

  ngOnInit() {
    this.service.getAllPonies().subscribe(p => this.ponies = p);
  }
}
