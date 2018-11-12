// This file is required by karma.conf.js and loads recursively all the .spec and framework files

import 'zone.js/dist/zone-testing';
import { getTestBed } from '@angular/core/testing';
import {
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting
} from '@angular/platform-browser-dynamic/testing';
import { Pony } from './app/pony';
import { Race } from './app/race';
import { createOfflineCompileUrlResolver } from '@angular/compiler';

declare const require: any;

// First, initialize the Angular testing environment.
/*getTestBed().initTestEnvironment(
  BrowserDynamicTestingModule,
  platformBrowserDynamicTesting()
);*/
// Then we find all the tests.
const context = require.context('./', true, /\.spec\.ts$/);
// And load the modules.
context.keys().map(context);

it('test unit', () => {
  const s = 'real value';
  expect(s).toBe('real value');
});

it('test pony', () => {
  const p = new Pony();
  expect(p.id).toBe(0);
});

// verifier qu'une course a bien une  liste de pony instancie
it('test liste poney dans une course', () => {
  const r = new Race();
  expect(r.ponies).toBeDefined();
});

// verifier qu'une course n'a pas de pony a la creation
it('verifier qu\'une la liste des participants est vide a l\'instanciation', () => {
  const r = new Race();
  expect(r.ponies.length).toBe(0);
});

// verifier le nom par defaut d'un poney
it('default name of pony', () => {
  const p = new Pony();
  expect(p.nom).toBe('nom');
});

// verifier la date par defaut d'une couse
it('default date on a Race', () => {
  let theDate: {
    y: number;
    m: number;
    d: number;
  };

  const r = new Race();
  const dateRace = {y: r.date.getFullYear(), m: r.date.getMonth(), d: r.date.getDay()};

  const d = new Date()
  const dateDate = {y: d.getFullYear(), m: d.getMonth(), d: d.getDay()};

  console.log(dateRace);
  console.log(dateDate);

  expect(dateRace).toEqual(dateDate);
});