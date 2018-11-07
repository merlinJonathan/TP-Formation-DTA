import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePonyComponent } from './delete-pony.component';

describe('DeletePonyComponent', () => {
  let component: DeletePonyComponent;
  let fixture: ComponentFixture<DeletePonyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeletePonyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeletePonyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
