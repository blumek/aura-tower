import { ComponentFixture, TestBed } from '@angular/core/testing';
import { InfoComponent } from './info.component';

describe('InfoComponent', () => {
  let component: InfoComponent;
  let fixture: ComponentFixture<InfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [InfoComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create the component', () => {
    expect(component).toBeTruthy();
  });

  it('should display the info text', () => {
    const infoText = 'Sample info text';
    component.infoText = infoText;
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.info-text').textContent).toContain(infoText);
  });

  it('should not display info text if input is empty', () => {
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.info-text').textContent).toEqual('');
  });
});