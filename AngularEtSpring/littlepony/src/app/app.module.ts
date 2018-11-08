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
import { FormsModule } from '@angular/forms';
import { RaceFormComponent } from './race-form/race-form.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AccordionModule} from 'primeng/accordion';     //accordion and accordion tab
import { ReactiveFormsModule } from '@angular/forms';
import {PickListModule} from 'primeng/picklist';
import { PonyReactiveFormComponent } from './pony-reactive-form/pony-reactive-form.component';
import { RaceReactiveFormComponent } from './race-reactive-form/race-reactive-form.component';

import {HttpClientModule} from '@angular/common/http';
import { PonyComponent } from './pony/pony.component';
import { RaceComponent } from './race/race.component';
import { DeletePonyComponent } from './delete-pony/delete-pony.component';
import { DeleteRaceComponent } from './delete-race/delete-race.component';
import { ConnexionFormComponent } from './connexion-form/connexion-form.component';

const route: Routes = 
[
  {path: '', component: RacesComponent},
  {path: 'Ponies', component: PoniesComponent},
  {path: 'Races', component: RacesComponent},
  {path: 'addPonies', component: PonyReactiveFormComponent},
  {path: 'updatePony/:id', component: PonyReactiveFormComponent},
  {path: 'updateRace/:id', component: RaceReactiveFormComponent},
  {path: 'deletePony/:id', component: DeletePonyComponent},
  {path: 'deleteRace/:id', component: DeleteRaceComponent},
  {path: 'addRace', component: RaceReactiveFormComponent},
  {path: 'updateRace/:id', component: RaceReactiveFormComponent},
  {path: ':id', component: PonyComponent},
];


@NgModule({
  declarations: [
    AppComponent,
    PonyDetailComponent,
    PoniesComponent,
    RaceDetailComponent,
    RacesComponent,
    PonyFormComponent,
    RaceFormComponent,
    PonyReactiveFormComponent,
    RaceReactiveFormComponent,
    PonyComponent,
    RaceComponent,
    DeletePonyComponent,
    DeleteRaceComponent,
    ConnexionFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(route),
    FormsModule, 
    NgbModule, 
    AccordionModule,
    PickListModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
