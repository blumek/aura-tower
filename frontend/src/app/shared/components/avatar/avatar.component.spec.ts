import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MatTooltipModule } from '@angular/material/tooltip';
import { AvatarComponent } from './avatar.component';

describe('AvatarComponent', () => {
  let component: AvatarComponent;
  let fixture: ComponentFixture<AvatarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AvatarComponent],
      imports: [MatTooltipModule]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvatarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should generate initials from sourceName', () => {
    component.sourceName = 'John Doe';
    component.ngOnInit();
    expect(component.initials).toEqual('JD');
  });

  it('should set color based on sourceName', () => {
    component.sourceName = 'John Doe';
    component.ngOnInit();
    expect(component.color).toBeDefined();
  });

  it('should set default color and initials if sourceName is not provided', () => {
    component.ngOnInit();
    expect(component.color).toEqual('#fff');
    expect(component.initials).toEqual('?');
  });

  it('should set tooltip when hover is true', () => {
    component.hover = true;
    component.sourceName = 'John Doe';
    component.ngOnInit();
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    const spanElement = compiled.querySelector('span');
    expect(spanElement.getAttribute('matTooltip')).toContain('John Doe');
  });

  it('should not set tooltip when hover is false', () => {
    component.hover = false;
    component.sourceName = 'John Doe';
    component.ngOnInit();
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    const spanElement = compiled.querySelector('span');
    expect(spanElement.getAttribute('matTooltip')).toBeNull();
  });

  it('should adjust font size based on size input', () => {
    const size = 100;
    component.size = size;
    component.sourceName = 'John Doe';
    component.ngOnInit();
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    const spanElement = compiled.querySelector('span');
    expect(spanElement.style.fontSize).toEqual(`${size / 2.5}px`);
  });

  it('should adjust height and width of container based on size input', () => {
    const size = 100;
    component.size = size;
    component.sourceName = 'John Doe';
    component.ngOnInit();
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    const containerElement = compiled.querySelector('.avatar-container');
    expect(containerElement.style.height).toEqual(`${size}px`);
    expect(containerElement.style.width).toEqual(`${size}px`);
  });
});