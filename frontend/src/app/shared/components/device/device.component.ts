import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-device',
  standalone: true,
  imports: [NgIf, NgFor],
  templateUrl: './device.component.html',
  styleUrl: './device.component.scss'
})
export class DeviceComponent {
  @Input() deviceData: any = {}

  getObjectData(): string[] {
    return Object.keys(this.deviceData.data);
  }
}
