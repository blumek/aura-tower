import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeadquartersComponent } from './headquarters.component';

describe('HeadquartersComponent', () => {
  let component: HeadquartersComponent;
  let fixture: ComponentFixture<HeadquartersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HeadquartersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HeadquartersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
