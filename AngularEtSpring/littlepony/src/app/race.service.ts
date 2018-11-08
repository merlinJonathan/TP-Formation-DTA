import { Injectable } from '@angular/core';
import { Race } from './race';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RaceService {
  url: String = 'http://localhost:8090/api/races'
  races: Array<Race>;
  constructor(private http: HttpClient, private router: Router) { 
  }

  httpOptions = {
    headers: new HttpHeaders({'content-type': 'application/json'})
  };

  getAllRaces(): Observable<Array<Race>>
  {
    return this.http.get<Array<Race>>(this.url +'/', this.httpOptions);
  }

  getRace(id: number): Observable<Race>
  {
    return this.http.get<Race>(this.url +'/' + id, this.httpOptions);
  }

  addRace(r: Race)
  {
      this.http.post(this.url + '/addRace', r, this.httpOptions ).subscribe(() => this.router.navigate(['/']));
  }

  updateRace(r: Race)
  {
    this.http.put<Race>(this.url +'/updateRace/' + r.id ,r,  this.httpOptions).subscribe(() => this.router.navigate(['/']));
  }

  deleteRace(id: number)
  {
    this.http.delete<Race>(this.url +'/deleteRace/' + id,  this.httpOptions).subscribe(() => this.router.navigate(['/']));
  
  }
}
