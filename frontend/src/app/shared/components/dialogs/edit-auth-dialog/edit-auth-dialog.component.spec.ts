import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAuthDialogComponent } from './edit-auth-dialog.component';

describe('EditAuthDialogComponent', () => {
  let component: EditAuthDialogComponent;
  let fixture: ComponentFixture<EditAuthDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditAuthDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditAuthDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
