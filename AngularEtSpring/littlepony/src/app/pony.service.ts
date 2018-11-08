import { Injectable } from '@angular/core';
import { Pony } from './pony';
import { PONIES } from './ponies-mock';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { RaceService } from './race.service';
import { Race } from './race';


@Injectable({
  providedIn: 'root'
})
export class PonyService { // equivalent a la DAO
  url: string = 'http://localhost:8090/api/ponies';
  httpOptions = {
    headers: new HttpHeaders({'Content-type': 'application/json'})
    
  };

  constructor(private http: HttpClient, private router: Router, private serviceRace: RaceService) { 
     
  }

  getAllPonies(): Observable<Array<Pony>>
  {
      return  this.http.get<Array<Pony>>(this.url + '/', this.httpOptions);
  }

  addPony(p: Pony) : void
  {
    this.http.post(this.url + '/addPony',p, this.httpOptions).subscribe(() => this.router.navigate(['/Ponies']));
  }

  getPony(id: number) : Observable<Pony>{
    return this.http.get<Pony>(this.url + '/' + id, this.httpOptions);
  }

  updatePony(p: Pony) : void
  {
    this.http.put(this.url + '/updatePony/' + p.id ,p, this.httpOptions).subscribe(() => this.router.navigate(['/Ponies']));
  }

  deletePony(id: number) : void
  {

    this.serviceRace.getAllRaces().subscribe((courses) => {
      let ponyParticipeCourse: boolean = false;

      for(let r of courses)
      {
        for(let p of r.ponies)
        {
          if(p.id === id)
          {
            ponyParticipeCourse = true;
          }
        }
      }

      if(ponyParticipeCourse === false)
      {
        this.http.delete(this.url + '/deletePony/' + id, this.httpOptions).subscribe(() => this.router.navigate(['/Ponies']));
      }
      else
      {
        console.log('Le pony participe a une course et ne peut etre supprimé');
        this.router.navigate(['/Ponies'])
      }
    });
  }
}
