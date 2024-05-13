import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { BaseRoutingModule } from './base-routing.module';
import { SliderStepperComponent } from '../../shared/components/slider-stepper/slider-stepper.component';
import { HeadquartersComponent } from './headquarters/headquarters.component';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { LoadingComponent } from '../../shared/components/loading/loading.component';
import { TowerCenterComponent } from './headquarters/tower-center/tower-center.component';
import { TruncateTextDirective } from '../../shared/directives/truncate-text.directive';
import { MatTooltipModule } from '@angular/material/tooltip';

const components = [
  SliderStepperComponent,
  HeaderComponent,
  LoadingComponent
]

@NgModule({
  declarations: [
    BaseComponent,
    HeadquartersComponent,
    TowerCenterComponent
  ],
  imports: [
    CommonModule,
    BaseRoutingModule,
    TruncateTextDirective,
    MatTooltipModule,
    components
  ]
})
export class BaseModule { }
