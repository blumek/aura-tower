import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base.component';
import { AppRoutingModule } from '../../app-routing.module';



@NgModule({
  declarations: [
    BaseComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule
  ]
})
export class BaseModule { }
