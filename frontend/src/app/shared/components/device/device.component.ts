import { NgFor, NgIf } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule, MatDialog } from '@angular/material/dialog';
import { ConfirmationDialogComponent } from '../dialogs/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-device',
  standalone: true,
  imports: [NgIf, NgFor, MatMenuModule, MatIconModule, MatDialogModule],
  templateUrl: './device.component.html',
  styleUrl: './device.component.scss',
})
export class DeviceComponent {
  @Input() deviceData: any = {};

  constructor(public dialog: MatDialog) {}

  getObjectData(): string[] {
    return Object.keys(this.deviceData.data);
  }

  refreshDeviceData(): void {}

  openEditDialog(): void {}

  openOrderingDialog(): void {}

  openDeleteDialog(): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      minWidth: '300px',
      data: {
        title: 'Usunąć urządzenie?',
        content: 'Usunięcie urządzenia spwoduje utratę wszystkich jego zapisanych danych oraz nie będzie ono już wyświetlane na panelu głównym',
        cancelButtonText: 'Anuluj',
        acceptButtonText: 'Usuń'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
