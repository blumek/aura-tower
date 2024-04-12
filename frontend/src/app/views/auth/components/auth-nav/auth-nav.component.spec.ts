import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthNavComponent } from './auth-nav.component';

describe('AuthNavComponent', () => {
  let component: AuthNavComponent;
  let fixture: ComponentFixture<AuthNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AuthNavComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AuthNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
