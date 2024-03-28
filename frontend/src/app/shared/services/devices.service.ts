import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeviceConfigDialogComponent } from '../components/dialogs/device-config-dialog/device-config-dialog.component';
import { HttpClient } from '@angular/common/http';
import { IDevice } from '../models/devices';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DevicesService {

  constructor(
    private http: HttpClient,
    private dialog: MatDialog,
  ) { }

  openAddDeviceDialog(): void {
    const dialogRef = this.dialog.open(DeviceConfigDialogComponent , {
      data: {
        title: 'Dodaj nowe urządzenie',
        content: '',
        cancelButtonText: 'Anuluj',
        acceptButtonText: 'Kolejny krok'
      }
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }

  fetchDevicesData(): Observable<IDevice[]> {
    return this.http.get<IDevice[]>(environment.metrics.base)
  }
}
