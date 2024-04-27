import { NgClass, NgIf } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-slider-stepper',
  standalone: true,
  imports: [NgClass, NgIf],
  templateUrl: './slider-stepper.component.html',
  styleUrl: './slider-stepper.component.scss'
})
export class SliderStepperComponent implements OnInit {
  @Input() steps!: number;
  @Input() currentStep!: number;
  @Output() currentStepChange = new EventEmitter<number>();
  stepsArray: number[] = [];

  ngOnInit(): void {
    this.currentStep = this.currentStep <= 0 ? 0 : this.currentStep;

    for (let i = 1; i <= this.steps; i++) {
      this.stepsArray.push(i);
    }
  }

  changeStep(step: number) {
    this.currentStepChange.emit(step);
  }


}
