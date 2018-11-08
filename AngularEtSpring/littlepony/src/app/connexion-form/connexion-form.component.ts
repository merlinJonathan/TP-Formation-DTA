import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-connexion-form',
  templateUrl: './connexion-form.component.html',
  styleUrls: ['./connexion-form.component.css']
})
export class ConnexionFormComponent implements OnInit {
  userForm = this.fb.group({
    logging: ['nom', Validators.required], 
    pass: ['motdepasse', Validators.required]
  });
  

  isConnected: boolean;
  constructor(private fb: FormBuilder) { 
    this.isConnected = sessionStorage.getItem('user') === null ? false: true;
  }

  ngOnInit() {}

  onSubmit()
  {
    if(this.isConnected === true)
    {
      this.isConnected = false;
      sessionStorage.removeItem('user');
    }
    else
    {
      this.isConnected = true;
      sessionStorage.setItem('user', this.userForm.value.logging);
    }
  }
}
