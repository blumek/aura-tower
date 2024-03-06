import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { HeaderComponent } from '../../shared/components/header/header.component';

@NgModule({
  declarations: [
    MainViewComponent 
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    HeaderComponent
  ]
})
export class MainViewModule { }
