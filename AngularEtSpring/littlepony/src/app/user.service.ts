import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url: string = 'http://localhost:8090/api/users';

  httpOptions = {
    headers: new HttpHeaders({'content-type': 'application/json'})
  };

  constructor(private http: HttpClient, private router: Router) { }

  getAllUsers(): Observable<Array<User>>
  {
    return this.http.get<Array<User>>(this.url +'/', this.httpOptions);
  }

  getUser(id: number): Observable<User>
  {
    return this.http.get<User>(this.url +'/' + id, this.httpOptions);
  }

  addUser(user: User): void
  {
    this.http.post(this.url + '/addUser',user, this.httpOptions ).subscribe(() => this.router.navigate(['/users']));
  }

  updateUser(user: User): void
  {
    this.http.put(this.url + '/updateUser',user, this.httpOptions ).subscribe(() => this.router.navigate(['/']));
  }

  deleteUser(id: number): void
  {
    this.http.delete(this.url + '/deleteUser/' + id, this.httpOptions ).subscribe(() => this.router.navigate(['/users']));
  }
}
