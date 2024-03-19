import { Component } from '@angular/core';
import { mockDevices } from '../../../shared/mocks/devices';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {
  loading: boolean = false;
  mockData = mockDevices
}
