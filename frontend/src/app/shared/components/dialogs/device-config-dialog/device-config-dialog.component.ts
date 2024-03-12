import { Component } from '@angular/core';
import { MatStepperModule } from '@angular/material/stepper';

@Component({
  selector: 'app-device-config-dialog',
  standalone: true,
  imports: [MatStepperModule],
  templateUrl: './device-config-dialog.component.html',
  styleUrl: './device-config-dialog.component.scss'
})
export class DeviceConfigDialogComponent {

}
