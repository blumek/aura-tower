import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainViewComponent } from './main-view.component';
import { MainViewRoutingModule } from './main-view-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DeviceComponent } from '../../shared/components/device/device.component';
import { NoResultsComponent } from '../../shared/components/no-results/no-results.component';
import { LoadingComponent } from '../../shared/components/loading/loading.component';
import { NavbarComponent } from '../../shared/components/navbar/navbar.component';
import { HeaderComponent } from '../../shared/components/header/header.component';
import { GroupManagementComponent } from './group-management/group-management.component';
import { WebSocketService } from '../../core/web-socket/web-socket.service';
import { webSocketServiceFactory } from '../../core/web-socket/web-socket-service-factory';


@NgModule({
  declarations: [
    MainViewComponent,
    DashboardComponent,
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
  ],
  providers: [
    {
      provide: WebSocketService,
      useFactory: webSocketServiceFactory,
    },
  ],
})
export class MainViewModule { }
