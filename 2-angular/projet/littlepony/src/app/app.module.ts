import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PonyDetailComponent } from './pony-detail/pony-detail.component';
import { PoniesComponent } from './ponies/ponies.component';
import { RaceDetailComponent } from './race-detail/race-detail.component';
import { RacesComponent } from './races/races.component';
import { RouterModule, Routes, Router} from '@angular/router';
import { PonyFormComponent } from './pony-form/pony-form.component';
import { Form, FormsModule } from '@angular/forms';
import { RaceFormComponent } from './race-form/race-form.component';

const route: Routes = 
[
  {path: '', component: RacesComponent},
  {path: 'Ponies', component: PoniesComponent},
  {path: 'Races', component: RacesComponent},
  {path: 'addPonies', component: PonyFormComponent},
  {path: 'addRace', component: RaceFormComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    PonyDetailComponent,
    PoniesComponent,
    RaceDetailComponent,
    RacesComponent,
    PonyFormComponent,
    RaceFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(route),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
