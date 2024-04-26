import { NgClass } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-slider-stepper',
  standalone: true,
  imports: [NgClass],
  templateUrl: './slider-stepper.component.html',
  styleUrl: './slider-stepper.component.scss'
})
export class SliderStepperComponent implements OnInit {
  @Input() steps!: number;
  @Input() currentStep!: number;
  stepsArray: number[] = [];

  ngOnInit(): void {
    this.steps = this.steps < 0 ? 1 : this.steps;
    this.currentStep = this.currentStep < 0 ? 1 : this.currentStep;

    for (let i = 1; i <= this.steps; i++) {
      this.stepsArray.push(i);
    }
  }


}
