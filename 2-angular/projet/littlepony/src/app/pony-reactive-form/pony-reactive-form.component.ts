import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms'
import { PonyService } from '../pony.service';
import { Router } from '@angular/router';
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

  constructor(private fb: FormBuilder, private servicePony: PonyService, private router: Router) {
    
   }

  ngOnInit() {
  }

  onSubmit()
  {
    let p: Pony = new Pony(this.ponyForm.value.name, this.ponyForm.value.age, this.ponyForm.value.weight, this.ponyForm.value.color);
    this.servicePony.addPony(p);
    this.router.navigate(['/Ponies']);
  }
}