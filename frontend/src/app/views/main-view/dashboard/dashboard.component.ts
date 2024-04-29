import { Component, OnInit } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Device } from '../models/devices';
import { DevicesService } from '../services/devices.service';
import { SnackbarService } from '../../../shared/services/snackbar.service';

@Component({
  selector: 'at-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent implements OnInit {
  loading: boolean = false;
  devices = [];
  homeName = 'Domek Jordana'
  data$!: Observable<Device[]>
  deviceData!: Device[]

  constructor(
    private deviceService: DevicesService,
    private snackbarService: SnackbarService
  ){}

  ngOnInit(): void {
    this.getDevicesData()
  }

  getDevicesData(): void {
    this.data$ = this.deviceService.fetchDevicesData().pipe(
      catchError(err => {
        this.snackbarService.openSnackBar('Błąd pobierania danych urządzeń', true)
        return throwError(() => err)
      })
    )
  }

  openAddDeviceDialog(): void {
    this.deviceService.openAddDeviceDialog();
  }

  openAddDeviceDialogFnc = this.openAddDeviceDialog.bind(this)

}
