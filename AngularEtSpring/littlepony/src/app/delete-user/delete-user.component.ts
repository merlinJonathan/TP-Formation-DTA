import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.component.html',
  styleUrls: ['./delete-user.component.css']
})
export class DeleteUserComponent implements OnInit {

  constructor(private activatedroute: ActivatedRoute, private serviceUser: UserService) { }

  ngOnInit() {
    const id: number = parseInt(this.activatedroute.snapshot.paramMap.get('id'));
    this.serviceUser.deleteUser(id);
  }

}
