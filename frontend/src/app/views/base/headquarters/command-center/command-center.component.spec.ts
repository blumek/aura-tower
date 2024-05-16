import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TowerCenterComponent } from './command-center.component';

describe('TowerCenterComponent', () => {
  let component: TowerCenterComponent;
  let fixture: ComponentFixture<TowerCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TowerCenterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(TowerCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
