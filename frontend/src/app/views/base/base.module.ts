import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { BaseRoutingModule } from './base-routing.module';
import { SliderStepperComponent } from '../../shared/components/slider-stepper/slider-stepper.component';
import { HeadquartersComponent } from './headquarters/headquarters.component';

const components = [
  SliderStepperComponent
]

@NgModule({
  declarations: [
    BaseComponent,
    HeadquartersComponent
  ],
  imports: [
    CommonModule,
    BaseRoutingModule,
    components
  ]
})
export class BaseModule { }
