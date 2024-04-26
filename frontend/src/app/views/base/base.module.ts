import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { IntroComponent } from './intro/intro.component';
import { BaseRoutingModule } from './base-routing.module';
import { SliderStepperComponent } from '../../shared/components/slider-stepper/slider-stepper.component';

const components = [
  SliderStepperComponent
]

@NgModule({
  declarations: [
    BaseComponent,
    IntroComponent
  ],
  imports: [
    CommonModule,
    BaseRoutingModule,
    components
  ]
})
export class BaseModule { }
