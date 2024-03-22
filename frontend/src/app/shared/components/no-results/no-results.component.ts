import { Component } from '@angular/core';
import { DevicesService } from '../../services/devices.service';

@Component({
  selector: 'app-no-results',
  standalone: true,
  imports: [],
  templateUrl: './no-results.component.html',
  styleUrl: './no-results.component.scss'
})
export class NoResultsComponent {

  constructor(
    private devicesService: DevicesService
  ) {}

  opneAddDeviceDialog() {
    this.devicesService.openAddDeviceDialog();
  }

}
