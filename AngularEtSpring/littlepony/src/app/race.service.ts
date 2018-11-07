import { Injectable } from '@angular/core';
import { Race } from './race';
import { RACES } from './race-mock';
import { of, Observable } from 'rxjs';
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
}
