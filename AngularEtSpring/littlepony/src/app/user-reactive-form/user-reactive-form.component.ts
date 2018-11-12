import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Validators } from '@angular/forms';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-reactive-form',
  templateUrl: './user-reactive-form.component.html',
  styleUrls: ['./user-reactive-form.component.css']
})
export class UserReactiveFormComponent implements OnInit {
  userForm = this.fb.group({
    logging: ['', Validators.required],
    password: ['', Validators.required],
    role: ['', Validators.required]
  });

  add: boolean = false;
  id: number;
  constructor(private serviceUser: UserService, private fb: FormBuilder, private activatedRoute: ActivatedRoute) { 
  }

  ngOnInit() {
    
    if(this.activatedRoute.snapshot.paramMap.get('id') === null)
    {
        // formulaire d'ajout
      this.add = true;
    }
    else
    {
      // formulaire de modification
      this.id = parseInt(this.activatedRoute.snapshot.paramMap.get('id'));
        this.add = false;
        this.serviceUser.getUser(this.id).subscribe( u => {
            this.userForm.setValue({
              logging: u.nom,
              password: u.password,
              role: u.role
            });
        });
    }
  }

  onSubmit()
  {
    if(this.id !== null)
    {
      // en cas de modification
      let user = new User(this.userForm.value.logging, this.userForm.value.password, this.userForm.value.role);
      user.id = this.id;
      this.serviceUser.updateUser(user);
    }
    else
    {
        // en cas d'ajout
        this.serviceUser.addUser(new User(this.userForm.value.logging, this.userForm.value.password, this.userForm.value.role));
    }
  }
}
