import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SliderStepperComponent } from './slider-stepper.component';

describe('SliderStepperComponent', () => {
  let component: SliderStepperComponent;
  let fixture: ComponentFixture<SliderStepperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SliderStepperComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SliderStepperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
