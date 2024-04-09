import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NoResultsComponent } from './no-results.component';

describe('NoResultsComponent', () => {
  let component: NoResultsComponent;
  let fixture: ComponentFixture<NoResultsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NoResultsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NoResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display mainTitle and description', () => {
    component.mainTitle = 'Test Title';
    component.description = 'Test Description';
    fixture.detectChanges();
    const element: HTMLElement = fixture.nativeElement;
    expect(element.textContent).toContain('Test Title');
    expect(element.textContent).toContain('Test Description');
  });

  it('should call buttonAction when button is clicked', () => {
    const mockButtonAction = jasmine.createSpy('buttonAction');
    component.buttonAction = mockButtonAction;
    fixture.detectChanges();
    const button: HTMLButtonElement = fixture.nativeElement.querySelector('button');
    button.click();
    expect(mockButtonAction).toHaveBeenCalled();
  });
});