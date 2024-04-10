import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotPassComponent } from './forgot-pass.component';

describe('ForgotPassComponent', () => {
  let component: ForgotPassComponent;
  let fixture: ComponentFixture<ForgotPassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ForgotPassComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ForgotPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
