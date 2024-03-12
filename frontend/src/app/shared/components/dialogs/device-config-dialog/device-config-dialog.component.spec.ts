import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeviceConfigDialogComponent } from './device-config-dialog.component';

describe('DeviceConfigDialogComponent', () => {
  let component: DeviceConfigDialogComponent;
  let fixture: ComponentFixture<DeviceConfigDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeviceConfigDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeviceConfigDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
