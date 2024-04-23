import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { AppRoutingModule } from '../../app-routing.module';
import { IntroComponent } from './intro/intro.component';



@NgModule({
  declarations: [
    BaseComponent,
    IntroComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ]
})
export class BaseModule { }
