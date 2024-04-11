import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResetPassComponent } from './reset-pass.component';

describe('ResetPassComponent', () => {
  let component: ResetPassComponent;
  let fixture: ComponentFixture<ResetPassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ResetPassComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ResetPassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
