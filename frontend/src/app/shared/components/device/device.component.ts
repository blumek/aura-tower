import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../dialogs/confirmation-dialog/confirmation-dialog.component';
import { LoadingComponent } from '../loading/loading.component';
import { TruncateTextDirective } from '../../directives/truncate-text.directive';
import { Metric } from '../../../views/main-view/models/devices';

@Component({
  selector: 'at-device',
  standalone: true,
  imports: [NgIf, NgFor, MatMenuModule, MatIconModule, MatDialogModule, LoadingComponent, TruncateTextDirective],
  templateUrl: './device.component.html',
  styleUrl: './device.component.scss',
})
export class DeviceComponent {
  @Input() metricData!: Metric;

  constructor(public dialog: MatDialog) {}

  getObjectData(): string[] {
    return Object.keys(this.metricData.device.data);
  }

  openEditDialog(): void {}

  openOrderingDialog(): void {}

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Delete the device?',
        content: 'Deleting the device will cause the loss of all its stored data and it will no longer be visible on the dashboard',
        cancelButtonText: 'Cancel',
        acceptButtonText: 'Delete'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
