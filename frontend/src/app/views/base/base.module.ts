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
import { MatFormFieldModule } from '@angular/material/form-field';
import { ReactiveFormsModule } from '@angular/forms';
import { MatOptionModule } from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { InfoComponent } from '../../shared/components/info/info.component';
import { MatMenuModule } from '@angular/material/menu';

const components = [
  SliderStepperComponent,
  HeaderComponent,
  LoadingComponent,
  InfoComponent
]

const matModules = [
  MatOptionModule,
  MatInputModule, 
  MatIconModule,
  MatTooltipModule,
  MatFormFieldModule,
  MatSelectModule,
  MatMenuModule
]

@NgModule({
  declarations: [
    BaseComponent,
    HeadquartersComponent,
    TowerCenterComponent,
  ],
  imports: [
    CommonModule,
    BaseRoutingModule,
    TruncateTextDirective,
    ReactiveFormsModule,
    matModules,
    components
  ]
})
export class BaseModule { }
