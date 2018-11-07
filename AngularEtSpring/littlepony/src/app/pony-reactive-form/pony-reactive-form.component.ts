import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { PonyService } from '../pony.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Pony } from '../pony';




@Component({
  selector: 'app-pony-reactive-form',
  templateUrl: './pony-reactive-form.component.html',
  styleUrls: ['./pony-reactive-form.component.css']
})
export class PonyReactiveFormComponent implements OnInit {
  ponyForm = this.fb.group({
    name: ['nom', Validators.required], 
    age: ['0', Validators.required], 
    color: ['color', Validators.required],
    weight: ['0', Validators.required]
  });

  add: boolean;
  id: number;
  constructor(private fb: FormBuilder, private servicePony: PonyService, private router: Router, private routeActive: ActivatedRoute) {
    
   }

  ngOnInit() {
    if( this.routeActive.snapshot.paramMap.get('id') === null)
    {
        this.add = true;
    }
    else
    {
      this.add = false;
      this.id = parseInt(this.routeActive.snapshot.paramMap.get('id'));
      this.servicePony.getPony(parseInt(this.routeActive.snapshot.paramMap.get('id'))).subscribe(p=> this.ponyForm.setValue({
        name: p.nom, 
        age: p.age, 
        color: p.color,
        weight: p.age
      }));
    }
  }

  onSubmit()
  {
    if(this.add)
    {
      let p: Pony = new Pony(this.ponyForm.value.name, this.ponyForm.value.age, this.ponyForm.value.weight, this.ponyForm.value.color);
      this.servicePony.addPony(p);
    }
    else
    {
        const ponyUpdated = new Pony();

        ponyUpdated.id = this.id;
        ponyUpdated.nom = this.ponyForm.value.name;
        ponyUpdated.age = this.ponyForm.value.age;
        ponyUpdated.color = this.ponyForm.value.color;
        ponyUpdated.weight = this.ponyForm.value.weight;

        this.servicePony.updatePony(ponyUpdated);
    }
  }
}