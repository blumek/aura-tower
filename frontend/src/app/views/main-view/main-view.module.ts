import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { SharedModule } from '../../shared/shared.module';
import { MainViewRoutingModule } from './main-view-routing.module';



@NgModule({
  declarations: [
    MainViewComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    MainViewRoutingModule
  ]
})
export class MainViewModule { }
