import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users = new Array<User>();
  constructor(private service: UserService) {}

  ngOnInit() {
    this.service.getAllUsers().subscribe(u => this.users = u);
  }
}
