import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommandCenterComponent } from './command-center.component';

describe('TowerCenterComponent', () => {
  let component: CommandCenterComponent;
  let fixture: ComponentFixture<CommandCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CommandCenterComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CommandCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
