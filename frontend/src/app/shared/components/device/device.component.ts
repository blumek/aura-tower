import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../dialogs/confirmation-dialog/confirmation-dialog.component';
import { LoadingComponent } from '../loading/loading.component';
import { IDevice } from '../../models/devices';
import { TruncateTextDirective } from '../../directives/truncate-text.directive';

@Component({
  selector: 'app-device',
  standalone: true,
  imports: [NgIf, NgFor, MatMenuModule, MatIconModule, MatDialogModule, LoadingComponent, TruncateTextDirective],
  templateUrl: './device.component.html',
  styleUrl: './device.component.scss',
})
export class DeviceComponent {
  @Input() deviceData!: IDevice;

  constructor(public dialog: MatDialog) {}

  getObjectData(): string[] {
    return Object.keys(this.deviceData.deviceData);
  }

  refreshDeviceData(): void {}

  openEditDialog(): void {}

  openOrderingDialog(): void {}

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: {
        title: 'Usunąć urządzenie?',
        content: 'Usunięcie urządzenia spwoduje utratę wszystkich jego zapisanych danych oraz nie będzie ono już widoczne na panelu głównym',
        cancelButtonText: 'Anuluj',
        acceptButtonText: 'Usuń'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
