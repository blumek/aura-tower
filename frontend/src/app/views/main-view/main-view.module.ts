import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DeviceComponent } from '../../shared/components/device/device.component';
import { NoResultsComponent } from '../../shared/components/no-results/no-results.component';

@NgModule({
  declarations: [
    MainViewComponent,
    DashboardComponent 
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    HeaderComponent,
    DeviceComponent,
    NoResultsComponent
  ]
})
export class MainViewModule { }
