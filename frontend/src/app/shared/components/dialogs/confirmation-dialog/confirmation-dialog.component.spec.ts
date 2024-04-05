import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatDialogModule, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from './confirmation-dialog.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

describe('ConfirmationDialogComponent', () => {
  let component: ConfirmationDialogComponent;
  let fixture: ComponentFixture<ConfirmationDialogComponent>;
  let dialogRefMock: MatDialogRef<ConfirmationDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ConfirmationDialogComponent],
      imports: [MatDialogModule, BrowserAnimationsModule],
      providers: [
        { provide: MAT_DIALOG_DATA, useValue: {} },
        { provide: MatDialogRef, useValue: dialogRefMock }
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmationDialogComponent);
    component = fixture.componentInstance;
    dialogRefMock = TestBed.inject(MatDialogRef);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display dialog title', () => {
    const data = {
      title: 'Test Title',
      content: 'Test Content',
      cancelButtonText: 'Cancel',
      acceptButtonText: 'Accept'
    };
    component.data = data;
    fixture.detectChanges();
    const titleElement: HTMLElement = fixture.nativeElement.querySelector('.mat-dialog-title');
    expect(titleElement.textContent).toContain('Test Title');
  });

  it('should display dialog content', () => {
    const data = {
      title: 'Test Title',
      content: 'Test Content',
      cancelButtonText: 'Cancel',
      acceptButtonText: 'Accept'
    };
    component.data = data;
    fixture.detectChanges();
    const contentElement: HTMLElement = fixture.nativeElement.querySelector('.mat-dialog-content p');
    expect(contentElement.textContent).toContain('Test Content');
  });

  it('should close dialog when cancel button clicked', () => {
    spyOn(dialogRefMock, 'close');
    const cancelButton: HTMLButtonElement = fixture.nativeElement.querySelector('.buttons-container button:first-child');
    cancelButton.click();
    expect(dialogRefMock.close).toHaveBeenCalled();
  });

  it('should close dialog when accept button clicked', () => {
    spyOn(dialogRefMock, 'close');
    const acceptButton: HTMLButtonElement = fixture.nativeElement.querySelector('.buttons-container button:last-child');
    acceptButton.click();
    expect(dialogRefMock.close).toHaveBeenCalledWith(true);
  });
});