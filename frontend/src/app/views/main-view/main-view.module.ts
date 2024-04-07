import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DeviceComponent } from '../../shared/components/device/device.component';
import { NoResultsComponent } from '../../shared/components/no-results/no-results.component';
import { LoadingComponent } from '../../shared/components/loading/loading.component';
import { SettingsComponent } from './settings/settings.component';
import { NavbarComponent } from '../../shared/components/navbar/navbar.component';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { MatIconModule } from '@angular/material/icon';
import {MatExpansionModule} from '@angular/material/expansion';
import { GroupManagementComponent } from './group-management/group-management.component';


@NgModule({
  declarations: [
    MainViewComponent,
    DashboardComponent,
    SettingsComponent,
    GroupManagementComponent 
  ],
  imports: [
    CommonModule,
    MainViewRoutingModule,
    NavbarComponent,
    DeviceComponent,
    NoResultsComponent,
    LoadingComponent,
    HeaderComponent,
    MatExpansionModule,
    MatIconModule,
  ]
})
export class MainViewModule { }
