import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoResultsComponent } from './no-results.component';

describe('NoResultsComponent', () => {
  let component: NoResultsComponent;
  let fixture: ComponentFixture<NoResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NoResultsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NoResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
