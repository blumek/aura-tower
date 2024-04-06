import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { LoadingComponent } from './loading.component';
import { By } from '@angular/platform-browser';

describe('LoadingComponent', () => {
  let component: LoadingComponent;
  let fixture: ComponentFixture<LoadingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LoadingComponent],
      imports: [MatProgressSpinnerModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display spinner without blur when blur input is false', () => {
    const spinnerElement: HTMLElement = fixture.nativeElement.querySelector('mat-spinner');
    expect(spinnerElement).toBeTruthy();
    const blurElement: HTMLElement = fixture.nativeElement.querySelector('.blur');
    expect(blurElement).toBeFalsy();
  });

  it('should display spinner with blur when blur input is true', () => {
    component.blur = true;
    fixture.detectChanges();
    const spinnerElement: HTMLElement = fixture.nativeElement.querySelector('mat-spinner');
    expect(spinnerElement).toBeTruthy();
    const blurElement: HTMLElement = fixture.nativeElement.querySelector('.blur');
    expect(blurElement).toBeTruthy();
  });

  it('should set spinner diameter to 60', () => {
    const spinnerElement: HTMLElement = fixture.nativeElement.querySelector('mat-spinner');
    const diameterAttribute = spinnerElement.getAttribute('diameter');
    expect(diameterAttribute).toBe('60');
  });

  it('should have mat-spinner element', () => {
    const spinnerElement = fixture.debugElement.query(By.css('mat-spinner'));
    expect(spinnerElement).toBeTruthy();
  });

  it('should not have blur div element when blur input is false', () => {
    const blurElement = fixture.debugElement.query(By.css('.blur'));
    expect(blurElement).toBeFalsy();
  });

  it('should have blur div element when blur input is true', () => {
    component.blur = true;
    fixture.detectChanges();
    const blurElement = fixture.debugElement.query(By.css('.blur'));
    expect(blurElement).toBeTruthy();
  });
});