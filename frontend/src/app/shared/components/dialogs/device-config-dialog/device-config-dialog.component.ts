import { Component, Inject } from '@angular/core';
import { MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatStepperModule } from '@angular/material/stepper';
import { IConfirmationDialogData } from '../../../models/dialogs';
import { InfoComponent } from '../../info/info.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';



@Component({
  selector: 'at-device-config-dialog',
  standalone: true,
  imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatStepperModule, InfoComponent, FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule],
  templateUrl: './device-config-dialog.component.html',
  styleUrl: './device-config-dialog.component.scss'
})
export class DeviceConfigDialogComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: IConfirmationDialogData) {}

}
