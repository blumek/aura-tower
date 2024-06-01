import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { BaseRoutingModule } from './base-routing.module';
import { SliderStepperComponent } from '../../shared/components/slider-stepper/slider-stepper.component';
import { HeadquartersComponent } from './headquarters/headquarters.component';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { LoadingComponent } from '../../shared/components/loading/loading.component';
import { CommandCenterComponent } from './headquarters/command-center/command-center.component';
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
import { SettingsComponent } from './settings/settings.component';
import { MatExpansionModule } from '@angular/material/expansion';
import { AvatarComponent } from '../../shared/components/avatar/avatar.component';

const components = [
  SliderStepperComponent,
  HeaderComponent,
  LoadingComponent,
  InfoComponent,
  AvatarComponent
]

const matModules = [
  MatOptionModule,
  MatInputModule, 
  MatIconModule,
  MatTooltipModule,
  MatFormFieldModule,
  MatSelectModule,
  MatMenuModule,
  MatExpansionModule
]

@NgModule({
  declarations: [
    BaseComponent,
    HeadquartersComponent,
    CommandCenterComponent,
    SettingsComponent
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
