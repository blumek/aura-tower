import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditRemindQuestionDialogComponent } from './edit-remind-question-dialog.component';

describe('EditRemindQuestionDialogComponent', () => {
  let component: EditRemindQuestionDialogComponent;
  let fixture: ComponentFixture<EditRemindQuestionDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditRemindQuestionDialogComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EditRemindQuestionDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
